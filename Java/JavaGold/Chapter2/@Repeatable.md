`@Repeatable`は、Java 8で導入されたメタアノテーションで、同じアノテーションを同じプログラム要素（クラス、メソッド、フィールドなど）に複数回適用できるようにするためのアノテーションです。通常、アノテーションは同じ要素に1回しか適用できませんが、`@Repeatable`を使うことで、同じアノテーションを複数回適用できるようになります。

### `@Repeatable`の使用方法

`@Repeatable`を使用するためには、2つのアノテーションを定義する必要があります。

1. **リピート可能なアノテーション**:
   - 実際に複数回適用されるアノテーションです。
2. **コンテナアノテーション**:
   - リピート可能なアノテーションを配列として保持するためのアノテーションです。このアノテーションが内部でリピート可能なアノテーションを格納します。

### 例：`@Repeatable`の定義と使用

#### 1. リピート可能なアノテーションの定義

```java
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// リピート可能なアノテーションの定義
@Repeatable(Schedules.class)  // コンテナアノテーションを指定
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedule {
    String day();
}
```

この`Schedule`アノテーションは、複数回適用可能なリピート可能アノテーションです。

#### 2. コンテナアノテーションの定義

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// コンテナアノテーションの定義
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedules {
    Schedule[] value();
}
```

`Schedules`アノテーションは、`Schedule`アノテーションを配列として保持するためのコンテナアノテーションです。

#### 3. リピート可能なアノテーションの使用

```java
public class Event {

    @Schedule(day = "Monday")
    @Schedule(day = "Wednesday")
    @Schedule(day = "Friday")
    public void weeklyMeeting() {
        // ミーティングのロジック
    }
}
```

ここでは、`Schedule`アノテーションが`weeklyMeeting`メソッドに3回適用されています。これは`@Repeatable`によって可能になっています。

### `@Repeatable`アノテーションの動作

- **コンパイル時の挙動**: リピート可能なアノテーションは、コンパイル時にコンテナアノテーションにまとめられます。つまり、`@Schedule(day = "Monday")`、`@Schedule(day = "Wednesday")`、`@Schedule(day = "Friday")`はコンパイル時に`@Schedules`アノテーションの配列にまとめられます。
  
- **リフレクションでの取得**: 実行時にリフレクションを使用してリピート可能なアノテーションを取得するときは、リピート可能なアノテーションとして取得するか、コンテナアノテーションとして取得するかを選べます。

#### 例：リフレクションでの取得

```java
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Method method = Event.class.getMethod("weeklyMeeting");

        // リピート可能なアノテーションを取得
        Schedule[] schedules = method.getAnnotationsByType(Schedule.class);
        for (Schedule schedule : schedules) {
            System.out.println(schedule.day());
        }

        // コンテナアノテーションを取得
        Schedules container = method.getAnnotation(Schedules.class);
        for (Schedule schedule : container.value()) {
            System.out.println(schedule.day());
        }
    }
}
```

### 実行結果

```plaintext
Monday
Wednesday
Friday
Monday
Wednesday
Friday
```

### まとめ

- **`@Repeatable`**は、同じアノテーションを同じプログラム要素に複数回適用できるようにするためのメタアノテーションです。
- **リピート可能なアノテーション**と、それを保持する**コンテナアノテーション**を定義する必要があります。
- リピート可能なアノテーションは、コンパイル時に自動的にコンテナアノテーションにまとめられ、リフレクションを使って個別に、またはコンテナとして取得できます。

`@Repeatable`を使うことで、同じメタデータを複数回指定する必要がある場面でも、コードを簡潔かつ明確に保つことができます。
