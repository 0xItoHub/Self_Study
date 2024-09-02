`@Documented`は、Javaのメタアノテーションの一つで、アノテーションの存在をJavadocなどのAPIドキュメントに反映させるために使用されます。`@Documented`が付与されたアノテーションは、そのアノテーションが適用された要素について生成されるドキュメントに記載されることを保証します。

### `@Documented`の目的

Javaでは、アノテーションは通常、ソースコードにメタデータを追加するために使用されますが、その情報がJavadocなどのドキュメントに反映されるとは限りません。`@Documented`を使用することで、アノテーションがAPIの一部として正式に文書化されるようになります。これにより、アノテーションの存在や用途がAPI利用者にとって明確になります。

### 使用例

カスタムアノテーションを定義する際に`@Documented`を使用する例を示します。

```java
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {
    String value();
}
```

この例では、`@MyCustomAnnotation`というカスタムアノテーションが定義されています。このアノテーションには`@Documented`が付与されているため、`@MyCustomAnnotation`が付けられたメソッドについてJavadocを生成すると、そのアノテーションもドキュメントに含まれます。

### Javadocへの影響

上記の`MyCustomAnnotation`を使用したクラスやメソッドに対してJavadocを生成すると、そのドキュメントには`@MyCustomAnnotation`の情報が含まれます。たとえば、次のようにアノテーションを使用したクラスがあった場合：

```java
public class MyClass {

    /**
     * This method does something important.
     */
    @MyCustomAnnotation(value = "Example")
    public void importantMethod() {
        // 実装コード
    }
}
```

このクラスに対してJavadocを生成すると、`importantMethod`メソッドのドキュメントに`@MyCustomAnnotation(value = "Example")`が含まれます。これにより、APIの利用者は、このメソッドが`@MyCustomAnnotation`によって何らかの特別な意味を持つことを理解できるようになります。

### まとめ

- **`@Documented`**は、アノテーションをJavadocに含めるために使用されるメタアノテーションです。
- **目的**: アノテーションの存在をAPIドキュメントに反映させ、API利用者にそのアノテーションの存在と用途を明示します。
- **使い方**: カスタムアノテーションを定義する際に`@Documented`を付与することで、そのアノテーションが適用されたプログラム要素のドキュメントにアノテーションの情報が含まれます。

これにより、API利用者は、ドキュメントを参照するだけでアノテーションの使用方法や効果を理解でき、コードの意図や制約をより明確に把握できるようになります。
