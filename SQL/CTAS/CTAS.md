`CREATE TABLE AS SELECT`文は、SQLで新しいテーブルを作成し、そのテーブルに他のテーブルから選択したデータを挿入するために使用されます。これは、既存のデータを新しいテーブルにコピーしたり、集計結果を保存したりするのに便利です。

以下は一般的な構文と例です。

### 構文
```sql
CREATE TABLE 新しいテーブル名 AS
SELECT 列1, 列2, ...
FROM 元のテーブル名
WHERE 条件;
```

### 例
例えば、`employees` テーブルから `department_id` が `101` の従業員のデータを新しいテーブル `dept_101_employees` に保存したい場合、次のようにします。

```sql
CREATE TABLE dept_101_employees AS
SELECT employee_id, first_name, last_name, department_id
FROM employees
WHERE department_id = 101;
```

このクエリは、`employees` テーブルから `department_id` が `101` である行を選択し、その選択結果を `dept_101_employees` という新しいテーブルに保存します。新しいテーブルには、`employee_id`, `first_name`, `last_name`, `department_id` の列が含まれます。

注意点として、この新しいテーブルは元のテーブルの構造をそのままコピーしますが、インデックスや制約などはコピーされません。必要に応じて、新しいテーブルに対してこれらを手動で追加する必要があります。

________________________________________________________________________________________________________________________________________________________________________________________________________________________

(問題)
```CREATE TABLE emp_copy AS SELECT * FROM employees;```
正しい記述はどれですか（2 つ選択してください）。

（解答）
・emp_copy 表にはemployees 表のすべての行がコピーされる。
・mp_copy 表にはemployees 表のNOT NULL 制約のみがコピーされる。

(重要)
・CREATE TABLE AS SELECT文で、WHERE条件を指定しない「SELECT * FROM <表名>」を実行すると、表定義とすべての行をコピーできます
・CREATE TABLE AS SELECT文一般にいえることですが、コピーされる制約はNOT NULL制約のみです

（NG例）
・emp_copy 表は空の表として作成される。
→　空の表ではなくコピー

・emp_copy 表にはemployees 表のすべての制約がコピーされる。
→　コピーされる制約はNOT NULL制約のみ
