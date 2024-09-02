`@Target`は、Javaのメタアノテーションの一つで、アノテーションが適用できるプログラム要素（ターゲット）を指定するために使用されます。`@Target`を使うことで、カスタムアノテーションをどのプログラム要素に適用できるかを制御できます。

### `@Target`の構文

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface MyAnnotation {
    // アノテーションの属性定義
}
```

### `@Target`で指定できるターゲット

`@Target`アノテーションでは、`ElementType`列挙型を使って、アノテーションを適用できるプログラム要素を指定します。`ElementType`には以下の値があります。

1. **`ElementType.TYPE`**:
   - クラス、インタフェース（注釈型も含む）、列挙型に適用できます。

   ```java
   @Target(ElementType.TYPE)
   public @interface MyAnnotation {
   }
   ```

   このアノテーションはクラスやインタフェースに適用できます。

2. **`ElementType.FIELD`**:
   - フィールド（メンバ変数）に適用できます。

   ```java
   @Target(ElementType.FIELD)
   public @interface MyAnnotation {
   }
   ```

   このアノテーションはフィールドに適用できます。

3. **`ElementType.METHOD`**:
   - メソッドに適用できます。

   ```java
   @Target(ElementType.METHOD)
   public @interface MyAnnotation {
   }
   ```

   このアノテーションはメソッドに適用できます。

4. **`ElementType.PARAMETER`**:
   - メソッドのパラメータに適用できます。

   ```java
   @Target(ElementType.PARAMETER)
   public @interface MyAnnotation {
   }
   ```

   このアノテーションはメソッドのパラメータに適用できます。

5. **`ElementType.CONSTRUCTOR`**:
   - コンストラクタに適用できます。

   ```java
   @Target(ElementType.CONSTRUCTOR)
   public @interface MyAnnotation {
   }
   ```

   このアノテーションはコンストラクタに適用できます。

6. **`ElementType.LOCAL_VARIABLE`**:
   - ローカル変数に適用できます。

   ```java
   @Target(ElementType.LOCAL_VARIABLE)
   public @interface MyAnnotation {
   }
   ```

   このアノテーションはローカル変数に適用できます。

7. **`ElementType.ANNOTATION_TYPE`**:
   - 別のアノテーションに適用できるアノテーション（メタアノテーション）として使用されます。

   ```java
   @Target(ElementType.ANNOTATION_TYPE)
   public @interface MyMetaAnnotation {
   }
   ```

   このアノテーションは他のアノテーションに適用できます。

8. **`ElementType.PACKAGE`**:
   - パッケージに適用できます。

   ```java
   @Target(ElementType.PACKAGE)
   public @interface MyPackageAnnotation {
   }
   ```

   このアノテーションはパッケージに適用できます。

9. **`ElementType.TYPE_PARAMETER`**（Java 8以降）:
   - ジェネリクスの型パラメータに適用できます。

   ```java
   @Target(ElementType.TYPE_PARAMETER)
   public @interface MyTypeParameterAnnotation {
   }
   ```

   このアノテーションはジェネリクスの型パラメータに適用できます。

10. **`ElementType.TYPE_USE`**（Java 8以降）:
    - 型が使用されるすべての場所に適用できます（型キャスト、`instanceof`、`new`など）。

    ```java
    @Target(ElementType.TYPE_USE)
    public @interface MyTypeUseAnnotation {
    }
    ```

    このアノテーションは型が使用されるあらゆる場所に適用できます。

### 複数のターゲットを指定する

`@Target`アノテーションでは、複数のターゲットを指定することができます。例えば、あるアノテーションをクラスとメソッドの両方に適用可能にしたい場合は、以下のように指定します。

```java
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
}
```

このアノテーションはクラスにもメソッドにも適用できるようになります。

### まとめ

- **`@Target`**は、アノテーションが適用できるプログラム要素を制御するために使用されるメタアノテーションです。
- **`ElementType`**列挙型を使用して、アノテーションの適用範囲を指定します。
- 複数のターゲットを指定することで、アノテーションの適用範囲を柔軟に設定できます。

このように、`@Target`を正しく使用することで、アノテーションの適用範囲を意図した通りに制御することができ、コードの設計と保守性を向上させることができます。
