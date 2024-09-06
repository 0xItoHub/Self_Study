1. JDBCを使ったデータベース操作
まず、JDBCを使ってデータベースからデータを取得し、結果をコレクションに格納する例を紹介します。検索結果をリストに保持する方法が一般的です。

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExample {
    public static void main(String[] args) {
        // データベース接続情報
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        // 検索結果を格納するリスト
        List<MyEntity> resultList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, name FROM my_table")) {

            // 結果セットを処理してオブジェクトに変換
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // MyEntity オブジェクトを作成し、リストに追加
                MyEntity entity = new MyEntity(id, name);
                resultList.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 結果リストの処理
        for (MyEntity entity : resultList) {
            System.out.println(entity);
        }
    }
}

// データベースの結果を格納するエンティティクラス
class MyEntity {
    private int id;
    private String name;

    public MyEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyEntity{id=" + id + ", name='" + name + "'}";
    }
}
