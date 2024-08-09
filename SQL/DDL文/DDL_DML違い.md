DDL (Data Definition Language) と DML (Data Manipulation Language) は、SQLにおける2つの主要なコマンドグループであり、それぞれ異なる目的で使用されます。以下に、その違いと各グループの主要なコマンドを説明します。

### DDL (Data Definition Language)
DDLは、データベースの構造やスキーマを定義および変更するためのコマンド群です。これには、テーブルやインデックスの作成、変更、削除が含まれます。

#### 主なDDLコマンド
1. **CREATE**:
   - 新しいデータベースオブジェクト（テーブル、インデックス、ビューなど）を作成します。
   - 例: `CREATE TABLE employees (id INT, name VARCHAR(50));`

2. **ALTER**:
   - 既存のデータベースオブジェクトの構造を変更します。たとえば、テーブルに新しい列を追加したり、既存の列を変更したりします。
   - 例: `ALTER TABLE employees ADD COLUMN salary DECIMAL(10, 2);`

3. **DROP**:
   - 既存のデータベースオブジェクトを削除します。テーブルやインデックスなどを完全に削除します。
   - 例: `DROP TABLE employees;`

4. **TRUNCATE**:
   - テーブルの全データを削除しますが、テーブル自体は残します（ただし、これはDDLと見なされます）。
   - 例: `TRUNCATE TABLE employees;`

### DML (Data Manipulation Language)
DMLは、データベース内のデータを操作するためのコマンド群です。これには、データの挿入、更新、削除、および検索が含まれます。

#### 主なDMLコマンド
1. **SELECT**:
   - テーブルからデータを検索して取得します。
   - 例: `SELECT * FROM employees;`

2. **INSERT**:
   - 新しいデータをテーブルに挿入します。
   - 例: `INSERT INTO employees (id, name, salary) VALUES (1, 'John Doe', 50000);`

3. **UPDATE**:
   - 既存のデータを更新します。
   - 例: `UPDATE employees SET salary = 55000 WHERE id = 1;`

4. **DELETE**:
   - 既存のデータを削除します。
   - 例: `DELETE FROM employees WHERE id = 1;`

### DDLとDMLの違い

- **目的**:
  - **DDL**: データベースオブジェクトの定義や管理を行う（テーブルの作成、削除、構造変更など）。
  - **DML**: データベース内のデータを操作する（データの挿入、更新、削除、取得など）。

- **トランザクションの扱い**:
  - **DDL**: 通常、即座にコミットされ、ロールバックができないことが多い。
  - **DML**: トランザクション内で使用され、ロールバックが可能。

- **影響範囲**:
  - **DDL**: データベースのスキーマや構造に影響を与える。
  - **DML**: テーブル内のデータにのみ影響を与える。

### 例:
- **DDLの例**:
  - 新しいテーブルを作成: `CREATE TABLE students (id INT, name VARCHAR(50));`
  - テーブルの列を変更: `ALTER TABLE students ADD COLUMN age INT;`
  - テーブルを削除: `DROP TABLE students;`

- **DMLの例**:
  - データを挿入: `INSERT INTO students (id, name, age) VALUES (1, 'Alice', 20);`
  - データを更新: `UPDATE students SET age = 21 WHERE id = 1;`
  - データを削除: `DELETE FROM students WHERE id = 1;`

このように、DDLとDMLはSQLにおける異なる操作のためのコマンド群であり、それぞれの役割を理解することで、データベースの設計と操作がより効果的に行えます。
