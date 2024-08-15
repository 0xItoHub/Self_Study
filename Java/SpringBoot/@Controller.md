`@Controller` は、JavaのSpring Frameworkで使用されるアノテーションです。主にMVC（Model-View-Controller）アーキテクチャのコントローラ層を定義するために使用されます。このアノテーションは、Spring MVCアプリケーションにおいて、ユーザーリクエストを処理し、適切なビューを返すためのメソッドを含むクラスを示します。

### 基本的な役割
- **リクエストの処理**: `@Controller`でアノテートされたクラスは、クライアント（ユーザー）からのリクエストを受け取って処理します。リクエストには通常、HTTP GET、POST、PUT、DELETEなどのメソッドが含まれます。
- **ビューの選択**: 処理が完了した後に、適切なビュー（通常はHTMLやThymeleafテンプレートなど）を選択して、ユーザーに結果を返します。

### 使い方の例
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    @ResponseBody
    public String sayHello() {
        return "Hello, World!";
    }
}
```

### 詳細
1. **`@Controller`アノテーション**: このアノテーションは、SpringのDIコンテナによって認識され、Spring Beanとして管理されます。このクラスはMVCのコントローラとして動作し、リクエストを処理する役割を担います。

2. **`@GetMapping`アノテーション**: 特定のHTTP GETリクエストにマッピングするために使用されます。この場合、"/hello" にGETリクエストが来た際に `sayHello` メソッドが呼び出されます。

3. **`@ResponseBody`アノテーション**: このアノテーションは、戻り値がビューではなく、直接レスポンスのボディに書き込まれることを示します。通常、文字列やJSON形式のレスポンスを返す際に使用されます。

### `@Controller`と`@RestController`の違い
- **`@Controller`** は主にビューを返すのに使われ、テンプレートエンジンを利用してHTMLを生成します。
- **`@RestController`** は、`@Controller`に加えて、全てのメソッドがデフォルトで`@ResponseBody`として扱われるため、APIのエンドポイントを実装する際によく使用されます。

`@Controller`は、MVCアーキテクチャのコントローラとして使用される重要なアノテーションであり、リクエストの処理とレスポンスの生成を行う役割を果たします。

これに関連する技術をポートフォリオの一部として使いたい場合には、他にもいくつかのSpringアノテーションと共に使うことが一般的です。
