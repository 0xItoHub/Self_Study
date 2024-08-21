`IS NULL` と `IS NOT NULL` は、SQLでデータベースのクエリを実行する際に、特定の列の値がNULLであるかどうかを判定するための条件式です。

### 1. `IS NULL`
- `IS NULL` は、指定された列の値が `NULL` であるレコードを選択するために使用します。 `NULL` はデータが存在しないことを意味します。

#### 例:
```sql
SELECT * 
FROM employees 
WHERE manager_id IS NULL;
```
このクエリは、`manager_id` が `NULL` の従業員をすべて選択します。

### 2. `IS NOT NULL`
- `IS NOT NULL` は、指定された列の値が `NULL` ではないレコードを選択するために使用します。つまり、値が存在するレコードのみを取得します。

#### 例:
```sql
SELECT * 
FROM employees 
WHERE manager_id IS NOT NULL;
```
このクエリは、`manager_id` に値が入っている従業員をすべて選択します。

これらの条件は、データベースでNULL値を取り扱う際に非常に重要です。特にNULLは他の値とは異なる特性を持っており、等号(=)や不等号(!=)で比較することができないため、`IS NULL` と `IS NOT NULL` が使用されます。
