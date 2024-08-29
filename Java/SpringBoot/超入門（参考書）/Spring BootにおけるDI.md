Spring BootにおけるDI（Dependency Injection、依存性注入）とは、オブジェクトの生成や依存関係の解決をフレームワークが自動的に行う仕組みのことです。DIは、アプリケーションの柔軟性やテストのしやすさを向上させるために重要な役割を果たします。

### 1. DIの基本概念

DIでは、クラスが自身で依存するオブジェクトを作成するのではなく、外部からその依存関係を提供されます。これにより、以下の利点があります：

- **疎結合:** クラス間の依存関係が明確になり、コードが疎結合（loose coupling）になります。これにより、クラスの再利用性が向上し、コードの変更が容易になります。
- **テストのしやすさ:** モックオブジェクトを使用してテストする際に、依存関係を簡単に差し替えることができます。
- **コードの簡素化:** Springが依存関係を管理するため、開発者はオブジェクトの生成や管理のコードを書く必要がなくなります。

### 2. Spring BootにおけるDIの実装

Spring Bootでは、DIは主にアノテーションを使用して実現されます。以下は、Spring BootでDIを行う際に使われる主要なアノテーションです：

- **`@Component`**: 一般的なSpringのBean（オブジェクト）を表します。Springがこのクラスを管理するようになります。
- **`@Service`**: ビジネスロジックを実装するサービスクラスを表します。`@Component`と機能的には同じですが、特定の役割を示すために使用されます。
- **`@Repository`**: データアクセス層（DAO）のクラスを表します。これも`@Component`の一種です。
- **`@Controller`**: Webレイヤーのコントローラーを表します。HTTPリクエストを処理するために使用されます。
- **`@Autowired`**: Springが依存関係を注入するために使用されます。このアノテーションを使って、必要なBeanをクラスに注入します。

### 3. DIの例

以下は、Spring BootでのDIの簡単な例です。

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository myRepository;

    // コンストラクタインジェクション
    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void performService() {
        myRepository.doSomething();
    }
}

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    public void doSomething() {
        System.out.println("Doing something in the repository.");
    }
}
```

上記の例では、`MyService`クラスが`MyRepository`に依存していますが、`MyService`自身が`MyRepository`を生成するのではなく、Springが`MyRepository`のインスタンスを注入します。

### 4. DIの方法

- **コンストラクタインジェクション:** コンストラクタを通じて依存関係を注入します。これは、推奨される方法であり、依存関係がすべて必須である場合に使用します。
- **セッターインジェクション:** セッターメソッドを通じて依存関係を注入します。オプションの依存関係や後から設定が可能な場合に適しています。
- **フィールドインジェクション:** フィールドに直接依存関係を注入します。ただし、テストのしやすさやデバッグの観点から、これはあまり推奨されません。

### まとめ

Spring BootのDIは、アプリケーションを疎結合に保ち、依存関係を自動的に管理するための強力な機能です。DIを正しく利用することで、コードの保守性やテストの効率が向上します。
