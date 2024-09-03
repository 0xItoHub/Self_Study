`@Target` アノテーションは、Javaのアノテーションがどのようなプログラム要素に適用できるかを指定するために使用されます。このアノテーションは `java.lang.annotation` パッケージに含まれています。`@Target` は、アノテーションを定義する際にその適用先を制限するために使用します。

### `@Target` の主要な要素

- `ElementType.ANNOTATION_TYPE`: アノテーション型に適用できることを示します。例えば、カスタムアノテーションを定義する際に使用します。
- `ElementType.CONSTRUCTOR`: コンストラクタに適用できることを示します。
- `ElementType.FIELD`: フィールド（メンバ変数）に適用できることを示します。
- `ElementType.LOCAL_VARIABLE`: ローカル変数に適用できることを示します。
- `ElementType.METHOD`: メソッドに適用できることを示します。
- `ElementType.PARAMETER`: メソッドやコンストラクタのパラメータに適用できることを示します。
- `ElementType.PACKAGE`: パッケージに適用できることを示します。
- `ElementType.TYPE`: クラス、インターフェース、列挙型などの型に適用できることを示します。

### 使用例

例えば、アノテーションがメソッドにのみ適用できるようにするには、以下のように `@Target` を使用します。

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MyMethodAnnotation {
    // アノテーションの要素を定義
}
```

この例では、`MyMethodAnnotation` アノテーションはメソッドにのみ適用可能であり、他のプログラム要素（例えばクラスやフィールド）には適用できません。

`@Target` を適切に使用することで、アノテーションの適用範囲を制限し、アノテーションの意図した使い方を明確にすることができます。
