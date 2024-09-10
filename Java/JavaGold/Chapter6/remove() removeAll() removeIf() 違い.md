以下は、`remove()`、`removeAll()`、`removeIf()` の違いを説明する表です。引数に何を取るかも含めて、これらのメソッドの違いを明確にまとめています。

| メソッド        | 引数                         | 動作の違い                                                                                     | 戻り値                  |
|-----------------|------------------------------|------------------------------------------------------------------------------------------------|-------------------------|
| **`remove()`**  | `Object o`                    | 指定された要素 `o` をコレクションから1つだけ削除。存在しない場合は何もしない。                                      | 要素が削除された場合 `true`、削除されなかった場合 `false` |
| **`removeAll()`**| `Collection<?> c`             | 引数に指定したコレクション `c` に含まれるすべての要素を、呼び出し元のコレクションから削除。<br>共通の要素がすべて削除される。 | 要素が削除された場合 `true`、削除されなかった場合 `false` |
| **`removeIf()`**| `Predicate<? super E> filter` | 条件 `filter` に一致するすべての要素を削除。<br>ラムダ式やメソッド参照を使って条件を指定できる。                        | 要素が削除された場合 `true`、削除されなかった場合 `false` |

### それぞれのメソッドの詳細

#### 1. `remove(Object o)`
- **引数**: 削除したい特定の要素（オブジェクト）。
- **使用例**:
  ```java
  List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
  list.remove("banana");  // "banana" だけ削除
  ```

#### 2. `removeAll(Collection<?> c)`
- **引数**: 削除したい要素を含むコレクション。
- **使用例**:
  ```java
  List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
  List<String> toRemove = new ArrayList<>(Arrays.asList("banana", "cherry"));
  list.removeAll(toRemove);  // "banana" と "cherry" を削除
  ```

#### 3. `removeIf(Predicate<? super E> filter)`
- **引数**: 削除条件を指定する述語（`Predicate`）。
- **使用例**:
  ```java
  List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
  list.removeIf(fruit -> fruit.startsWith("b"));  // "banana" を削除
  ```

### 違いのまとめ
- **`remove()`** は、指定した1つの要素だけを削除する。
- **`removeAll()`** は、引数に指定されたコレクションのすべての要素を削除する。
- **`removeIf()`** は、条件に一致するすべての要素を削除する。

それぞれのメソッドは用途に応じて使い分けることができます。例えば、単一要素の削除には `remove()`、複数の要素を削除する場合は `removeAll()` や条件に基づいた削除には `removeIf()` が便利です。
