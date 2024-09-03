**Java JDBC**（Java Database Connectivity）は、Javaアプリケーションがデータベースとやり取りするための標準APIです。JDBCは、データベース管理システム（DBMS）に対する操作（データの読み書き、更新、削除など）を行うための共通インターフェースを提供します。これにより、Javaプログラムは異なる種類のデータベース（MySQL、PostgreSQL、Oracle、SQL Serverなど）に対しても同じコードでアクセスすることが可能になります。

### JDBCの主な要素

JDBC APIは、データベース操作に必要な以下の主要な要素を提供します。

1. **ドライバマネージャ (`DriverManager`)**
2. **接続 (`Connection`)**
3. **ステートメント (`Statement`)**
4. **結果セット (`ResultSet`)**
5. **例外 (`SQLException`)**

#### 1. ドライバマネージャ (`DriverManager`)

`DriverManager`クラスは、JDBCドライバを管理し、データベースとの接続を確立するために使用されます。`DriverManager.getConnection()`メソッドを使用して、データベースへの接続を確立します。

#### 2. 接続 (`Connection`)

`Connection`インターフェースは、特定のデータベースとの接続を表します。接続が確立されると、SQL文を実行し、結果を取得するためのインターフェースが提供されます。`Connection`オブジェクトは、データベースへのトランザクションの開始、コミット、およびロールバックも管理します。

#### 3. ステートメント (`Statement`)

`Statement`インターフェースは、SQL文をデータベースに送信するために使用されます。`Statement`、`PreparedStatement`、および`CallableStatement`の3つの主要なタイプがあります。

- **`Statement`**: 単純なSQL文を実行するために使用されます。
- **`PreparedStatement`**: 事前にコンパイルされたSQL文を実行します。パラメータ化されたクエリをサポートし、効率的で安全です。
- **`CallableStatement`**: ストアドプロシージャを呼び出すために使用されます。

#### 4. 結果セット (`ResultSet`)

`ResultSet`インターフェースは、`Statement`や`PreparedStatement`で実行されたSQLクエリの結果を表します。`ResultSet`オブジェクトは、結果のデータを表形式で保持し、カーソルを使用してそのデータを順次処理することができます。

#### 5. 例外 (`SQLException`)

JDBC操作中に発生するエラーは`SQLException`で処理されます。このクラスは、エラーメッセージ、SQLステート、ベンダー固有のエラーコードなど、データベース関連のエラーに関する情報を提供します。

### JDBCの基本的な操作

以下に、Java JDBCを使用してデータベースに接続し、データをクエリする基本的な手順を示します。

#### 1. データベースに接続

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

このコードでは、`DriverManager.getConnection()`メソッドを使って、データベースに接続しています。接続が成功すると、`Connection`オブジェクトが返され、データベース操作に使用できます。

#### 2. SQL文の実行

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCQueryExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT id, name, age FROM users";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

このコードでは、`Statement`オブジェクトを使用してSQLクエリをデータベースに送信し、その結果を`ResultSet`オブジェクトで受け取っています。`ResultSet`を使ってクエリ結果を順次処理しています。

#### 3. データの挿入、更新、削除

データの挿入、更新、削除を行うためには、`executeUpdate()`メソッドを使用します。

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sqlInsert = "INSERT INTO users (name, age) VALUES ('John Doe', 30)";
            String sqlUpdate = "UPDATE users SET age = 31 WHERE name = 'John Doe'";
            String sqlDelete = "DELETE FROM users WHERE name = 'John Doe'";

            try (Statement statement = connection.createStatement()) {
                int rowsInserted = statement.executeUpdate(sqlInsert);
                System.out.println("Rows inserted: " + rowsInserted);

                int rowsUpdated = statement.executeUpdate(sqlUpdate);
                System.out.println("Rows updated: " + rowsUpdated);

                int rowsDeleted = statement.executeUpdate(sqlDelete);
                System.out.println("Rows deleted: " + rowsDeleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### まとめ

Java JDBCは、Javaアプリケーションからデータベースにアクセスするための標準的なAPIです。データベースとの接続、SQL文の実行、結果の取得など、データベース操作に必要な機能が網羅されています。`Connection`、`Statement`、`ResultSet`などの主要なインターフェースを使うことで、簡単にデータベース操作を行うことができます。また、例外処理を適切に行うことで、データベース操作中のエラーに対処することができます。
