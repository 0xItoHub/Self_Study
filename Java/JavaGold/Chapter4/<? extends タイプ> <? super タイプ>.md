Javaにおけるジェネリクスのワイルドカード`<? extends タイプ>`と`<? super タイプ>`は、それぞれ「上限境界ワイルドカード」と「下限境界ワイルドカード」と呼ばれ、型パラメータに制約を設けるための機能です。これにより、クラスやメソッドが特定の型階層の範囲内で動作するように設計できます。

これらのワイルドカードは、ジェネリクスを使ったコレクション（`List`, `Set`, `Queue`など）で特定の型の上下関係を利用して、より柔軟なコードを書く際に役立ちます。

### 1. `<? extends タイプ>`（上限境界ワイルドカード）

- **意味**：`<? extends T>`は、「`T`型または`T`のサブクラス（T自身も含む）」を受け入れることを意味します。
- **用途**：このワイルドカードは、**読み取り専用**でリストやコレクションを扱う場合に便利です。要素を取り出す（読み取る）ことはできますが、要素を追加することはできません。

#### 例：

```java
import java.util.List;

public class Main {
    // 上限境界ワイルドカードを使ったメソッド
    public static void printList(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        printList(intList);     // 出力: 1 2 3
        printList(doubleList);  // 出力: 1.1 2.2 3.3
    }
}
```

#### 説明：
- `List<? extends Number>`は、`Number`型またはそのサブクラス（`Integer`, `Double`, `Float`など）のリストを受け入れます。
- この場合、リストから要素を取り出すことはできますが、`list.add()`のように要素を追加することはできません。これは、型安全性を守るためです。なぜなら、`List<? extends Number>`に何の型が含まれているか（`Integer`か`Double`かなど）はコンパイル時には確定できないからです。

#### ポイント：
- **読み取り専用**：上限境界ワイルドカードは「読み取り」に最適で、コレクションから値を取り出すことはできますが、値の挿入はできません。
- **多様性**：`Number`のサブクラスを持つため、さまざまな数値型（`Integer`, `Double`など）のリストを同じメソッドで扱えます。

### 2. `<? super タイプ>`（下限境界ワイルドカード）

- **意味**：`<? super T>`は、「`T`型または`T`のスーパークラス（T自身も含む）」を受け入れることを意味します。
- **用途**：このワイルドカードは、**書き込み専用**の操作、つまりリストに要素を追加する際に便利です。リストに要素を追加することはできますが、要素を取り出す場合は`Object`として扱われることがあります。

#### 例：

```java
import java.util.List;
import java.util.ArrayList;

public class Main {
    // 下限境界ワイルドカードを使ったメソッド
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);  // Integerを追加
        list.add(2);  // Integerを追加
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(numberList);  // IntegerはNumberのサブクラス
        addNumbers(objectList);  // IntegerはObjectのサブクラス

        System.out.println(numberList);  // 出力: [1, 2]
        System.out.println(objectList);  // 出力: [1, 2]
    }
}
```

#### 説明：
- `List<? super Integer>`は、`Integer`型またはそのスーパークラス（`Number`, `Object`など）のリストを受け入れます。
- この場合、リストに`Integer`型の値を追加することができますが、リストから取り出すときの型は`Object`になります。

#### ポイント：
- **書き込み専用**：下限境界ワイルドカードは「書き込み」に適しており、コレクションに値を追加できますが、取り出す際には型が`Object`となる可能性があるため、具体的な型として扱うことはできません。
- **型階層の広がり**：`Integer`のスーパークラスである`Number`や`Object`を受け入れられるため、非常に柔軟です。

### 3. `<? extends T>` と `<? super T>` の違い

- **`<? extends T>`（上限境界）**は「T型**以下**」を扱う。つまり、Tまたはそのサブクラスの型を許容し、**読み取り専用**として使用するのに向いている。
- **`<? super T>`（下限境界）**は「T型**以上**」を扱う。つまり、Tまたはそのスーパークラスの型を許容し、**書き込み専用**として使用するのに向いている。

### 4. 実際の使用場面
- **`<? extends T>`**は、**読み取りが中心**となる場面でよく使われます。例えば、`List<? extends Number>`というリストは`Number`のサブクラスである任意の型を受け入れ、リストから要素を取り出すことができます。
- **`<? super T>`**は、**書き込みが中心**となる場面でよく使われます。例えば、`List<? super Integer>`というリストには`Integer`やそのサブクラスの要素を追加でき、`Integer`またはそのスーパークラスが利用されることを期待して値が取り出されます。

### 5. 具体例のまとめ

- **上限境界 (`<? extends T>`)**:
  - サブクラスも含む型の範囲に限定する。
  - **メリット**：読み取りが安全（型キャスト不要）。
  - **制約**：要素の追加ができない。
  
- **下限境界 (`<? super T>`)**:
  - スーパークラスも含む型の範囲に限定する。
  - **メリット**：要素の追加ができる。
  - **制約**：読み取りは`Object`として行う必要がある。

### まとめ

- `<? extends T>`は、T型またはそのサブクラスを扱うため、読み取り専用の用途に向いています。
- `<? super T>`は、T型またはそのスーパークラスを扱うため、書き込み専用の用途に向いています。
- これらのワイルドカードを使うことで、型安全性を保ちながら、柔軟なジェネリクスのコードを記述できるようになります。

どちらのワイルドカードを使うかは、データの**読み取りを重視するか**、**書き込みを重視するか**で決めるとよいでしょう。
