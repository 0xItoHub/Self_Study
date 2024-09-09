Javaの`Predicate<T>`インターフェースは、Java 8で導入された**関数型インターフェース**で、**引数を受け取り、論理値（`true`または`false`）を返す**関数を表現します。このインターフェースは、引数に対する条件の判定やフィルタリングなど、ブール値を返す操作を簡潔に記述できるため、様々なシナリオで利用されます。

### `Predicate`の特徴
- **1つの引数を受け取り、`boolean`型の結果を返す**。
- `@FunctionalInterface`として定義されているので、ラムダ式やメソッド参照を使って簡単に実装できる。
- `test(T t)`メソッドを持ち、与えられた引数に対して条件を評価します。

### 定義
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

### 使用例

#### 1. 偶数を判定する`Predicate`
```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Predicateの実装（ラムダ式）
        Predicate<Integer> isEven = x -> x % 2 == 0;
        
        // test()メソッドを使って条件を判定
        System.out.println(isEven.test(4));  // 出力: true
        System.out.println(isEven.test(5));  // 出力: false
    }
}
```

#### 2. 文字列が空かどうかを判定する`Predicate`
```java
import java.util.function.Predicate;

public class StringPredicateExample {
    public static void main(String[] args) {
        // 文字列が空かどうかを判定するPredicate
        Predicate<String> isEmpty = s -> s.isEmpty();
        
        // test()メソッドを使って判定
        System.out.println(isEmpty.test(""));      // 出力: true
        System.out.println(isEmpty.test("hello")); // 出力: false
    }
}
```

### `Predicate`の主な用途
- **条件付きフィルタリング**：コレクション内の要素を条件に基づいてフィルタリングする際に使用されます。`Stream API`と組み合わせて、`filter()`メソッドなどで利用されます。
- **条件チェック**：オブジェクトや値が特定の条件を満たしているかを確認する際に便利です。

#### `Stream API`での`Predicate`使用例
```java
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPredicateExample {
    public static void main(String[] args) {
        // リストを作成
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        
        // 偶数をフィルタリングするPredicate
        Predicate<Integer> isEven = x -> x % 2 == 0;
        
        // Stream APIでフィルタリング
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(isEven)
                                           .collect(Collectors.toList());
        
        // 出力: [2, 4, 6]
        System.out.println(evenNumbers);
    }
}
```

### 複合条件を扱うメソッド
`Predicate`インターフェースには、複数の条件を組み合わせるための便利なメソッドが用意されています。

#### `and()`, `or()`, `negate()`メソッド

1. **`and()`**：2つの`Predicate`を組み合わせ、両方の条件が`true`の場合に`true`を返します。
2. **`or()`**：2つの`Predicate`を組み合わせ、いずれかの条件が`true`の場合に`true`を返します。
3. **`negate()`**：`Predicate`の条件を反転させ、元の条件が`true`なら`false`、`false`なら`true`を返します。

#### 使用例

```java
import java.util.function.Predicate;

public class PredicateCombinationExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;
        
        // 偶数かつ正の数であるかを判定
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println(isEvenAndPositive.test(4));  // 出力: true
        System.out.println(isEvenAndPositive.test(-2)); // 出力: false
        
        // 偶数または正の数であるかを判定
        Predicate<Integer> isEvenOrPositive = isEven.or(isPositive);
        System.out.println(isEvenOrPositive.test(-2));  // 出力: true
        System.out.println(isEvenOrPositive.test(3));   // 出力: true
        
        // 偶数でないかを判定
        Predicate<Integer> isNotEven = isEven.negate();
        System.out.println(isNotEven.test(3));  // 出力: true
        System.out.println(isNotEven.test(4));  // 出力: false
    }
}
```

### `Predicate`の利点
- **ラムダ式で簡潔に条件判定が記述できる**：条件判定をラムダ式で表現できるため、冗長なコードを減らせます。
- **再利用可能**：複数の条件判定を複合できるため、柔軟なフィルタリングや条件チェックが可能です。
- **Stream APIとの相性が良い**：`filter()`メソッドなど、`Stream`を使ってコレクション操作を行う際に効果的です。

### まとめ
- `Predicate<T>`は、1つの引数を受け取り、それに基づいて`true`または`false`を返す関数型インターフェースです。
- 主に条件判定やフィルタリングで使用され、`Stream API`と組み合わせて利用されることが多いです。
- 複数の`Predicate`を`and()`や`or()`、`negate()`で組み合わせることで、より柔軟な条件判定が可能です。
