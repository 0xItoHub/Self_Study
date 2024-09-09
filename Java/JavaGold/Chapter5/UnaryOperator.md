`UnaryOperator`は、Java 8で導入された**関数型インターフェース**で、**引数と戻り値が同じ型の関数**を表現するために使われます。`UnaryOperator`は`Function<T, R>`インターフェースの特化版であり、`Function`が「引数を受け取り、結果を返す」ものであるのに対し、`UnaryOperator`は「**1つの引数を受け取り、その引数と同じ型の結果を返す**」という点が特徴です。

### `UnaryOperator`の特徴
- **1つの引数を受け取り、その引数と同じ型の値を返す**。
- `@FunctionalInterface`として定義されており、ラムダ式やメソッド参照で簡潔に利用できる。
- `apply(T t)`というメソッドを持っており、このメソッドで処理を行います。

### 定義
```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
    // applyメソッドでT型の引数を受け取り、T型の結果を返す
    T apply(T t);
}
```

### 使用例

#### 1. 値を2倍にする`UnaryOperator`
```java
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        // UnaryOperatorの実装（ラムダ式）
        UnaryOperator<Integer> doubleValue = x -> x * 2;
        
        // apply()メソッドを使って引数を処理
        System.out.println(doubleValue.apply(5));  // 出力: 10
    }
}
```

#### 2. 文字列の大文字変換
```java
import java.util.function.UnaryOperator;

public class StringUnaryOperatorExample {
    public static void main(String[] args) {
        // 文字列を大文字に変換するUnaryOperator
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
        
        // apply()メソッドを使って文字列を処理
        System.out.println(toUpperCase.apply("hello"));  // 出力: HELLO
    }
}
```

### `UnaryOperator`と`Function`の違い
`UnaryOperator<T>`は、`Function<T, R>`の特殊なケースであり、引数と戻り値の型が同じ場合に使用されます。`Function`は引数と戻り値が異なる型でも利用できますが、`UnaryOperator`は常に同じ型の引数と戻り値を扱います。

#### `Function`との比較
```java
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionUnaryOperatorComparison {
    public static void main(String[] args) {
        // Functionを使う例（Integer -> String）
        Function<Integer, String> intToString = num -> "Number: " + num;
        System.out.println(intToString.apply(10));  // 出力: Number: 10
        
        // UnaryOperatorを使う例（Integer -> Integer）
        UnaryOperator<Integer> square = num -> num * num;
        System.out.println(square.apply(5));  // 出力: 25
    }
}
```

### `UnaryOperator`の主な用途
- **同じ型のデータを変換する処理**：`UnaryOperator`は、特定の型のデータを変換する処理（例えば、数値を倍にする、文字列を加工するなど）に便利です。
- **コレクション操作**：コレクションの要素を同じ型の別の値に変換する際に使用されます。`List.replaceAll()`メソッドなど、`UnaryOperator`を使う場面があります。

#### `List.replaceAll()`での例
```java
import java.util.List;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class ReplaceAllExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        
        // すべての要素を大文字に変換する
        words.replaceAll(String::toUpperCase);
        
        // 出力: [APPLE, BANANA, CHERRY]
        System.out.println(words);
    }
}
```

### まとめ
- `UnaryOperator`は、**1つの引数を取り、その引数と同じ型の結果を返す**関数型インターフェースです。
- 同じ型の変換を行う処理に適しており、数値や文字列などの変換を簡潔に記述できます。
- `List.replaceAll()`など、コレクション操作にも使われることがあります。
