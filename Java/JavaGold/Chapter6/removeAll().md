`removeAll()` メソッドは、`java.util.Collection` インターフェースに属しており、指定されたコレクションに含まれているすべての要素を、呼び出したコレクションから削除するために使用されます。`removeAll()` は、二つのコレクション間の要素の差を計算する際などに便利です。

### 概要
`removeAll()` メソッドは、呼び出し元のコレクションから、指定されたコレクションに含まれているすべての要素を削除します。指定されたコレクションが空の場合、呼び出し元のコレクションには変更がありません。

### シグネチャ
```java
boolean removeAll(Collection<?> c)
```

- **`c`**: 削除対象の要素を含むコレクションです。このコレクションに含まれるすべての要素が、呼び出し元のコレクションから削除されます。
- **戻り値**: もし要素が削除された場合は `true` を返し、削除される要素がなければ `false` を返します。

### 使い方
`removeAll()` メソッドは、リストやセットなどのコレクションに対して使うことができます。

### 例
次に、2つのリストから共通の要素を削除する例を示します。

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        List<String> toRemove = new ArrayList<>();
        toRemove.add("banana");
        toRemove.add("cherry");

        // fruits リストから toRemove リストに含まれる要素をすべて削除
        fruits.removeAll(toRemove);

        // 結果を表示
        System.out.println(fruits); // [apple]
    }
}
```

この例では、`toRemove` リストに含まれる `"banana"` と `"cherry"` が `fruits` リストから削除され、結果として `"apple"` のみが残ります。

### 動作の詳細
1. **共通要素の削除**: `removeAll()` は、呼び出し元のコレクションに含まれている要素で、指定されたコレクションにも含まれているものをすべて削除します。指定されたコレクション内にない要素はそのまま残ります。
2. **空のコレクション**: `removeAll()` に空のコレクションを渡すと、何も削除されないため、コレクションは変更されません。

### 注意点
- **重複削除**: `removeAll()` は、指定されたコレクションに含まれる要素をすべて削除しますが、削除対象が複数回登場しても、その要素は完全に削除されます。
- **パフォーマンス**: `removeAll()` の実行速度は、呼び出し元のコレクションと指定されたコレクションのサイズに依存します。特に大規模なコレクションでは、実行に時間がかかる可能性があります。
- **スレッドセーフではない**: マルチスレッド環境で使用する際は、適切な同期が必要です。

### `removeIf()` との違い
- **`removeIf()`** は、特定の条件を満たす要素を削除します（条件は `Predicate` で定義）。
- **`removeAll()`** は、指定されたコレクション内の要素すべてを削除します。

### 結論
`removeAll()` は、指定されたコレクションに含まれる要素を、呼び出し元のコレクションから効率的に削除するメソッドで、複数の要素を一括して削除する場面で便利です。
