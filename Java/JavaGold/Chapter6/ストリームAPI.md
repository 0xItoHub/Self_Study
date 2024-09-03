JavaのストリームAPI（Stream API）は、Java 8で導入された強力なツールで、コレクションや配列などのデータソースに対して、宣言的にデータ処理を行うことができます。ストリームは、データの集合を表現し、そのデータに対する一連の操作をサポートします。これにより、ループや条件分岐などの従来の手続きを簡潔な操作チェーンに置き換えることができます。

### ストリームAPIの基本

ストリームAPIは、以下の3つの要素から構成されます：

1. **ソース（Source）**: ストリームが処理するデータのソースです。ソースは、コレクション、配列、I/Oチャネルなど、さまざまな形式のデータソースから生成されます。

2. **中間操作（Intermediate Operation）**: ストリーム内のデータを変換またはフィルタリングする操作です。中間操作は遅延評価され、ストリームのパイプラインを構築します。中間操作はストリームを返すため、チェーンして複数の操作を行うことができます。

3. **終端操作（Terminal Operation）**: ストリームのパイプラインを実行し、結果を生成する操作です。終端操作は1つの結果を返すか、操作を実行してストリームを消費します。

### ストリームの作成

ストリームは、主にコレクションや配列から生成されます。例えば、`List`や`Set`などのコレクションから生成する場合は`stream()`メソッドを使用します。

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExample {
    public static void main(String[] args) {
        // リストからストリームを作成
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> nameStream = names.stream();

        // 配列からストリームを作成
        String[] nameArray = {"Alice", "Bob", "Charlie"};
        Stream<String> arrayStream = Arrays.stream(nameArray);
    }
}
```

### 中間操作の例

中間操作は、ストリームを処理し、新しいストリームを返します。代表的な中間操作には、`filter`、`map`、`sorted`、`distinct`などがあります。

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // フィルタリング: "B"で始まる名前だけを選択
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("B"))
                                          .collect(Collectors.toList());

        System.out.println(filteredNames); // 出力: [Bob]

        // マッピング: 各名前を大文字に変換
        List<String> upperCaseNames = names.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        System.out.println(upperCaseNames); // 出力: [ALICE, BOB, CHARLIE, DAVID]

        // ソート: 名前をアルファベット順にソート
        List<String> sortedNames = names.stream()
                                        .sorted()
                                        .collect(Collectors.toList());

        System.out.println(sortedNames); // 出力: [Alice, Bob, Charlie, David]
    }
}
```

### 終端操作の例

終端操作はストリームの処理を完了し、結果を生成します。代表的な終端操作には、`collect`、`forEach`、`reduce`、`count`、`findFirst`などがあります。

```java
import java.util.Arrays;
import java.util.List;

public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // forEach: 各名前をコンソールに出力
        names.stream().forEach(System.out::println);

        // count: 名前の数を数える
        long count = names.stream().count();
        System.out.println("Number of names: " + count); // 出力: 4

        // findFirst: 最初の名前を取得
        String first = names.stream().findFirst().orElse("No names");
        System.out.println("First name: " + first); // 出力: Alice

        // reduce: 名前を連結して1つの文字列にする
        String concatenatedNames = names.stream()
                                        .reduce((name1, name2) -> name1 + ", " + name2)
                                        .orElse("No names");

        System.out.println("Concatenated names: " + concatenatedNames); // 出力: Alice, Bob, Charlie, David
    }
}
```

### ストリームの特徴

1. **遅延評価**: 中間操作は遅延評価されます。これは、終端操作が実行されるまで中間操作が実際には実行されないことを意味します。この特性により、ストリームは効率的に動作します。

2. **不変性**: ストリームの操作は元のデータソースを変更しません。すべての操作は新しいストリームを生成し、元のコレクションや配列には影響を与えません。

3. **パイプライン処理**: ストリームは、複数の中間操作をチェーンでつなげることができ、これにより複雑なデータ処理をシンプルな表現で行うことができます。

4. **並列処理**: ストリームは並列処理を簡単にサポートしています。`parallelStream()`メソッドを使用することで、データの並列処理を簡単に実現できます。

### ストリームAPIのまとめ

JavaのストリームAPIは、コレクションや配列などのデータを効率的に処理するための強力なツールです。宣言的なスタイルでデータ処理を行うことができ、従来の命令的なコードよりも簡潔で読みやすいコードを作成できます。ストリームの中間操作と終端操作を組み合わせることで、さまざまなデータ操作を行うことができ、並列処理も簡単に行えます。
