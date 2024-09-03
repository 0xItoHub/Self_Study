Javadocは、Javaプログラムのソースコードに記述されたコメントをもとに、自動的にAPIドキュメントを生成するためのツールおよびコメント形式です。Javadoc形式のコメントをソースコードに記述し、Javadocツールを使ってHTML形式のドキュメントを生成することができます。これにより、コードの詳細な説明や使用方法をドキュメント化し、開発者間での共有が容易になります。

### Javadocコメントの基本

Javadocコメントは、`/** ... */`の形式で記述されます。このコメントは、クラス、メソッド、フィールドなどのプログラム要素に対してドキュメントを提供するために使われます。

#### 基本的なJavadocコメントの例

```java
/**
 * This class represents a simple example of Javadoc usage.
 */
public class ExampleClass {

    /**
     * This field holds the name of the example.
     */
    private String name;

    /**
     * Constructor for ExampleClass.
     *
     * @param name The name to be assigned to this example.
     */
    public ExampleClass(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the example.
     *
     * @return The name of the example.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the example.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
```

### Javadocコメントの構成要素

Javadocコメントには、以下の要素を含めることができます。

1. **概要説明**:
   - コメントの最初の部分で、クラスやメソッドの概要を説明します。最初の文がJavadocツールで特に重要視され、要約として使用されることが多いです。

2. **タグ（Tags）**:
   - Javadocコメントには、特定の情報を記述するための「タグ」を使用できます。タグは`@`記号で始まり、例えば`@param`や`@return`などがあります。

### 主要なJavadocタグ

- **`@param`**: メソッドの引数を説明するために使用します。引数名とその説明を指定します。

  ```java
  /**
   * Sets the name of the example.
   *
   * @param name The name to be set.
   */
  public void setName(String name) {
      this.name = name;
  }
  ```

- **`@return`**: メソッドの戻り値を説明するために使用します。

  ```java
  /**
   * Returns the name of the example.
   *
   * @return The name of the example.
   */
  public String getName() {
      return name;
  }
  ```

- **`@throws`（または`@exception`）**: メソッドがスローする可能性のある例外を説明します。

  ```java
  /**
   * Divides the dividend by the divisor.
   *
   * @param dividend The number to be divided.
   * @param divisor The number by which to divide.
   * @return The result of the division.
   * @throws ArithmeticException If the divisor is zero.
   */
  public int divide(int dividend, int divisor) throws ArithmeticException {
      if (divisor == 0) {
          throw new ArithmeticException("Division by zero");
      }
      return dividend / divisor;
  }
  ```

- **`@deprecated`**: メソッドやクラスが非推奨であることを示します。代替手段や非推奨の理由を説明します。

  ```java
  /**
   * This method is deprecated. Use {@link #newMethod()} instead.
   *
   * @deprecated Use {@link #newMethod()} instead.
   */
  @Deprecated
  public void oldMethod() {
      // ...
  }
  ```

- **`@see`**: 関連するクラスやメソッドへの参照を示します。

  ```java
  /**
   * @see ExampleClass#anotherMethod()
   */
  public void someMethod() {
      // ...
  }
  ```

### Javadocツールの使用

Javadocコメントを記述したら、`javadoc`ツールを使ってHTML形式のドキュメントを生成できます。Javadocツールは、Java開発キット（JDK）に含まれており、コマンドラインから使用できます。

#### 例：Javadocの生成

```sh
javadoc -d doc/ ExampleClass.java
```

このコマンドは、`ExampleClass.java`のJavadocコメントを基にHTMLドキュメントを生成し、`doc/`ディレクトリに保存します。

### まとめ

- **Javadoc**は、Javaのソースコードから自動的にAPIドキュメントを生成するためのツールおよびコメント形式です。
- **Javadocコメント**は、`/** ... */`の形式で記述され、クラス、メソッド、フィールドなどに関する説明を提供します。
- **Javadocタグ**を使用して、引数、戻り値、例外などの詳細情報をドキュメントに追加できます。
- **Javadocツール**を使うことで、コードに埋め込まれたコメントをHTML形式のドキュメントとして出力し、他の開発者と共有できます。

Javadocを活用することで、コードの利用者に対して明確で詳細なドキュメントを提供し、開発プロジェクトの品質と可読性を向上させることができます。
