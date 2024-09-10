`removeIf()` メソッドは、`java.util.Collection` インターフェースに属しており、特に `ArrayList` などのコレクションでよく使用されます。このメソッドは、指定された条件に一致する要素をコレクションから削除するために使われます。

### 概要
`removeIf()` メソッドは、コレクション内の各要素に対して述語（`Predicate`）を評価し、その述語が `true` を返した場合に、その要素を削除します。

### シグネチャ
```java
boolean removeIf(Predicate<? super E> filter)
```

- **`Predicate<? super E>`**: 削除する条件を指定するラムダ式や関数です。条件が `true` になった要素は削除されます。
- **戻り値**: もし削除された要素があれば `true` を返し、なければ `false` を返します。

### 使い方
`removeIf()` は主にリストやセットなどのコレクションに対して使われます。ラムダ式を使って、削除したい条件を指定します。

### 例
次に、リスト内の要素が偶数であれば削除する例を示します。

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // 偶数の要素をリストから削除
        numbers.removeIf(n -> n % 2 == 0);

        // 結果を表示
        System.out.println(numbers); // [1, 3, 5]
    }
}
```

### もう少し複雑な例
文字列リストから特定の文字列を含む要素を削除する場合も、`removeIf()` を使えます。

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("avocado");

        // "a" を含む文字列を削除
        words.removeIf(word -> word.contains("a"));

        // 結果を表示
        System.out.println(words); // [cherry]
    }
}
```

### 注意点
- `removeIf()` はコレクションが変更されたかどうかを `boolean` 型で返すため、処理結果を確認したい場合は、この戻り値を使って判断できます。
- **スレッドセーフではない**: このメソッドはスレッドセーフではないため、複数のスレッドで同時に操作される場合には、適切な同期が必要です。

### 結論
`removeIf()` はコレクション内の要素を特定の条件に基づいて簡単に削除できる便利なメソッドです。特にラムダ式と組み合わせることで、コードをシンプルに書けるようになります。
