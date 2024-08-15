`DELETE` 文で `EXISTS` と `NOT EXISTS` を使用することで、他のテーブルやクエリの結果に基づいて行を削除することができます。`EXISTS` と `NOT EXISTS` は、サブクエリ内で行の存在をチェックし、その結果に基づいて削除を行います。これらは主に関連するテーブルにデータが存在するかどうかで条件を指定したい場合に使用されます。

### `EXISTS` を使った削除

`EXISTS` は、サブクエリが少なくとも1行を返す場合に `TRUE` を返します。この `TRUE` の結果に基づいて、`DELETE` 文は行を削除します。

#### 構文
```sql
DELETE FROM テーブル名 t
WHERE EXISTS (SELECT 1 FROM 他のテーブル o WHERE t.条件 = o.条件);
```

- **`EXISTS` の動作**: サブクエリの中で、`t` テーブルの行が `o` テーブルの条件に一致する行が存在する場合、その行を削除します。

#### 例
例えば、`opt_out_customers` テーブルに存在する `customer_id` を持つ顧客を `customers` テーブルから削除する場合は、以下のようにします。

```sql
DELETE FROM customers c
WHERE EXISTS (SELECT 1 FROM opt_out_customers o WHERE c.customer_id = o.customer_id);
```

このクエリは、`opt_out_customers` テーブルに `customer_id` が存在する顧客を `customers` テーブルから削除します。

### `NOT EXISTS` を使った削除

`NOT EXISTS` は、サブクエリが行を返さない場合に `TRUE` を返します。これにより、条件に一致する行が存在しない場合にのみ削除が行われます。

#### 構文
```sql
DELETE FROM テーブル名 t
WHERE NOT EXISTS (SELECT 1 FROM 他のテーブル o WHERE t.条件 = o.条件);
```

- **`NOT EXISTS` の動作**: サブクエリが行を返さない場合、つまり関連するデータが存在しない場合に、その行を削除します。

#### 例
例えば、`opt_out_customers` テーブルに `customer_id` が存在しない顧客を `customers` テーブルから削除する場合は、以下のようにします。

```sql
DELETE FROM customers c
WHERE NOT EXISTS (SELECT 1 FROM opt_out_customers o WHERE c.customer_id = o.customer_id);
```

このクエリは、`opt_out_customers` テーブルに `customer_id` が存在しない顧客を `customers` テーブルから削除します。

### `EXISTS` と `NOT EXISTS` の違い

- **`EXISTS`**: サブクエリが行を返す（少なくとも1行が存在する）場合、その条件に一致する行を削除します。
- **`NOT EXISTS`**: サブクエリが行を返さない（該当する行が存在しない）場合、その条件に一致する行を削除します。

### パフォーマンスの考慮

- **`EXISTS` と `NOT EXISTS` のパフォーマンス**: `EXISTS` と `NOT EXISTS` は、条件に一致する行が見つかった時点でサブクエリの評価を終了するため、特に効率的です。ただし、大規模なデータセットや複雑なサブクエリの場合は、パフォーマンスに影響が出る可能性があります。

### まとめ

- `DELETE EXISTS`: サブクエリで一致する行が存在する場合に行を削除します。
- `DELETE NOT EXISTS`: サブクエリで一致する行が存在しない場合に行を削除します。

このように、`EXISTS` と `NOT EXISTS` を使うことで、関連するテーブルのデータの存在に応じた削除操作を柔軟に行うことができます。
