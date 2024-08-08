`UPDATE`文は、データベース内の既存のレコードを変更するために使用されるSQLコマンドです。特定の条件に一致する行の値を更新することができます。以下に`UPDATE`文の基本構文といくつかの例を示します。

### 基本構文

```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

- **table_name**: 更新するテーブルの名前。
- **SET**: 更新するカラムと新しい値を指定します。複数のカラムを更新する場合は、カンマで区切って列挙します。
- **WHERE**: 更新する行を指定する条件。この条件を省略するとテーブル内のすべての行が更新されます。

### 例: 単一カラムの更新

従業員のテーブルから、特定の従業員の給与を更新する場合：

```sql
UPDATE Employees
SET salary = 5000
WHERE employee_id = 1;
```

このクエリは、`employee_id`が1である従業員の`salary`を5000に更新します。

### 例: 複数カラムの更新

複数のカラムを同時に更新する場合：

```sql
UPDATE Employees
SET salary = 5000, department_id = 4
WHERE employee_id = 1;
```

このクエリは、`employee_id`が1である従業員の`salary`を5000に、`department_id`を4に更新します。

### 例: 条件付きの更新

部門IDが3のすべての従業員の給与を500増やす場合：

```sql
UPDATE Employees
SET salary = salary + 500
WHERE department_id = 3;
```

このクエリは、`department_id`が3であるすべての従業員の`salary`を500増やします。

### 注意点
- **WHERE句の省略**: `WHERE`句を省略すると、テーブル内のすべての行が更新されるため、意図しないデータの変更を防ぐために注意が必要です。
- **トランザクション**: 大量の行を更新する場合、トランザクションを使用して変更をロールバックできるようにすることが推奨されます。

これらの例を参考にして、目的に応じた`UPDATE`文を使用することで、データベース内のデータを適切に更新することができます。
