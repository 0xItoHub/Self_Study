`partitioningBy()`は、JavaのStream APIで提供されている`Collectors`クラスの一部で、データを条件に基づいて2つのグループに分割するために使います。`partitioningBy()`はブール値を返す条件に基づいて要素を2つのリストに分けます。1つは条件を満たす要素のリスト、もう1つは条件を満たさない要素のリストです。

### シグネチャ

```java
public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)
```

- **Predicate**: 条件を定義する関数型インターフェース。
- **返り値**: ブール値をキーとし、`true`の場合に条件を満たす要素、`false`の場合に満たさない要素が格納される`Map<Boolean, List<T>>`。

### 基本的な使用例

次の例では、整数のリストを偶数と奇数に分けています。

```java
import java.util.*;
import java.util.stream.Collectors;

public class PartitioningByExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("偶数: " + partitioned.get(true));
        System.out.println("奇数: " + partitioned.get(false));
    }
}
```

### 出力:

```
偶数: [2, 4, 6, 8, 10]
奇数: [1, 3, 5, 7, 9]
```

### 詳細:

1. **`partitioningBy(Predicate)`**: `Predicate`に基づいて、`Map<Boolean, List<T>>`が返されます。`true`は条件に合致したリスト、`false`は合致しないリストです。

2. **応用例**: 複雑な条件でも`partitioningBy()`を使えます。例えば、文字列の長さで文字列を分割することもできます。

```java
import java.util.*;
import java.util.stream.Collectors;

public class PartitioningByExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Map<Boolean, List<String>> partitioned = names.stream()
            .collect(Collectors.partitioningBy(name -> name.length() > 3));

        System.out.println("4文字以上: " + partitioned.get(true));
        System.out.println("3文字以下: " + partitioned.get(false));
    }
}
```

### 出力:

```
4文字以上: [Alice, Charlie, David]
3文字以下: [Bob]
```

`partitioningBy()`は、データを2つのグループに分けたい時に非常に便利なメソッドです。
