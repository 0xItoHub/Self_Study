Javaの`Queue`インターフェースは、コレクションフレームワークの一部で、**FIFO（First-In-First-Out、先入れ先出し）**の順序を持つデータ構造を表します。`Queue`インターフェースを実装するクラスには、`LinkedList`や`PriorityQueue`などがあります。`Queue`は一般的に要素を順序通りに保持し、最初に追加された要素が最初に取り出されます。

### 主なメソッド
- **`add(E e)`**: 要素をキューに追加します。容量制限を超える場合、例外（`IllegalStateException`）をスローします。
- **`offer(E e)`**: 要素をキューに追加します。容量制限を超える場合、`false`を返します。
- **`remove()`**: キューの先頭要素を削除し、その要素を返します。キューが空の場合、`NoSuchElementException`をスローします。
- **`poll()`**: キューの先頭要素を削除し、その要素を返します。キューが空の場合、`null`を返します。
- **`element()`**: キューの先頭要素を返しますが、削除はしません。キューが空の場合、`NoSuchElementException`をスローします。
- **`peek()`**: キューの先頭要素を返しますが、削除はしません。キューが空の場合、`null`を返します。

### `Queue`の実装クラス
1. **`LinkedList`**: `Queue`インターフェースを実装する代表的なクラスで、FIFOの特性を持ちながらリストの機能も提供します。
2. **`PriorityQueue`**: 要素を自然順序や指定されたコンパレータに基づいて優先度付きで保持するキューです。FIFOではなく、要素の順序は優先度に基づきます。

### 使用例
以下は、`LinkedList`を使用した`Queue`の例です。

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Queueの作成
        Queue<String> queue = new LinkedList<>();

        // 要素の追加
        queue.add("Apple");
        queue.offer("Banana");
        queue.add("Cherry");

        // Queueの状態
        System.out.println("Queue: " + queue);

        // 先頭要素の取得と削除
        String head = queue.poll();
        System.out.println("Polled element: " + head); // "Apple"

        // Queueの状態を再確認
        System.out.println("Queue after poll: " + queue);

        // 先頭要素の確認（削除しない）
        String first = queue.peek();
        System.out.println("Peek element: " + first); // "Banana"

        // 先頭要素の削除
        queue.remove();
        System.out.println("Queue after remove: " + queue); // "Cherry"のみ残る
    }
}
```

### 特徴
- **FIFO順序**: 通常、最初に追加された要素が最初に取り出されます。ただし、`PriorityQueue`のように、順序が優先度に基づいて変わる実装もあります。
- **スレッドセーフではない**: `Queue`インターフェースのデフォルト実装はスレッドセーフではありません。複数のスレッドから同時にアクセスする場合は、`ConcurrentLinkedQueue`のようなスレッドセーフな実装を使用するか、適切な同期を行う必要があります。
- **例外と特殊値**: `Queue`の操作では、エラー時に例外をスローするメソッドと、特殊値を返すメソッド（`poll()`や`offer()`など）の両方が提供されています。

`Queue`インターフェースは、バッファリング、タスク管理、待ち行列の実装など、さまざまな場面で役立ちます。
