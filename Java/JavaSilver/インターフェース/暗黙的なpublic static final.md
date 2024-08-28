Javaのインターフェースにおいて、フィールド（変数）やメソッドには暗黙的に以下のアクセス修飾子が適用されます。

### フィールドの場合:
インターフェースで定義されるフィールドには、**暗黙的に `public static final`** が適用されます。つまり、インターフェース内で宣言されたフィールドは、常に `public` であり、インスタンス化されなくてもアクセス可能（`static`）、そして値が変更できない（`final`）という特徴を持ちます。

### メソッドの場合:
インターフェースにおいて定義されるメソッドは、**暗黙的に `public abstract`** として扱われます。すなわち、インターフェース内のメソッドはすべて `public` であり、実装を持たない抽象メソッドです。実装クラスでこれらのメソッドをオーバーライドし、具象的な実装を提供する必要があります。

### フィールドの例:
```java
public interface Constants {
    int MAX_VALUE = 100;  // これは public static final int MAX_VALUE = 100 と同じ
}
```

この場合、`MAX_VALUE` は `public static final` として扱われるため、インターフェースの実装クラス内からも、クラス外からもアクセスすることができます。

```java
public class Example implements Constants {
    public void printValue() {
        System.out.println(MAX_VALUE);  // Constants.MAX_VALUE としてアクセス
    }
}
```

### メソッドの例:
```java
public interface Animal {
    void makeSound();  // これは public abstract void makeSound(); と同じ
}
```

このメソッドは暗黙的に `public abstract` として扱われ、実装クラスはこれを必ずオーバーライドして具象メソッドを提供する必要があります。

### まとめ:
- インターフェースで定義されるフィールドは、暗黙的に `public static final`。
- インターフェースで定義されるメソッドは、暗黙的に `public abstract`。
