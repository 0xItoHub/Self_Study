`static`修飾子は、Javaでクラスレベルのメンバーを定義するために使用されます。以下に主要なポイントをまとめます。

### 1. `static` メンバー
- **staticフィールド（変数）**  
  クラス全体で共有される変数。すべてのインスタンスが同じ変数を参照します。インスタンスではなくクラスに属しているため、クラス名を通じてアクセス可能です。
  
  ```java
  public class Example {
      static int count = 0;
  }
  
  // 別クラスでのアクセス
  Example.count++;
  ```

- **staticメソッド**  
  インスタンスに依存しないメソッドです。クラス名を通じて呼び出されます。staticメソッドは、インスタンス変数やインスタンスメソッドを直接参照できません。これは、staticメソッドがインスタンスが存在しない状態でも呼び出されるためです。

  ```java
  public class Example {
      static void printMessage() {
          System.out.println("This is a static method.");
      }
  }
  
  // メソッドの呼び出し
  Example.printMessage();
  ```

### 2. 静的ブロック
クラスがロードされる際に1度だけ実行されるコードブロックです。主に初期化コードを記述するために使われます。

```java
public class Example {
    static {
        System.out.println("Class loaded.");
    }
}
```

### 3. staticの注意点
- `static`メンバーはインスタンスごとに異なる状態を持たないため、インスタンスの特定の状態を保持する用途には向きません。
- インスタンス変数やインスタンスメソッドにアクセスするには、非staticなコンテキスト（インスタンスメソッドやインスタンスブロック）内から行う必要があります。

`static`修飾子は、クラス全体で共有したいメソッドや変数を定義する際に便利です。
