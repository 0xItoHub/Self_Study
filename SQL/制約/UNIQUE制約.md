UNIQUE制約は、データベースにおいて特定の列（または列の組み合わせ）に対して、その値が重複しないことを保証するための制約です。この制約は、データベースに新しいデータが挿入される際、同じ値が既に存在していないかを確認します。もし既に同じ値が存在する場合、そのデータの挿入は拒否されます。

### UNIQUE制約の特徴：
1. **一意性の保証**: UNIQUE制約が設定された列には、同じ値が2回以上入らないように制約されます。ただし、NULL値は複数許可されることがある（データベースシステムによって異なる）。
   
2. **複数列での適用**: UNIQUE制約は1つの列だけでなく、複数の列にまたがって設定することも可能です。この場合、複数の列の組み合わせが一意である必要があります。

3. **PRIMARY KEYとの違い**: PRIMARY KEYも一意性を保証しますが、PRIMARY KEYは必ずNOT NULLであり、一つのテーブルに一つだけ存在できます。一方、UNIQUE制約は複数の列に設定することが可能で、NULL値を許容する場合があります。

### 例
#### 単一列にUNIQUE制約を適用
```sql
CREATE TABLE users (
    id INT PRIMARY KEY,
    email VARCHAR(255) UNIQUE
);
```
この場合、`email`列には重複する値が挿入できません。

#### 複数列にUNIQUE制約を適用
```sql
CREATE TABLE user_roles (
    user_id INT,
    role_id INT,
    UNIQUE(user_id, role_id)
);
```
この場合、`user_id`と`role_id`の組み合わせが一意である必要があります。同じ`user_id`で異なる`role_id`が許可されますが、同じ組み合わせの重複は許されません。

### 用途
- 重複の許されないフィールドに利用する（例: メールアドレス、ユーザー名など）。
- 組み合わせが一意であることを保証するために利用する（例: ユーザーと役割の組み合わせ）。

この制約は、データの整合性を保つために重要な役割を果たします。
