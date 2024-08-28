`javap`コマンドは、Javaクラスファイルの逆アセンブルを行うためのツールであり、クラスファイルのバイトコードを表示することができます。`-c`オプションを使用すると、クラスファイルのバイトコードを逆アセンブルして表示します。

### `javap -c`の使用方法

```bash
javap -c クラス名
```

このコマンドを実行すると、指定したクラスのメソッドごとのバイトコードが表示されます。これは、コンパイルされたJavaプログラムがどのようなバイトコードに変換されているかを確認するためのツールです。

### 例

以下に、簡単なJavaプログラムを逆アセンブルする例を示します。

```java
public class Example {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("Sum: " + c);
    }
}
```

このクラスをコンパイルして、次に`javap -c Example`コマンドを実行します。

```bash
javac Example.java
javap -c Example
```

### 出力例

以下は、`javap -c`コマンドで逆アセンブルされたバイトコードの例です。

```
Compiled from "Example.java"
public class Example {
  public Example();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: bipush        10
       2: istore_1
       3: bipush        20
       5: istore_2
       6: iload_1
       7: iload_2
       8: iadd
       9: istore_3
      10: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      13: new           #3                  // class java/lang/StringBuilder
      16: dup
      17: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      20: ldc           #5                  // String Sum: 
      22: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      25: iload_3
      26: invokevirtual #7                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      29: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      32: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      35: return
}
```

### 出力の解説

この出力は、各命令ごとにバイトコードが表示され、以下のような内容を含みます。

- **aload_0**: ローカル変数0からオブジェクトをロードします（ここでは`this`をロード）。
- **invokespecial**: コンストラクタの呼び出し（`java/lang/Object` のコンストラクタを呼び出し）。
- **bipush**: 小さな整数値をスタックにプッシュします（10や20など）。
- **iadd**: スタック上の2つの整数を加算します。
- **getstatic**: クラスの静的フィールドにアクセスします（ここでは`System.out`）。
- **invokevirtual**: インスタンスメソッドの呼び出しです（`println`など）。

### `javap -c`が有用な場面

- **デバッグ**: Javaプログラムが予期したとおりに動作しない場合、バイトコードを確認してコンパイラがどのようなコードを生成したのかを確認することができます。
- **学習目的**: Javaバイトコードの仕組みやJVMがどのように動作するかを学ぶために使われます。
- **パフォーマンス分析**: パフォーマンスに関連する問題が発生した場合、生成されたバイトコードを確認して、効率の悪い部分を特定できます。

### 結論

`javap -c`は、Javaクラスファイルを逆アセンブルして、Javaバイトコードを表示するためのツールです。これにより、Javaプログラムがコンパイル後にどのようなバイトコードに変換されているかを確認でき、プログラムの動作をより詳細に理解することができます。
