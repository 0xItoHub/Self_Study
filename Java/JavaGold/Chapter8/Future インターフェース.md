Java の `Future` インターフェースは、非同期タスクの完了状態や結果を取得するために使用されます。並行処理を行う際に、タスクを非同期で実行し、そのタスクの終了や結果を待たずに他の処理を進めることができる点が特徴です。`Future` は、`ExecutorService` のメソッドを使って非同期タスクを管理します。

### `Future` インターフェースの主な機能

1. **非同期タスクの実行結果を取得**  
   タスクが終了すると、その結果を `Future` オブジェクトを通じて取得できます。タスクが完了する前に結果を取得しようとすると、スレッドがブロックされ、タスクの完了まで待機します。

2. **タスクのキャンセル**  
   `Future` オブジェクトを使って、実行中のタスクをキャンセルすることができます。

3. **タスクの進捗状況の確認**  
   `Future` を使って、タスクが完了しているかどうか、キャンセルされているかどうかを確認できます。

### `Future` インターフェースのメソッド

```java
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}
```

#### メソッドの詳細

- **`cancel(boolean mayInterruptIfRunning)`**  
  タスクをキャンセルします。`mayInterruptIfRunning` を `true` にすると、すでに実行中のタスクにも割り込むことができます。

- **`isCancelled()`**  
  タスクがキャンセルされたかどうかを確認します。キャンセルされた場合は `true` を返します。

- **`isDone()`**  
  タスクが完了したかどうかを確認します。完了していれば `true` を返します。

- **`get()`**  
  タスクの結果を取得します。タスクが完了するまで待機し、完了した後に結果を返します。タスクの実行中に例外が発生した場合は `ExecutionException` がスローされます。

- **`get(long timeout, TimeUnit unit)`**  
  タイムアウトを指定して結果を取得します。指定された時間内にタスクが完了しない場合は `TimeoutException` がスローされます。

### `Future` の使い方

`Future` オブジェクトは、`ExecutorService` でタスクを非同期に実行するときに取得できます。たとえば、`Callable` インターフェースを使って戻り値を持つタスクを非同期で実行し、その結果を `Future` オブジェクトで受け取ります。

### 例: `Future` を使った非同期処理

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        // スレッドプールを作成
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Callableを使ってタスクを定義
        Callable<Integer> task = () -> {
            System.out.println("タスクを実行しています...");
            Thread.sleep(2000); // 2秒間スリープ
            return 42; // 結果を返す
        };

        // タスクを非同期で実行し、Futureを取得
        Future<Integer> future = executor.submit(task);

        try {
            // 結果が完了するまで待機し、取得
            System.out.println("結果を待っています...");
            Integer result = future.get(); // タスク完了後に結果を取得
            System.out.println("タスクの結果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // スレッドプールを終了
        executor.shutdown();
    }
}
```

#### 実行結果:
```
タスクを実行しています...
結果を待っています...
タスクの結果: 42
```

このコードでは、`Callable` を使ってタスクを定義し、`ExecutorService.submit()` で非同期に実行しています。タスクが完了すると、`Future.get()` を使って結果を取得します。

### タスクのキャンセル

`Future.cancel()` メソッドを使って、実行中のタスクをキャンセルすることができます。次の例では、タスクがキャンセルされるシナリオを示しています。

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(5000); // 5秒間スリープ
            return 42;
        };

        Future<Integer> future = executor.submit(task);

        // 1秒後にタスクをキャンセル
        Thread.sleep(1000);
        boolean canceled = future.cancel(true);

        if (canceled) {
            System.out.println("タスクがキャンセルされました");
        } else {
            System.out.println("タスクはすでに実行が完了しています");
        }

        executor.shutdown();
    }
}
```

#### 実行結果:
```
タスクがキャンセルされました
```

このコードでは、`future.cancel(true)` によってタスクがキャンセルされ、タスクが完了する前に終了しています。

### まとめ

- **`Future` インターフェース** は、非同期タスクの結果を管理するために使用され、タスクの完了状態や結果の取得、キャンセルをサポートします。
- **`Callable`** を使って戻り値を持つタスクを定義し、`ExecutorService.submit()` でタスクを非同期に実行できます。
- **`Future.get()`** を使って、タスクが完了するまで待機し、結果を取得できます。また、キャンセルや進捗確認も可能です。

これにより、Java の並行プログラミングで効率的に非同期タスクを管理できるようになります。
