`Comparable`インターフェースと`Comparator`インターフェースは、Javaでオブジェクトの順序を定義するために使用される2つのインターフェースです。これらは、コレクションのソートや検索操作を行う際に利用されますが、それぞれ異なる目的と使い方があります。

### 1. `Comparable`インターフェース
`Comparable`インターフェースは、オブジェクト自身が自然順序付けを持つ場合に実装します。例えば、数値や文字列など、デフォルトの順序が明確に定義されているオブジェクトのクラスがこれを実装します。

- **メソッド**: `compareTo(T o)`
  - このメソッドを実装することで、現在のオブジェクト (`this`) と指定されたオブジェクト (`o`) を比較し、順序を決定します。
  - 戻り値:
    - 正の値：`this` が `o` よりも大きい。
    - 0：`this` が `o` と等しい。
    - 負の値：`this` が `o` よりも小さい。

- **使用例**:
  ```java
  public class Person implements Comparable<Person> {
      private String name;
      private int age;

      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }

      @Override
      public int compareTo(Person other) {
          return this.age - other.age;
      }
  }
  ```

### 2. `Comparator`インターフェース
`Comparator`インターフェースは、オブジェクトの自然順序付け以外の順序を定義するために使用します。このインターフェースを実装することで、複数の順序付けを提供でき、クラス外部で順序付けのロジックを定義できます。

- **メソッド**: `compare(T o1, T o2)`
  - このメソッドを実装して、2つのオブジェクトを比較し、順序を決定します。
  - 戻り値:
    - 正の値：`o1` が `o2` よりも大きい。
    - 0：`o1` が `o2` と等しい。
    - 負の値：`o1` が `o2` よりも小さい。

- **使用例**:
  ```java
  public class PersonNameComparator implements Comparator<Person> {
      @Override
      public int compare(Person p1, Person p2) {
          return p1.getName().compareTo(p2.getName());
      }
  }
  ```

### 主な違い

- **比較方法の場所**:
  - `Comparable`: クラス自体に比較方法を定義します。
  - `Comparator`: クラス外部で比較方法を定義します。

- **用途**:
  - `Comparable`: 自然順序（デフォルトの順序）を定義したい場合。
  - `Comparator`: 複数の異なる順序付けを提供したい場合、またはクラスを変更せずに順序を定義したい場合。

これにより、`Comparable`はデフォルトのソート順を持つクラスに適しており、`Comparator`はカスタムのソート順が必要な場合に役立ちます。
