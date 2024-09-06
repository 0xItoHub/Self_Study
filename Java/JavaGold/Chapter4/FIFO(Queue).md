`Queue`インターフェースは、Javaにおけるコレクションの一つで、**FIFO（First-In-First-Out、先入れ先出し）**の原則に基づいてデータを管理するためのものです。`Queue`は、最初に追加された要素が最初に取り出されるという仕組みを持ちます。

### 主なメソッド
`Queue`インターフェースには、要素の追加、削除、参照を行うためのいくつかのメソッドがあります。代表的なものを紹介します：

- `add(E e)`：キューの末尾に要素を追加します。キューの容量が限界に達している場合は例外をスローします。
- `offer(E e)`：キューの末尾に要素を追加します。キューの容量が限界に達している場合は、`false`を返します（例外はスローしません）。
- `remove()`：キューの先頭の要素を削除し、その要素を返します。キューが空の場合は例外をスローします。
- `poll()`：キューの先頭の要素を削除し、その要素を返します。キューが空の場合は`null`を返します。
- `element()`：キューの先頭の要素を参照しますが、削除はしません。キューが空の場合は例外をスローします。
- `peek()`：キューの先頭の要素を参照しますが、削除はしません。キューが空の場合は`null`を返します。

### FIFOの例
以下の例では、`LinkedList`を使って`Queue`インターフェースを実装しています。`LinkedList`は`Queue`インターフェースを実装しているため、FIFOの動作を行うことができます。

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 要素をキューに追加
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        // キューのサイズを出力
        System.out.println("Queue size: " + queue.size());

        // キューから要素を取り出す（FIFO順）
        System.out.println("Poll: " + queue.poll()); // "First"
        System.out.println("Poll: " + queue.poll()); // "Second"
        System.out.println("Poll: " + queue.poll()); // "Third"

        // キューが空の状態でpoll()を呼ぶとnullを返す
        System.out.println("Poll: " + queue.poll()); // null
    }
}
```

### 実行結果:
```
Queue size: 3
Poll: First
Poll: Second
Poll: Third
Poll: null
```

### FIFOの説明
上記の例では、`offer()`メソッドを使って要素を順番に追加しています。そして、`poll()`メソッドで最初に追加された要素から順番に取り出されているため、FIFO（First-In-First-Out）の動作を確認できます。

もし他に詳細な部分や応用例を知りたい場合は、教えてください！
