`Collectors`クラスは、Javaの`java.util.stream`パッケージに含まれているユーティリティクラスで、ストリーム操作の結果をさまざまな形に収集するためのメソッドが多数提供されています。`Collectors`クラスのメソッドは、主にストリームAPIと組み合わせて使用され、ストリームの結果をリストやセット、マップなどのコレクションに変換したり、集計操作を行ったりするために使用されます。

### 主な`Collectors`クラスのメソッド

#### 1. `toList()`
- **説明**: ストリームの要素を`List`として収集します。
- **使用例**:
  ```java
  List<String> list = Stream.of("a", "b", "c")
                            .collect(Collectors.toList());
  System.out.println(list); // [a, b, c]
  ```

#### 2. `toSet()`
- **説明**: ストリームの要素を`Set`として収集します。重複する要素は自動的に排除されます。
- **使用例**:
  ```java
  Set<String> set = Stream.of("a", "b", "c", "a")
                          .collect(Collectors.toSet());
  System.out.println(set); // [a, b, c]
  ```

#### 3. `toMap()`
- **説明**: ストリームの要素をキーと値にマッピングし、`Map`として収集します。キーが重複する場合は例外が発生します。
- **使用例**:
  ```java
  Map<Integer, String> map = Stream.of("apple", "banana", "cherry")
                                   .collect(Collectors.toMap(
                                       String::length,   // キー：文字列の長さ
                                       Function.identity()  // 値：文字列自体
                                   ));
  System.out.println(map); // {5=apple, 6=banana, 6=cherry} (キーが重複するため例外発生)
  ```

- **カスタムのマージ関数を使ってキーの重複を処理**:
  ```java
  Map<Integer, String> map = Stream.of("apple", "banana", "cherry")
                                   .collect(Collectors.toMap(
                                       String::length,   // キー：文字列の長さ
                                       Function.identity(), // 値：文字列自体
                                       (existing, replacement) -> existing + "," + replacement  // マージ関数
                                   ));
  System.out.println(map); // {5=apple, 6=banana,cherry}
  ```

#### 4. `joining()`
- **説明**: ストリーム内の文字列を結合して1つの文字列にします。オプションで区切り文字やプレフィックス、サフィックスを指定することもできます。
- **使用例**:
  ```java
  String result = Stream.of("a", "b", "c")
                        .collect(Collectors.joining());
  System.out.println(result); // "abc"

  String resultWithDelimiter = Stream.of("a", "b", "c")
                                     .collect(Collectors.joining(", "));
  System.out.println(resultWithDelimiter); // "a, b, c"
  ```

#### 5. `groupingBy()`
- **説明**: ストリームの要素を特定の条件でグループ化し、`Map`として収集します。
- **使用例**:
  ```java
  Map<Integer, List<String>> groupedByLength = Stream.of("apple", "banana", "cherry", "date")
                                                     .collect(Collectors.groupingBy(String::length));
  System.out.println(groupedByLength); // {5=[apple], 6=[banana, cherry], 4=[date]}
  ```

#### 6. `partitioningBy()`
- **説明**: ストリームの要素をブール条件で2つのグループに分割し、`Map<Boolean, List<T>>`として収集します。
- **使用例**:
  ```java
  Map<Boolean, List<String>> partitioned = Stream.of("apple", "banana", "cherry", "date")
                                                 .collect(Collectors.partitioningBy(s -> s.length() > 5));
  System.out.println(partitioned); // {false=[apple, date], true=[banana, cherry]}
  ```

#### 7. `counting()`
- **説明**: ストリームの要素の数をカウントし、結果を`Long`として返します。
- **使用例**:
  ```java
  long count = Stream.of("a", "b", "c")
                     .collect(Collectors.counting());
  System.out.println(count); // 3
  ```

#### 8. `summarizingInt()`, `summarizingDouble()`, `summarizingLong()`
- **説明**: ストリーム内の要素に対して、合計、平均、最大、最小などの統計情報をまとめて計算し、`IntSummaryStatistics`などの統計オブジェクトを返します。
- **使用例**:
  ```java
  IntSummaryStatistics stats = Stream.of(1, 2, 3, 4, 5)
                                     .collect(Collectors.summarizingInt(Integer::intValue));
  System.out.println(stats); // IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
  ```

#### 9. `reducing()`
- **説明**: ストリームの要素を集約（リダクション）し、1つの結果を得るために使用します。リダクション操作は、与えられたバイナリオペレータを使って行われます。
- **使用例**:
  ```java
  int sum = Stream.of(1, 2, 3, 4)
                 .collect(Collectors.reducing(0, Integer::sum));
  System.out.println(sum); // 10
  ```

### まとめ

`Collectors`クラスは、Javaのストリーム操作における重要なツールであり、データを効率的に収集・変換・集計するための豊富なメソッドが提供されています。これらのメソッドを使用することで、ストリームから得られる結果をリストやセット、マップに変換したり、文字列を結合したり、集約操作を簡潔に行ったりすることが可能です。`Collectors`クラスをうまく活用することで、複雑なデータ処理を簡単に実装することができます。
