`java.lang.annotation` パッケージは、Javaでアノテーションを扱うためのクラスやインターフェースを提供します。アノテーションは、コードにメタデータを追加するための手段であり、コンパイラやツールによって利用されます。以下は `java.lang.annotation` パッケージに含まれる主なクラスとインターフェースです。

### 主なクラスとインターフェース

1. **`@Target`**  
   アノテーションが適用可能なプログラム要素の種類を指定します。例えば、メソッド、フィールド、クラスなどです。

   ```java
   @Target(ElementType.METHOD)
   public @interface MyMethodAnnotation {
   }
   ```

2. **`@Retention`**  
   アノテーションがどのように保持されるか（ソースコード、コンパイル時、ランタイムなど）を指定します。

   ```java
   @Retention(RetentionPolicy.RUNTIME)
   public @interface MyRuntimeAnnotation {
   }
   ```

3. **`@Documented`**  
   アノテーションが Javadoc に含まれるべきであることを示します。このアノテーションが付与されたアノテーションは、Javadoc に出力されます。

   ```java
   @Documented
   @Retention(RetentionPolicy.RUNTIME)
   public @interface MyDocumentedAnnotation {
   }
   ```

4. **`@Inherited`**  
   アノテーションがクラス階層で継承されることを示します。親クラスに付けられたアノテーションが、子クラスにも適用される場合に使用します。

   ```java
   @Inherited
   @Retention(RetentionPolicy.RUNTIME)
   public @interface MyInheritedAnnotation {
   }
   ```

5. **`Annotation`**  
   `java.lang.annotation.Annotation` インターフェースは、アノテーションの型を定義するための基本的なインターフェースです。すべてのアノテーション型はこのインターフェースを暗黙的に実装しています。

6. **`RetentionPolicy`**  
   アノテーションがどのように保持されるかを示す列挙型です。
   - `SOURCE`: ソースコードのみで保持され、コンパイル時に削除されます。
   - `CLASS`: バイトコードに保持され、実行時には利用できません。
   - `RUNTIME`: バイトコードに保持され、実行時にリフレクションを通じて利用可能です。

### 使用例

以下は、`@Retention` と `@Target` を組み合わせてアノテーションを定義し、それを使用する例です。

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// アノテーションの定義
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {
    String value() default "";
}

// アノテーションの使用例
public class MyClass {
    @MyCustomAnnotation("Example")
    public void myMethod() {
        System.out.println("Method with MyCustomAnnotation.");
    }
}
```

この例では、`@MyCustomAnnotation` はメソッドに適用可能で、ランタイムでリフレクションを通じて利用できるようになっています。
