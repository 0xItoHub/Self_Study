`@Retention`は、Javaのメタアノテーションの一つで、アノテーションがどの段階（ソースコード、バイトコード、実行時）まで保持されるかを指定するために使用されます。これにより、アノテーションがどのタイミングで利用可能であるかを制御できます。

### `@Retention`の構文

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    // アノテーションの属性定義
}
```

### `RetentionPolicy`の種類

`@Retention`は、`RetentionPolicy`という列挙型を使用して、アノテーションの保持期間を指定します。`RetentionPolicy`には以下の3つの値があります。

1. **`RetentionPolicy.SOURCE`**:
   - **説明**: アノテーションはソースコードにのみ存在し、コンパイル時に破棄されます。コンパイル後のクラスファイルや実行時にはアノテーションの情報は保持されません。
   - **使用例**: 主にコードの分析やチェックのために使用されるアノテーションで、コンパイル後に不要な場合に使用します。

   ```java
   @Retention(RetentionPolicy.SOURCE)
   public @interface MySourceAnnotation {
       // ソースコードにのみ存在するアノテーション
   }
   ```

2. **`RetentionPolicy.CLASS`**:
   - **説明**: アノテーションはクラスファイル（バイトコード）に保持されますが、実行時には利用できません。つまり、アノテーションはコンパイル後のクラスファイルに残りますが、リフレクションを使ってアノテーションにアクセスすることはできません。
   - **使用例**: バイトコードに含める必要はあるが、実行時にアノテーションの情報が不要な場合に使用します。デフォルトの保持期間です。

   ```java
   @Retention(RetentionPolicy.CLASS)
   public @interface MyClassAnnotation {
       // バイトコードに保持されるが、実行時には利用されないアノテーション
   }
   ```

3. **`RetentionPolicy.RUNTIME`**:
   - **説明**: アノテーションは実行時まで保持され、リフレクションを通じてアクセス可能です。これにより、実行時にアノテーションの情報を利用するフレームワークやライブラリでアノテーションを使用できます。
   - **使用例**: 実行時にアノテーションの情報が必要な場合、例えば、依存性注入やバリデーション、シリアライゼーションなどに使用されます。

   ```java
   @Retention(RetentionPolicy.RUNTIME)
   public @interface MyRuntimeAnnotation {
       // 実行時まで保持されるアノテーション
   }
   ```

### `@Retention`の用途と意義

- **コードの意図を明確化**: `@Retention`を使うことで、アノテーションがどの段階で必要かを明示でき、コードの意図を明確にします。
- **リフレクションによるアノテーションの利用**: `RetentionPolicy.RUNTIME`を指定することで、実行時にリフレクションを使用してアノテーションの情報を取得し、動的な処理を行うことが可能です。
- **コンパイルやビルドプロセスでの利用**: `RetentionPolicy.SOURCE`や`RetentionPolicy.CLASS`を使用することで、コンパイルやビルドプロセスの一部としてアノテーションを活用し、実行時には不要な情報を取り除くことができます。

### まとめ

- **`@Retention`**は、アノテーションがどの段階まで保持されるかを指定するメタアノテーションです。
- **`RetentionPolicy`の種類**:
  - `SOURCE`: ソースコードにのみ存在し、コンパイル時に破棄される。
  - `CLASS`: バイトコードに保持されるが、実行時には利用できない。
  - `RUNTIME`: 実行時まで保持され、リフレクションを通じてアクセス可能。
- **使用例**: アノテーションの利用シナリオに応じて適切な保持期間を指定することで、コードの意図を明確にし、効率的にアノテーションを活用できます。

このように、`@Retention`を正しく設定することで、アノテーションが必要なタイミングで正しく利用されるようにすることができます。
