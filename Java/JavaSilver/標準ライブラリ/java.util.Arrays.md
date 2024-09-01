`java.util.Arrays` は、Javaの標準ライブラリに含まれるユーティリティクラスで、配列操作に関するさまざまな静的メソッドを提供します。このクラスは、配列のソート、検索、比較、フィリング、文字列表現の生成など、多くの便利な機能を提供します。

### 主なメソッド
`java.util.Arrays` クラスで提供される主なメソッドを以下に紹介します。

#### 1. `sort()`
- **説明**: 配列の要素を昇順にソートします。`int`、`double`、`Object`型の配列などに使用できます。
- **使用例**:
  ```java
  int[] numbers = {3, 1, 4, 1, 5};
  Arrays.sort(numbers);
  System.out.println(Arrays.toString(numbers)); // [1, 1, 3, 4, 5]
  ```

#### 2. `binarySearch()`
- **説明**: ソート済みの配列に対して、指定した値のインデックスを二分探索で返します。配列がソートされていない場合、結果は未定義です。
- **使用例**:
  ```java
  int[] numbers = {1, 1, 3, 4, 5};
  int index = Arrays.binarySearch(numbers, 4);
  System.out.println(index); // 3
  ```

#### 3. `equals()`
- **説明**: 2つの配列が同じ要素を同じ順序で持っているかどうかを比較します。
- **使用例**:
  ```java
  int[] a = {1, 2, 3};
  int[] b = {1, 2, 3};
  boolean result = Arrays.equals(a, b);
  System.out.println(result); // true
  ```

#### 4. `fill()`
- **説明**: 配列のすべての要素を指定された値で埋めます。
- **使用例**:
  ```java
  int[] numbers = new int[5];
  Arrays.fill(numbers, 42);
  System.out.println(Arrays.toString(numbers)); // [42, 42, 42, 42, 42]
  ```

#### 5. `toString()`
- **説明**: 配列の内容を文字列として表現します。これにより、配列の要素がコンマで区切られた形式で返されます。
- **使用例**:
  ```java
  int[] numbers = {1, 2, 3};
  String str = Arrays.toString(numbers);
  System.out.println(str); // [1, 2, 3]
  ```

#### 6. `copyOf()`
- **説明**: 元の配列の指定された長さのコピーを作成します。新しい配列の長さが元の配列よりも長い場合、残りの要素はデフォルト値で埋められます。
- **使用例**:
  ```java
  int[] original = {1, 2, 3};
  int[] copy = Arrays.copyOf(original, 5);
  System.out.println(Arrays.toString(copy)); // [1, 2, 3, 0, 0]
  ```

#### 7. `copyOfRange()`
- **説明**: 配列の指定された範囲をコピーします。開始インデックスは含まれ、終了インデックスは含まれません。
- **使用例**:
  ```java
  int[] original = {1, 2, 3, 4, 5};
  int[] rangeCopy = Arrays.copyOfRange(original, 1, 4);
  System.out.println(Arrays.toString(rangeCopy)); // [2, 3, 4]
  ```

#### 8. `asList()`
- **説明**: 配列をリストに変換します。生成されたリストは固定サイズのリストであり、配列の変更はリストに反映され、逆も同様です。
- **使用例**:
  ```java
  String[] array = {"apple", "banana", "cherry"};
  List<String> list = Arrays.asList(array);
  System.out.println(list); // [apple, banana, cherry]
  ```

### 注意点
- `Arrays.asList()` で作成されたリストは固定サイズであり、`add()` や `remove()` などの操作を行うと、`UnsupportedOperationException` がスローされます。
- `binarySearch()` を使用する場合、配列が事前にソートされていることを確認してください。そうでないと、正しい結果が得られません。

### まとめ
`java.util.Arrays` クラスは、配列を操作する際に非常に便利なメソッドを提供しています。これらのメソッドを活用することで、配列の処理を効率的に行うことができ、コードの簡潔さと可読性を向上させることができます。
