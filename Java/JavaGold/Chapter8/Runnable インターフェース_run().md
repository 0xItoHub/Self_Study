`Runnable` インターフェースは、Javaでスレッドを作成するために使用される基本的なインターフェースで、`run()` メソッドがその中核を担います。このインターフェースを実装することで、並行して実行できるコードを定義できます。

### `Runnable` インターフェースの構造

```java
public interface Runnable {
    public abstract void run();
}
```

`Runnable` インターフェースは非常にシンプルで、1つの抽象メソッド `run()` しか持ちません。この `run()` メソッドの中に、実行したいタスクのロジックを定義します。

### `run()` メソッドの役割

`run()` メソッドは、スレッドが開始されたときに実行されるコードを定義します。スレッドが実行されるとき、このメソッドの中に記述された処理が順次実行されます。

### 基本的な使い方

1. `Runnable` インターフェースを実装したクラスを定義します。
2. `run()` メソッド内にタスクのロジックを書きます。
3. 実装した `Runnable` を `Thread` オブジェクトに渡し、スレッドを開始します。

以下のコードは `Runnable` インターフェースを使ったスレッドの基本例です。

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // スレッドで実行したいコード
        System.out.println("スレッドが実行中: " + Thread.currentThread().getName());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // スレッドを開始し、run()メソッドが実行される
    }
}
```

### 実行結果
```
スレッドが実行中: Thread-0
```

この例では、`MyRunnable` クラスが `Runnable` インターフェースを実装し、`run()` メソッド内にタスク（メッセージの表示）を定義しています。`Thread` オブジェクトに `Runnable` を渡して `start()` メソッドを呼び出すと、別スレッドで `run()` メソッドが実行されます。

### `run()` メソッドを直接呼び出すのではなく `start()` を使う理由

以下のように `run()` メソッドを直接呼び出すことも可能ですが、これではスレッドとして動作しません。

```java
MyRunnable myRunnable = new MyRunnable();
myRunnable.run(); // スレッドではなく、単なるメソッド呼び出し
```

この場合、スレッドは作成されず、ただ単に現在のスレッドでメソッドが実行されるだけです。スレッドとして実行するには、必ず `Thread` クラスの `start()` メソッドを呼び出して、内部で `run()` メソッドが実行されるようにする必要があります。

### `Lambda` を使った `Runnable` の短縮

Java 8 以降では、`Runnable` は1つの抽象メソッドしか持たないため、ラムダ式を使ってより簡潔に記述できます。

```java
public class RunnableExample {
    public static void main(String[] args) {
        Runnable myRunnable = () -> {
            System.out.println("スレッドが実行中: " + Thread.currentThread().getName());
        };
        
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
```

### 結論

- `Runnable` インターフェースは、スレッドで実行されるタスクを定義するために使われます。
- `run()` メソッドにスレッドで実行したい処理を記述します。
- スレッドを作成するためには、`Thread` クラスと組み合わせて `start()` メソッドを呼び出す必要があります。
- Java 8 以降では、ラムダ式を使って簡潔に `Runnable` を記述できます。
