Javaの`Deque`インターフェースは、**両端キュー**（Double Ended Queue）を表しており、要素を**両端（前と後ろ）から挿入または削除**できるデータ構造です。通常の`Queue`インターフェースは先入れ先出し（FIFO）の動作をしますが、`Deque`はこの動作に加えて、スタックのように後入れ先出し（LIFO）でも動作することができます。

`Deque`は、スタックやキューのように動作させることが可能で、両端から要素の追加や削除を効率的に行いたい場合に便利です。`Deque`インターフェースの実装クラスには、例えば`ArrayDeque`や`LinkedList`などがあります。

### `Deque`の主なメソッド

`Deque`は、以下のように要素の追加、削除、参照を前端（first）や後端（last）から行うためのメソッドを提供します。

- **要素の追加**
  - `addFirst(E e)`：前端に要素を追加します。容量制限がある場合に例外をスローします。
  - `addLast(E e)`：後端に要素を追加します。容量制限がある場合に例外をスローします。
  - `offerFirst(E e)`：前端に要素を追加します。容量制限がある場合、失敗したら`false`を返します。
  - `offerLast(E e)`：後端に要素を追加します。容量制限がある場合、失敗したら`false`を返します。

- **要素の削除**
  - `removeFirst()`：前端から要素を削除し、削除した要素を返します。データが空の場合は例外をスローします。
  - `removeLast()`：後端から要素を削除し、削除した要素を返します。データが空の場合は例外をスローします。
  - `pollFirst()`：前端から要素を削除し、削除した要素を返します。データが空の場合は`null`を返します。
  - `pollLast()`：後端から要素を削除し、削除した要素を返します。データが空の場合は`null`を返します。

- **要素の参照**
  - `getFirst()`：前端の要素を取得します。データが空の場合は例外をスローします。
  - `getLast()`：後端の要素を取得します。データが空の場合は例外をスローします。
  - `peekFirst()`：前端の要素を取得します。データが空の場合は`null`を返します。
  - `peekLast()`：後端の要素を取得します。データが空の場合は`null`を返します。

- **スタックとしての操作**
  - `push(E e)`：スタックとして前端に要素を追加します（`addFirst()`と同等）。
  - `pop()`：スタックとして前端から要素を削除し、その要素を返します（`removeFirst()`と同等）。

### `Deque`の使用例

以下のコードは、`Deque`インターフェースを実装した`ArrayDeque`クラスを使った例です。

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        // Dequeインターフェースを実装したArrayDequeのインスタンスを作成
        Deque<String> deque = new ArrayDeque<>();

        // 要素を追加 (両端に追加)
        deque.addFirst("A");  // 前端に追加
        deque.addLast("B");   // 後端に追加
        deque.offerFirst("C"); // 前端に追加
        deque.offerLast("D");  // 後端に追加

        System.out.println("Deque after additions: " + deque);

        // 前端の要素を参照 (削除しない)
        System.out.println("First element: " + deque.peekFirst());
        
        // 後端の要素を参照 (削除しない)
        System.out.println("Last element: " + deque.peekLast());

        // スタック操作 (pushで前端に追加)
        deque.push("E");
        System.out.println("Deque after push: " + deque);

        // スタック操作 (popで前端から削除)
        System.out.println("Popped element: " + deque.pop());
        System.out.println("Deque after pop: " + deque);

        // 両端から要素を削除
        System.out.println("Removed first element: " + deque.removeFirst());
        System.out.println("Removed last element: " + deque.removeLast());
        System.out.println("Deque after removals: " + deque);
    }
}
```

### 実行結果：

```
Deque after additions: [C, A, B, D]
First element: C
Last element: D
Deque after push: [E, C, A, B, D]
Popped element: E
Deque after pop: [C, A, B, D]
Removed first element: C
Removed last element: D
Deque after removals: [A, B]
```

### `Deque`の用途

`Deque`は、以下のような用途で使われます。

1. **キュー（FIFO）として使用**：通常のキューとして、`addLast()`で要素を追加し、`removeFirst()`で要素を取り出すことで、先入れ先出しの動作をします。
2. **スタック（LIFO）として使用**：`push()`で要素を追加し、`pop()`で要素を取り出すことで、後入れ先出しのスタックとしても使えます。
3. **データの両端操作**：`Deque`は両端からの操作が可能で、データの前後どちらでも追加・削除ができます。このため、効率的なバッファリングや両端からのデータ処理が必要なアルゴリズムに適しています。

### 実装クラス

`Deque`インターフェースには、次の代表的な実装クラスがあります。

1. **`ArrayDeque`**:
   - 配列を使ってデックを実装したクラス。サイズの制限がなく、`null`要素は許されない。
   - `ArrayDeque`は一般的に`Stack`クラスや`LinkedList`よりも効率的なスタックとキューの実装です。
   
   ```java
   Deque<String> deque = new ArrayDeque<>();
   ```

2. **`LinkedList`**:
   - 両端リストでデックを実装したクラス。`Deque`インターフェースを実装しているため、キューやスタックとしても使えます。
   
   ```java
   Deque<String> deque = new LinkedList<>();
   ```

### まとめ

- `Deque`インターフェースは、データの両端から要素の追加・削除ができるデータ構造です。
- キュー（FIFO）とスタック（LIFO）の両方の機能を提供します。
- `ArrayDeque`や`LinkedList`が代表的な実装クラスです。
- 主なメソッドには、要素の追加、削除、参照を行うものがあり、両端から操作できます。

`Deque`を使用することで、柔軟なキューやスタックの操作が可能になります。特に、両端からの操作が必要なシチュエーションや効率的なデータ処理が求められる場面で有効です。
