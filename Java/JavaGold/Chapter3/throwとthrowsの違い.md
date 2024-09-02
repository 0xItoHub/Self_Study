Javaにおいて、`throw`と`throws`は例外処理に関連していますが、それぞれ異なる用途と意味を持っています。

### `throw`
- **役割**: `throw`キーワードは、実行中に例外を「投げる」ために使用されます。特定の条件が発生したときに例外を明示的に発生させるために使われます。
- **使用例**:
  ```java
  public void checkAge(int age) {
      if (age < 18) {
          throw new IllegalArgumentException("Age must be 18 or older.");
      }
  }
  ```
  この例では、`age`が18未満の場合に`IllegalArgumentException`を投げています。

### `throws`
- **役割**: `throws`キーワードは、メソッド宣言の一部として使用され、そのメソッドがどのような例外を投げる可能性があるかを示します。`throws`を使ってメソッドがチェックされる例外を呼び出し元に伝える必要があります。
- **使用例**:
  ```java
  public void readFile(String fileName) throws IOException {
      FileReader file = new FileReader(fileName);
      // 例外を投げる可能性のある処理
  }
  ```
  この例では、`readFile`メソッドが`IOException`を投げる可能性があることを宣言しています。呼び出し元はこの例外をキャッチするか、さらに上位に投げる必要があります。

### 主な違い
- `throw`は、例外を**実際に投げる**ためのキーワードです。
- `throws`は、メソッドが**どの例外を投げる可能性があるかを宣言**するためのキーワードです。

どちらも例外処理のために重要な役割を果たしますが、その使い方と目的が異なることに注意が必要です。
