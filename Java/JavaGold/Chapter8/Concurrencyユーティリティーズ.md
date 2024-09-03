Javaの標準ライブラリには、スレッドの並行処理をより安全かつ効率的に行うためのユーティリティクラスが多数含まれています。これらのユーティリティは、Javaの`java.util.concurrent`パッケージにまとめられており、マルチスレッドプログラミングを容易にし、競合状態やデッドロックを防ぐのに役立ちます。以下は、主要なConcurrencyユーティリティの解説です。

### 1. Executor Framework (`Executor`、`ExecutorService`、`Executors`)
`Executor`フレームワークは、スレッドの管理と実行を簡素化するための仕組みを提供します。`ExecutorService`インターフェースは、スレッドプールの管理を行い、複数のタスクを効率的に実行できます。

- **`Executor`インターフェース**: タスクを非同期に実行するためのメソッドを持つ基本インターフェースです。`execute(Runnable command)`メソッドでタスクを実行します。
- **`ExecutorService`インターフェース**: `Executor`を拡張したインターフェースで、タスクの実行の制御、タスクの終了、スレッドプールの管理などの機能を提供します。`submit()`メソッドでタスクを実行し、`Future`オブジェクトを返します。
- **`Executors`クラス**: `ExecutorService`のインスタンスを生成するためのファクトリクラスです。以下のような便利メソッドを提供します。
  - `newFixedThreadPool(int n)`: 固定サイズのスレッドプールを作成
  - `newCachedThreadPool()`: 必要に応じてスレッドを生成するプールを作成
  - `newSingleThreadExecutor()`: 単一スレッドでタスクを実行する`ExecutorService`を作成

```java
ExecutorService executor = Executors.newFixedThreadPool(3);

for (int i = 0; i < 10; i++) {
    executor.submit(() -> {
        System.out.println("Task executed by: " + Thread.currentThread().getName());
    });
}

executor.shutdown(); // スレッドプールの終了
```

### 2. Future and Callable
`Future`は、非同期計算の結果を表すオブジェクトです。`Callable`インターフェースを使用すると、戻り値を持つタスクを実行できます。`Runnable`は戻り値がないのに対し、`Callable`はジェネリクスを用いて任意の型の戻り値を持つことができます。

- **`Callable<V>`インターフェース**: タスクを実行して結果を返すメソッド`call()`を持つインターフェースです。
- **`Future<V>`インターフェース**: `Callable`または`Runnable`によって実行されるタスクの結果を表します。タスクの完了を待機したり、結果を取得したりできます。

```java
Callable<Integer> task = () -> {
    Thread.sleep(1000);
    return 123;
};

ExecutorService executor = Executors.newFixedThreadPool(2);
Future<Integer> future = executor.submit(task);

try {
    Integer result = future.get(); // タスクの完了を待ち、結果を取得
    System.out.println("Result: " + result);
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

executor.shutdown();
```

### 3. Locks (`ReentrantLock`, `ReadWriteLock`)
Javaでは、スレッドセーフなコードを記述するために`Lock`インターフェースとその実装クラスが提供されています。`Lock`は、従来の同期機構（`synchronized`）よりも柔軟性があります。

- **`ReentrantLock`クラス**: 再入可能なロックを提供します。`lock()`メソッドでロックを取得し、`unlock()`メソッドでロックを解放します。再入可能とは、同じスレッドが複数回ロックを取得できることを意味します。
- **`ReadWriteLock`インターフェース**: 読み取りと書き込みのロックを分離して管理するためのインターフェースです。読み取りは複数のスレッドが同時に行えますが、書き込みは単一のスレッドしか行えません。

```java
ReentrantLock lock = new ReentrantLock();

lock.lock();
try {
    // クリティカルセクション
    System.out.println("Locked section");
} finally {
    lock.unlock(); // ロックを解放
}
```

### 4. Concurrent Collections
`java.util.concurrent`パッケージには、スレッドセーフなコレクションがいくつか提供されています。これらのコレクションは、複数のスレッドが同時にアクセスしても安全に動作するように設計されています。

- **`ConcurrentHashMap`**: 複数のスレッドから同時に操作できるハッシュマップです。読み取り操作はロックを必要とせず、書き込み操作でも部分的なロックしか使用しないため、従来の`Hashtable`よりも高いスループットを持ちます。
- **`CopyOnWriteArrayList`**: 要素の追加や削除時にコピーが行われる配列リストです。読み取り操作が非常に頻繁で、書き込み操作が稀な場合に有効です。

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("key1", 1);
map.put("key2", 2);

map.forEach((key, value) -> System.out.println(key + ": " + value));
```

### 5. Synchronizers (`CountDownLatch`, `CyclicBarrier`, `Semaphore`)
スレッド間の調整や同期を行うためのツールも提供されています。

- **`CountDownLatch`**: 複数のスレッドが特定のイベントを待つ場合に使用します。`countDown()`メソッドでカウントを減らし、カウントがゼロになると`await()`メソッドを待機していたスレッドが再開します。
- **`CyclicBarrier`**: 複数のスレッドが全員揃ってから次のステップに進むことを保証するために使用します。全てのスレッドが`await()`メソッドを呼び出すとバリアが解除され、全てのスレッドが同時に再開します。
- **`Semaphore`**: リソースへのアクセスを制限するために使用されるカウンターです。`acquire()`メソッドでリソースを取得し、`release()`メソッドでリソースを解放します。

```java
CountDownLatch latch = new CountDownLatch(3);

for (int i = 0; i < 3; i++) {
    new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " is doing work");
        latch.countDown(); // カウントを減らす
    }).start();
}

try {
    latch.await(); // 全てのスレッドが完了するまで待機
    System.out.println("All threads have finished");
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

### まとめ
JavaのConcurrencyユーティリティーズは、スレッドの管理、スレッド間の調整、データの一貫性の維持、競合状態の防止を容易にする強力なツールを提供します。これらのユーティリティを効果的に使用することで、複雑な並行処理をより簡潔で安全に実装することが可能です。
