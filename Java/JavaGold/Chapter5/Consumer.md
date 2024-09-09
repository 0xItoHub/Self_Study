Javaの`Consumer`は、`Supplier`とは逆に**引数を受け取って処理を行うが、値を返さない**関数型インターフェースです。これは、引数を消費して何かしらの処理を実行するために使用されます。`Consumer`は`Supplier`と同じく、Java 8で導入された**関数型インターフェース**の一つです。

### `Consumer`の特徴
- **1つの引数を受け取り**、その引数に基づいて処理を行う。
- 戻り値は**ない**（`void`型）。
- `@FunctionalInterface`として定義されており、ラムダ式やメソッド参照で簡単に利用できます。
- `accept(T t)`というメソッドを持っており、このメソッドで処理を行います。

### 定義
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

### 使用例

#### 1. シンプルな例
```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // Consumerの実装（ラムダ式）
        Consumer<String> printConsumer = message -> System.out.println(message);
        
        // accept()メソッドを使って処理を実行
        printConsumer.accept("Hello, Consumer!");  // 出力: Hello, Consumer!
    }
}
```

#### 2. リスト内の要素に対する処理
```java
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

public class ListConsumerExample {
    public static void main(String[] args) {
        // リストを作成
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // リストの各要素に対して処理を行うConsumer
        Consumer<String> printName = name -> System.out.println("Name: " + name);
        
        // forEachを使って各要素に処理を適用
        names.forEach(printName);
        
        // 出力:
        // Name: Alice
        // Name: Bob
        // Name: Charlie
    }
}
```

### `Consumer`の主な用途
- **要素に対する操作**：例えばリストや配列などのコレクション内の各要素に対して処理を行いたい場合、`Consumer`を使って各要素を消費（処理）することができます。
- **ラムダ式を利用した処理**：単純な処理を定義し、その処理を必要なときに適用したい場合に便利です。`Consumer`は、引数を受け取って、何かしらの副作用（出力やデータベースの更新など）を伴う処理に使われます。

### `andThen`メソッド
`Consumer`インターフェースは、もう一つの`Consumer`と連結して、連続して処理を行うことができる`andThen()`メソッドも提供しています。

#### `andThen()`の例
```java
import java.util.function.Consumer;

public class AndThenExample {
    public static void main(String[] args) {
        // Consumer1：名前を出力
        Consumer<String> printName = name -> System.out.println("Name: " + name);
        
        // Consumer2：名前の長さを出力
        Consumer<String> printLength = name -> System.out.println("Length: " + name.length());
        
        // andThen()で2つのConsumerを連結
        Consumer<String> combinedConsumer = printName.andThen(printLength);
        
        // 両方の処理を連続して行う
        combinedConsumer.accept("Alice");  // 出力:
                                           // Name: Alice
                                           // Length: 5
    }
}
```

### まとめ
- `Consumer`は**引数を受け取って処理を実行し、結果を返さない**関数型インターフェースです。
- 主に**副作用のある処理**（データベースの更新やコンソール出力など）に使用されます。
- `andThen()`を使うと、複数の処理を順に実行することができます。
