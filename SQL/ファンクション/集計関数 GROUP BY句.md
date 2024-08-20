`GROUP BY`句と集計関数は、SQLでデータをグループ化して集計するための基本的な手法です。特にデータベース内のデータを集計したり、統計を取ったりする際に非常に有用です。

### 集計関数とは

集計関数は、データを集約し、特定の計算結果を返すために使用されます。これらの関数は、`GROUP BY`句と一緒に使われることが多いです。主な集計関数は次の通りです。

- **COUNT()**: 行の数を数えます。
- **SUM()**: 列の数値の合計を計算します。
- **AVG()**: 列の数値の平均を計算します。
- **MAX()**: 列の最大値を返します。
- **MIN()**: 列の最小値を返します。

### GROUP BY句とは

`GROUP BY`句は、指定された列の値でデータをグループ化し、各グループに対して集計関数を適用します。`GROUP BY`句を使用することで、複数の行をグループ化し、それぞれのグループに対する集計結果を取得することができます。

### 基本的な構文

```sql
SELECT column_name, AGGREGATE_FUNCTION(column_name)
FROM table_name
GROUP BY column_name;
```

### 例

#### 1. COUNT関数とGROUP BY句

以下のクエリでは、各部署に所属する従業員の人数を計算します。

```sql
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;
```

このクエリは、`department_id`でグループ化し、各部署に所属する従業員の人数を数えます。

#### 2. SUM関数とGROUP BY句

次のクエリでは、各部署の従業員の合計給与を計算します。

```sql
SELECT department_id, SUM(salary)
FROM employees
GROUP BY department_id;
```

このクエリは、各部署の従業員の給与の合計を計算します。

#### 3. AVG関数とGROUP BY句

各部署の平均給与を計算するには、`AVG`関数を使います。

```sql
SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id;
```

このクエリは、各部署ごとの平均給与を計算します。

#### 4. MAX、MIN関数とGROUP BY句

次に、各部署の最高給与と最低給与を求めるクエリの例です。

```sql
SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id;
```

このクエリは、各部署ごとの最高給与と最低給与を返します。

### 注意点

- `GROUP BY`句を使用する場合、集計関数と共に表示される列は、すべて`GROUP BY`句に含まれている必要があります。
- `GROUP BY`句が適用された場合、データは指定された列の値に基づいてグループ化され、それぞれのグループに対して集計が行われます。

### まとめ

- **集計関数**は、データを集計するための関数であり、`SUM`や`AVG`、`COUNT`などが含まれます。
- **GROUP BY句**は、データをグループ化して集計する際に使用されます。
