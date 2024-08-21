`ALTER TABLE` コマンドは、SQLで既存のテーブルの構造を変更するために使用されます。これにより、テーブルに新しい列を追加したり、既存の列のデータ型を変更したり、列を削除したり、制約（制約条件）を追加または削除することができます。

以下に、`ALTER TABLE` コマンドのさまざまな用途について解説します。

### 基本構文
```sql
ALTER TABLE table_name
{ADD | MODIFY | DROP | RENAME} ...;
```

### 1. **列の追加** (`ADD`)
既存のテーブルに新しい列を追加する場合は、`ADD`を使用します。

#### 例: 列の追加
```sql
ALTER TABLE employees
ADD salary NUMBER(8, 2);
```
このコマンドは、`employees` テーブルに `salary` という名前の列を追加し、そのデータ型を `NUMBER(8, 2)` とします（8桁の数字で小数点以下2桁）。

### 2. **列の変更** (`MODIFY`)
既存の列のデータ型や制約を変更する場合は、`MODIFY`を使用します。

#### 例: 列のデータ型の変更
```sql
ALTER TABLE employees
MODIFY salary NUMBER(10, 2);
```
このコマンドは、`salary` 列のデータ型を変更し、最大10桁の数値で小数点以下2桁に設定します。

### 3. **列の削除** (`DROP`)
既存のテーブルから列を削除する場合は、`DROP`を使用します。

#### 例: 列の削除
```sql
ALTER TABLE employees
DROP COLUMN salary;
```
このコマンドは、`employees` テーブルから `salary` 列を削除します。

### 4. **列の名前変更** (`RENAME`)
列の名前を変更する場合は、`RENAME`を使用します。

#### 例: 列の名前変更
```sql
ALTER TABLE employees
RENAME COLUMN salary TO annual_salary;
```
このコマンドは、`employees` テーブル内の `salary` 列の名前を `annual_salary` に変更します。

### 5. **制約の追加** (`ADD CONSTRAINT`)
テーブルに新しい制約（例えば主キー、外部キー、一意制約など）を追加する場合は、`ADD CONSTRAINT`を使用します。

#### 例: 主キーの追加
```sql
ALTER TABLE employees
ADD CONSTRAINT pk_employee_id PRIMARY KEY (employee_id);
```
このコマンドは、`employees` テーブルの `employee_id` 列に対して主キー制約を追加します。

#### 例: 外部キーの追加
```sql
ALTER TABLE employees
ADD CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES departments(department_id);
```
このコマンドは、`employees` テーブルの `department_id` 列に対して外部キー制約を追加し、それが `departments` テーブルの `department_id` 列を参照するようにします。

### 6. **制約の削除** (`DROP CONSTRAINT`)
既存の制約を削除する場合は、`DROP CONSTRAINT`を使用します。

#### 例: 制約の削除
```sql
ALTER TABLE employees
DROP CONSTRAINT fk_department_id;
```
このコマンドは、`employees` テーブルの `fk_department_id` 外部キー制約を削除します。

### 7. **テーブル名の変更** (`RENAME`)
テーブル自体の名前を変更する場合は、`RENAME`を使用します。

#### 例: テーブル名の変更
```sql
ALTER TABLE employees
RENAME TO staff;
```
このコマンドは、`employees` テーブルの名前を `staff` に変更します。

### まとめ
`ALTER TABLE` コマンドは、データベーススキーマを柔軟に管理するために非常に重要です。このコマンドを使用することで、テーブルの列や制約の追加、削除、変更、名前変更などが可能になります。
