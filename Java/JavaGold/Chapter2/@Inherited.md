`@Inherited`は、Javaのメタアノテーションの一つで、アノテーションがクラス階層において継承されるかどうかを指定するために使用されます。`@Inherited`が付与されたアノテーションは、あるクラスに適用された場合、そのクラスを継承するサブクラスにも自動的に適用されます。

### `@Inherited`の基本

- **適用対象**: `@Inherited`は、**クラス**に対してのみ使用できるアノテーションに適用されます。フィールド、メソッド、コンストラクタ、パラメータなどに適用されるアノテーションには使えません。
- **継承の挙動**: `@Inherited`アノテーションが付与されたアノテーションは、親クラスに対して適用されると、そのアノテーションは継承された子クラスでも有効になります。ただし、継承されるのはクラスに対して適用されたアノテーションのみです。

### `@Inherited`の使用例

以下は、`@Inherited`アノテーションを使用してカスタムアノテーションを定義する例です。

#### 例：`@Inherited`を使ったカスタムアノテーション

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String value() default "default value";
}
```

このカスタムアノテーション`MyAnnotation`には`@Inherited`が付与されています。

#### 例：`@Inherited`の効果を確認する

```java
@MyAnnotation(value = "Parent class annotation")
public class ParentClass {
}

public class ChildClass extends ParentClass {
}

public class Main {
    public static void main(String[] args) {
        // 親クラスのアノテーションを取得
        MyAnnotation parentAnnotation = ParentClass.class.getAnnotation(MyAnnotation.class);
        System.out.println("ParentClass: " + parentAnnotation.value());

        // 子クラスに継承されたアノテーションを取得
        MyAnnotation childAnnotation = ChildClass.class.getAnnotation(MyAnnotation.class);
        System.out.println("ChildClass: " + childAnnotation.value());
    }
}
```

### 実行結果

```plaintext
ParentClass: Parent class annotation
ChildClass: Parent class annotation
```

#### 解説

- **親クラス`ParentClass`**に`MyAnnotation`が適用されているため、そのサブクラスである**`ChildClass`**でも`MyAnnotation`が有効となります。
- `ChildClass`は`ParentClass`から`MyAnnotation`アノテーションを継承しているため、`ChildClass.class.getAnnotation(MyAnnotation.class)`で`MyAnnotation`を取得できます。

### `@Inherited`の制約

- **フィールドやメソッドには適用されない**: `@Inherited`はクラスに対してのみ適用されるため、フィールドやメソッドに付与されたアノテーションは継承されません。
- **複数の継承**: `@Inherited`アノテーションが付与されたアノテーションを持つクラスを継承した場合、最初の継承元クラスのアノテーションのみが継承されます。

### `@Inherited`の実用性

`@Inherited`は、クラス階層において、アノテーションを自動的に子クラスに引き継ぎたい場合に非常に便利です。例えば、セキュリティ制約やトランザクション管理などの設定をサブクラスでも継承させたい場合に使用されます。

### まとめ

- **`@Inherited`**は、クラスに対して適用されたアノテーションを、そのクラスのサブクラスに継承させるためのメタアノテーションです。
- **クラスにのみ適用**され、フィールドやメソッドに適用されたアノテーションは継承されません。
- **利用シーン**: 親クラスで指定したアノテーションを、サブクラスでも自動的に有効にしたい場合に使用されます。

`@Inherited`を適切に使用することで、クラス階層全体に対して一貫した設定を適用することができ、コードの再利用性や保守性が向上します。
