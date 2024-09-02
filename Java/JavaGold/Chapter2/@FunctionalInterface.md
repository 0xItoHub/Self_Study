`@FunctionalInterface`は、Java 8で導入されたアノテーションで、関数型インターフェース（Functional Interface）を定義するために使用されます。関数型インターフェースは、1つの抽象メソッド（未実装のメソッド）を持つインターフェースのことです。`@FunctionalInterface`アノテーションを使用することで、そのインターフェースが関数型インターフェースであることを明示し、コンパイラによるチェックを受けることができます。

### 1. 関数型インターフェースとは

関数型インターフェースは、1つの抽象メソッドを持つインターフェースです。この抽象メソッドは、ラムダ式やメソッド参照によって実装することができます。関数型インターフェースは、Javaのラムダ式を使用する際に特に重要です。

#### 例：関数型インターフェースの定義

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute(); // 1つの抽象メソッド
}
```

### 2. `@FunctionalInterface`アノテーションの効果

`@FunctionalInterface`アノテーションには、いくつかの目的があります。

- **コンパイラチェック**:
  - `@FunctionalInterface`を付けたインターフェースが複数の抽象メソッドを持っていると、コンパイルエラーになります。これにより、そのインターフェースが正しく関数型インターフェースとして定義されていることを保証します。

- **コードの可読性向上**:
  - `@FunctionalInterface`を使うことで、他の開発者がそのインターフェースが関数型インターフェースであることを一目で理解できるようになります。

#### 例：`@FunctionalInterface`の使用

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute();

    // デフォルトメソッドや静的メソッドは許容される
    default void defaultMethod() {
        System.out.println("Default Method");
    }

    static void staticMethod() {
        System.out.println("Static Method");
    }
}
```

### 3. 関数型インターフェースの利用例

関数型インターフェースは、ラムダ式を使用して実装する際に非常に便利です。

#### 例：ラムダ式による関数型インターフェースの実装

```java
public class Main {
    public static void main(String[] args) {
        // ラムダ式で関数型インターフェースを実装
        MyFunctionalInterface myFunc = () -> System.out.println("Executing!");

        // メソッドを呼び出し
        myFunc.execute();  // 出力: Executing!
    }
}
```

この例では、`MyFunctionalInterface`インターフェースをラムダ式で実装しています。ラムダ式は、インターフェースの抽象メソッド（この場合は`execute`）を実装する簡潔な方法です。

### 4. デフォルトメソッドと静的メソッド

関数型インターフェースには、1つの抽象メソッドしか持てませんが、デフォルトメソッドや静的メソッドを持つことはできます。これらは関数型インターフェースの一部ではないため、複数定義しても問題ありません。

#### 例：デフォルトメソッドと静的メソッド

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute();

    default void show() {
        System.out.println("Default Method");
    }

    static void display() {
        System.out.println("Static Method");
    }
}
```

### まとめ

- **`@FunctionalInterface`アノテーション**は、1つの抽象メソッドを持つインターフェースが関数型インターフェースであることを明示し、コンパイル時のチェックを行うためのものです。
- 関数型インターフェースは、ラムダ式やメソッド参照を使って簡単に実装できるため、コードの可読性とメンテナンス性が向上します。
- **デフォルトメソッド**や**静的メソッド**を持つことは可能であり、それによってインターフェースに追加の機能を持たせることができますが、抽象メソッドは1つだけである必要があります。

このアノテーションを使うことで、関数型インターフェースが正しく定義されていることを保証し、意図せず抽象メソッドが追加されることを防ぐことができます。
