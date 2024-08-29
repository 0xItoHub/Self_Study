`java.lang.Object` クラスは、Javaのすべてのクラスのスーパークラスです。Javaで作成されるすべてのクラスは暗黙的に `Object` クラスを継承しています。`Object` クラスには、すべてのオブジェクトが使用できる基本的なメソッドがいくつか定義されています。主なメソッドは次の通りです。

### 主なメソッド

1. **`protected Object clone()`**
   - オブジェクトのコピー（クローン）を作成するためのメソッド。クラスが `Cloneable` インターフェイスを実装している場合、このメソッドを使ってオブジェクトの複製ができます。

2. **`boolean equals(Object obj)`**
   - 2つのオブジェクトが等しいかどうかを判定するメソッド。デフォルトでは、参照（メモリアドレス）を比較しますが、サブクラスでこのメソッドをオーバーライドすることにより、論理的な等価性を判断できます。

3. **`void finalize()`**
   - ガベージコレクタがオブジェクトを回収する前に呼ばれるメソッド。通常、ガベージコレクタが不要になったオブジェクトを破棄する前に、クリーンアップ処理を行うために使用されます。

4. **`Class<?> getClass()`**
   - オブジェクトのクラス型を取得するためのメソッド。リフレクションAPIで頻繁に使用されます。

5. **`int hashCode()`**
   - オブジェクトのハッシュコードを返すメソッド。ハッシュテーブル（例：`HashMap`）のようなデータ構造でオブジェクトを正しく使用するために、`equals` メソッドと共にオーバーライドされることが一般的です。

6. **`String toString()`**
   - オブジェクトの文字列表現を返すメソッド。デフォルトではクラス名とハッシュコードを含む文字列が返されますが、通常はサブクラスでオーバーライドしてオブジェクトの状態をわかりやすく表示するために使います。

7. **`void notify()`**
   - 1つのスレッドに対して、オブジェクトのモニターを解放するよう通知します。

8. **`void notifyAll()`**
   - オブジェクトのモニターを待っているすべてのスレッドに対して、モニターを解放するよう通知します。

9. **`void wait()`**
   - 現在のスレッドを、他のスレッドがこのオブジェクトのモニターを通知するまで待機させます。

10. **`void wait(long timeout)`**
    - 一定時間だけ待機させ、その後自動的に再開します。

11. **`void wait(long timeout, int nanos)`**
    - より精密なタイミングで待機させるためのメソッドです。

### 使用例
```java
public class MyClass {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyClass myClass = (MyClass) obj;
        return someField == myClass.someField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(someField);
    }

    @Override
    public String toString() {
        return "MyClass{" + "someField=" + someField + '}';
    }
}
```

このクラスは `Object` クラスから継承されている `equals`、`hashCode`、`toString` メソッドをオーバーライドし、カスタムなオブジェクト比較や表現が可能になります。

Javaのクラス設計の基礎となる非常に重要なクラスなので、これらのメソッドの挙動や使い方はよく理解しておくと役に立ちます。
