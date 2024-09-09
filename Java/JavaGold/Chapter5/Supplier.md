Javaの`Supplier`は、Java 8で導入された**関数型インターフェース**の一つで、主に**結果を提供する**ためのものです。引数を取らずに、何らかのオブジェクトや値を返す機能を持っています。つまり、`Supplier`は「供給者」の役割を果たし、遅延評価やファクトリーメソッドとして利用されることが多いです。

### `Supplier`の特徴
- 引数を取らず、何らかの値を返す（型`T`）。
- `@FunctionalInterface`として定義されており、関数型インターフェースです。したがって、ラムダ式やメソッド参照で簡潔に使えます。
- `get()`メソッドだけを持っています。

### 定義
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

### 使用例

#### 1. シンプルな例
```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Supplierの実装（ラムダ式）
        Supplier<String> stringSupplier = () -> "Hello, Supplier!";
        
        // get()メソッドを使って値を取得
        System.out.println(stringSupplier.get());  // 出力: Hello, Supplier!
    }
}
```

#### 2. 遅延評価の例
```java
import java.util.function.Supplier;

public class LazyEvaluationExample {
    public static void main(String[] args) {
        // 遅延評価のSupplier
        Supplier<Double> randomSupplier = () -> Math.random();
        
        // get()メソッドを呼び出すたびに新しい値が返される
        System.out.println(randomSupplier.get());  // 出力: 0.123456789
        System.out.println(randomSupplier.get());  // 出力: 0.987654321
    }
}
```

### 主な用途
- **遅延評価**：値の生成を遅らせたい場合、例えば高コストの処理を必要な時にのみ実行したい場合に使います。
- **ファクトリーメソッド**：オブジェクト生成のロジックを抽象化し、特定のタイミングで生成したい場合に便利です。
- **キャッシュ戦略**：キャッシュされた値を取得する際に、`Supplier`を使って値を供給し、必要なときにのみ評価を行うことができます。

`Supplier`はシンプルですが、状況に応じて非常に便利に使えるインターフェースです。例えば、複雑なオブジェクトの生成や遅延実行に使えるため、特にラムダ式と組み合わせて使うことでコードの可読性や柔軟性を向上させることができます。
