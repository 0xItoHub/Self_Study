はい、`--module-path`オプションと`--module`オプションを使用して、カレントディレクトリにあるJARファイルをモジュールとして実行することができます。ただし、JARファイルがモジュール化されている必要があります。具体的には、JARファイル内に`module-info.class`が存在し、そのモジュールが適切に定義されている場合に実行できます。

以下は、その手順の解説です。

### 1. JARファイルがモジュール化されている必要があります

まず、JARファイルはJava 9以降のモジュールシステムに対応している必要があります。具体的には、次のように`module-info.java`ファイルが存在し、モジュールが定義されている必要があります。

#### 例: `module-info.java`
```java
module com.example.app {
    requires java.base;  // 必要なモジュールの依存関係
    exports com.example.app;
}
```

この`module-info.java`ファイルがコンパイルされ、JARファイル内に`module-info.class`が含まれている場合、そのJARファイルをモジュールとして実行できます。

### 2. 実行コマンド

次に、JARファイルをモジュールとして実行する際のコマンドです。以下の形式を使用します。

```bash
java --module-path . --module <モジュール名>/<メインクラス>
```

ここで:
- `--module-path .`: 現在のディレクトリ（カレントディレクトリ）をモジュールパスとして指定します。このディレクトリにモジュール化されたJARファイルが存在する必要があります。
- `--module <モジュール名>/<メインクラス>`: モジュール名とメインクラスを指定してモジュールを実行します。

### 具体例

例えば、次のような構造のプロジェクトがあるとします。

```
project/
├── com.example.app.jar
```

このJARファイルがモジュール化されていて、モジュール名が`com.example.app`で、メインクラスが`com.example.app.Main`である場合、次のコマンドで実行できます。

```bash
java --module-path . --module com.example.app/com.example.app.Main
```

このコマンドは、カレントディレクトリ（`.`）にある`com.example.app.jar`をモジュールとして認識し、その中の`com.example.app.Main`クラスを実行します。

### まとめ

- `--module-path`オプションは、モジュールが格納されているディレクトリを指定するために使用します。カレントディレクトリにあるモジュール化されたJARファイルを実行する場合は、`--module-path .`を指定します。
- `--module`オプションで、モジュール名とメインクラスを指定してJARファイルを実行します。
- 実行するJARファイルがモジュール化されていることが重要です。モジュール化されていないJARファイルの場合、`--module`オプションを使って実行することはできません。

他に不明点があれば、ぜひ教えてください！
