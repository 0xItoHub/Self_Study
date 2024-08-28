Javaにおける`implements`キーワードは、クラスがインターフェースを**実装する**ことを示すために使用されます。インターフェースはメソッドのシグネチャ（宣言）だけを定義し、実装クラスがそれを実装します。

### インターフェースの実装方法

1. **インターフェースの宣言**: まず、インターフェースを定義します。インターフェースには抽象的なメソッドが含まれており、これらのメソッドはインターフェースを実装するクラスで実装される必要があります。
2. **`implements` キーワード**: クラスがインターフェースを実装する際に `implements` キーワードを使用します。
3. **メソッドのオーバーライド**: クラスはインターフェースで宣言されたすべてのメソッドをオーバーライドして具体的な実装を提供する必要があります。

### 例: 単一のインターフェースを実装

```java
// インターフェースの定義
public interface Animal {
    void makeSound();  // メソッドの宣言（本体なし）
}

// インターフェースの実装クラス
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// 使用例
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();  // Animal型の変数でDogオブジェクトを参照
        dog.makeSound();  // "Bark" が出力される
    }
}
```

### 例: 複数のインターフェースを実装

Javaでは、クラスが複数のインターフェースを実装することができます。複数のインターフェースを実装する場合、それぞれのインターフェースで定義されたすべてのメソッドをクラス内で実装する必要があります。

```java
// 複数のインターフェースの定義
public interface Animal {
    void makeSound();
}

public interface Runnable {
    void run();
}

// クラスが複数のインターフェースを実装
public class Dog implements Animal, Runnable {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }
}

// 使用例
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();  // "Bark"
        dog.run();        // "Dog is running"
    }
}
```

### 重要なポイント

1. **複数のインターフェース実装**: クラスは複数のインターフェースを実装できますが、すべてのインターフェースで宣言されたメソッドを実装する必要があります。
2. **多重継承の代替**: Javaはクラスの多重継承をサポートしていませんが、複数のインターフェースを実装することで、複数の「契約」をクラスに持たせることができます。
3. **デフォルトメソッド**: Java 8以降、インターフェースにデフォルトメソッド（`default`キーワードを使ったメソッド）を定義できるようになり、クラス側で明示的にそのメソッドをオーバーライドする必要がなくなりました。

### まとめ
- `implements`キーワードを使用して、クラスはインターフェースを実装します。
- クラスはインターフェース内で定義されたすべての抽象メソッドを実装する必要があります。
- 複数のインターフェースを同時に実装することができます。
