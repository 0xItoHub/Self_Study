`OptionalInt`は、Java 8で導入された`Optional`クラスのプリミティブ型専用のバージョンの一つで、`int`型の値を持つかどうかを表すために使用されます。具体的には、`OptionalInt`は`int`型の値が存在するか、もしくは空である（値が存在しない）状態を安全に扱うためのクラスです。

`OptionalInt`を使用することで、`null`値の代わりに値の存在や欠如を表現し、`NullPointerException`のリスクを避けることができます。これは`Optional<Integer>`の代わりに使われ、プリミティブ型`int`に特化しているため、オートボクシングやアンボクシングのパフォーマンスコストも避けられます。

### `OptionalInt`の主な特徴
- **プリミティブ型`int`に特化**: `OptionalInt`は`int`型の値を安全に扱うためのラッパーであり、`Optional<Integer>`より効率的です。
- **nullの代替**: `null`を使用せずに、値が存在しない状態を表すことができ、nullチェックが不要になります。

### 主なメソッド

- **値が存在するかを確認**
  - `boolean isPresent()`: 値が存在する場合は`true`を返し、存在しない場合は`false`を返します。

- **値を取得**
  - `int getAsInt()`: 値が存在する場合はその`int`値を返します。値が存在しない場合は`NoSuchElementException`がスローされます。
  - `int orElse(int other)`: 値が存在する場合はその`int`値を返し、存在しない場合は引数で指定した`other`の値を返します。
  - `int orElseGet(IntSupplier other)`: 値が存在する場合はその`int`値を返し、存在しない場合は`IntSupplier`を使用して値を生成して返します。
  - `int orElseThrow()`: 値が存在する場合はその値を返し、存在しない場合は例外をスローします。

- **値が存在する場合のアクション**
  - `void ifPresent(IntConsumer consumer)`: 値が存在する場合、その値を`IntConsumer`に渡して処理を行います。

### 使用例

```java
import java.util.OptionalInt;

public class OptionalIntExample {
    public static void main(String[] args) {
        // 値を持つOptionalInt
        OptionalInt optionalWithValue = OptionalInt.of(5);
        
        // 値を持たないOptionalInt
        OptionalInt emptyOptional = OptionalInt.empty();
        
        // 値が存在する場合、その値を取得
        if (optionalWithValue.isPresent()) {
            System.out.println("Value: " + optionalWithValue.getAsInt());
        }
        
        // 値が存在しない場合、デフォルト値を返す
        System.out.println("Empty Optional: " + emptyOptional.orElse(10));
        
        // 値が存在する場合のみアクションを実行
        optionalWithValue.ifPresent(value -> System.out.println("Value is present: " + value));
    }
}
```

### 結果
```
Value: 5
Empty Optional: 10
Value is present: 5
```

### `OptionalInt`の主な利点
- **null回避**: `null`値を直接扱わず、`OptionalInt`で明示的に存在しない状態を管理できるため、コードの安全性が向上します。
- **効率的なプリミティブ型サポート**: `Optional<Integer>`と違い、プリミティブ型の`int`を扱うため、ボクシングやアンボクシングのコストを避けられます。

### 注意点
- `OptionalInt`は、`Optional<Integer>`の代替としてプリミティブ型`int`を効率的に扱いますが、他のプリミティブ型用のオプショナルクラス（例：`OptionalDouble`、`OptionalLong`）も存在します。それらを必要に応じて使い分けると良いです。

このように、`OptionalInt`は`int`型の値が存在するかどうかを安全に管理し、パフォーマンス面でも優れた選択肢です。
