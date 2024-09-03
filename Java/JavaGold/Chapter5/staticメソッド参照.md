Javaにおける**staticメソッド参照**は、静的メソッド（クラスメソッド）をラムダ式の代わりに使用するための構文です。staticメソッド参照は、既存の静的メソッドを再利用する際に、コードをより簡潔に、かつ読みやすくするための手法です。

### staticメソッド参照の構文

staticメソッド参照の基本構文は次のとおりです：

```java
ClassName::methodName
```

ここで、`ClassName`はクラス名を表し、`methodName`は参照する静的メソッドの名前を表します。

### 例1: 基本的なstaticメソッド参照

例えば、文字列の配列をソートする場合、`Arrays.sort`メソッドと`String`クラスの`compareTo`メソッドを使って、文字列を辞書順にソートできます。

```java
import java.util.Arrays;

public class StaticMethodReferenceExample {
    public static void main(String[] args) {
        String[] names = {"Charlie", "Alice", "Bob"};

        // ラムダ式を使ってソート
        Arrays.sort(names, (a, b) -> String.compare(a, b));

        // staticメソッド参照を使ってソート
        Arrays.sort(names, String::compareTo);

        System.out.println(Arrays.toString(names)); // [Alice, Bob, Charlie]
    }
}
```

#### 解説

- **ラムダ式**: `(a, b) -> String.compare(a, b)`は、`String.compareTo`メソッドを使って`a`と`b`を比較します。
- **staticメソッド参照**: `String::compareTo`は、`compareTo`という静的メソッドを直接参照して、同様の処理を行います。この場合、`String.compareTo`は`Comparable`インターフェースに実装されているメソッドで、`a.compareTo(b)`と同じ結果になります。

### 例2: 標準ライブラリを利用したstaticメソッド参照

次に、`Integer`クラスの`parseInt`メソッドを使って、文字列リストを整数リストに変換する例を見てみましょう。

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StaticMethodReferenceExample2 {
    public static void main(String[] args) {
        List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5");

        // ラムダ式を使って文字列を整数に変換
        List<Integer> numbers1 = stringNumbers.stream()
                                              .map(s -> Integer.parseInt(s))
                                              .collect(Collectors.toList());

        // staticメソッド参照を使って文字列を整数に変換
        List<Integer> numbers2 = stringNumbers.stream()
                                              .map(Integer::parseInt)
                                              .collect(Collectors.toList());

        System.out.println(numbers2); // [1, 2, 3, 4, 5]
    }
}
```

#### 解説

- **ラムダ式**: `.map(s -> Integer.parseInt(s))`は、文字列`"1"`を整数`1`に変換する処理を行います。
- **staticメソッド参照**: `.map(Integer::parseInt)`は、同じ処理を`parseInt`メソッド参照を使って行います。これにより、コードが簡潔になり、可読性が向上します。

### staticメソッド参照の利点

1. **簡潔さ**: ラムダ式よりもコードが短くなり、読みやすくなります。
2. **再利用性**: 既存のメソッドを直接再利用できるため、新たにラムダ式を定義する必要がありません。
3. **可読性**: メソッドの名前がそのまま使われるので、コードの意図が明確になります。

### staticメソッド参照の注意点

- **適用範囲の制限**: staticメソッド参照は、関数型インターフェースのメソッドシグネチャが、参照するstaticメソッドのシグネチャと一致する場合にのみ使用できます。例えば、引数の数や型、戻り値の型が一致している必要があります。
- **nullチェック**: staticメソッド参照が使用される際、null値に対するチェックが必要になることがあります。ラムダ式と異なり、staticメソッド参照自体にはnullチェックは含まれません。

### まとめ

staticメソッド参照は、Javaのラムダ式をさらに簡潔にするための強力なツールです。既存の静的メソッドをラムダ式の代わりに使うことで、コードをより読みやすく、明確にすることができます。静的メソッド参照を効果的に活用することで、コードの再利用性と可読性を向上させることができます。
