Spring Bootは、JavaのフレームワークであるSpringの上に構築されており、スタンドアロンの生産性の高いアプリケーションを簡単に作成できます。

### 1. **開発環境の準備**

#### 必要なツール
- **Java Development Kit (JDK)**: 少なくともJDK 8以上をインストールします。
- **Integrated Development Environment (IDE)**: IntelliJ IDEA、Eclipse、VS Codeなどが推奨されます。
- **Maven**または**Gradle**: ビルドツールとして使用されます。

### 2. **Spring Initializrを使用してプロジェクトを作成**

Spring Initializrは、Spring Bootプロジェクトの雛形を簡単に作成できるオンラインツールです。以下の手順で使用します。

1. **アクセス**: [Spring Initializr](https://start.spring.io/)にアクセスします。
2. **設定**:
   - **Project**: Maven ProjectまたはGradle Project
   - **Language**: Java
   - **Spring Boot Version**: 最新の安定版
   - **Project Metadata**:
     - Group: `com.example`
     - Artifact: `demo`
     - Name: `demo`
     - Package Name: `com.example.demo`
     - Packaging: `Jar`
     - Java Version: 適切なJDKバージョン（例: 11）

3. **Dependencies**:
   - 必要な依存関係を追加します。例えば、`Spring Web`, `Spring Data JPA`, `H2 Database`など。

4. **Generate**: 「Generate」ボタンをクリックし、プロジェクトのZIPファイルをダウンロードします。

5. **解凍**: ZIPファイルを解凍し、IDEで開きます。

### 3. **プロジェクト構造の確認**

プロジェクトを開くと、以下のような基本的なディレクトリ構造が見えます。

```
demo
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── demo
│   │   │               └── DemoApplication.java
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── demo
│                       └── DemoApplicationTests.java
├── mvnw
├── mvnw.cmd
├── pom.xml
└── .gitignore
```

### 4. **アプリケーションの設定**

#### `application.properties`または`application.yml`ファイル

`src/main/resources`フォルダ内の`application.properties`ファイルで、アプリケーションの設定を行います。例えば、データベース接続の設定などを行います。

```properties
# H2 Database (in-memory)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true

# JPA (Hibernate)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

### 5. **エントリーポイント**

`DemoApplication.java`ファイルがアプリケーションのエントリーポイントです。

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### 6. **コントローラーの作成**

基本的なWebコントローラーを作成します。

```java
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

### 7. **アプリケーションの実行**

IDEのRunボタンを押すか、コマンドラインで以下のコマンドを実行してアプリケーションを起動します。

```sh
./mvnw spring-boot:run
```

ブラウザで`http://localhost:8080/hello`にアクセスすると、「Hello, World!」というメッセージが表示されます。

これで、基本的なSpring Bootアプリケーションの初期設定が完了です。ここからさらに必要な機能を追加していくことができます。
