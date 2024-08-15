`@RequestMapping` は、Spring Frameworkで使用されるアノテーションで、主にコントローラのメソッドやクラスにリクエストをマッピングするために使われます。リクエストのURLやHTTPメソッド（GET、POSTなど）に基づいて、特定のメソッドを呼び出す役割を果たします。

### 基本的な役割
- **URLとメソッドの紐付け**: `@RequestMapping`を使用することで、特定のURLパターンに対するリクエストを、対応するコントローラのメソッドにマッピングできます。
- **HTTPメソッドの指定**: GET、POST、PUT、DELETEなど、どのHTTPメソッドでリクエストが行われたかに応じて、メソッドを実行することができます。
- **パラメータ、ヘッダーなどの条件指定**: リクエストのパラメータやヘッダーの内容に応じて、メソッドをマッピングすることも可能です。

### 使い方の例
以下のコードは、`@RequestMapping`を使った簡単なコントローラの例です。

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }
}
```

### 詳細な解説

#### 1. **`value`属性**
   - `@RequestMapping(value = "/hello")`のように、`value`属性を使用してURLパスを指定します。リクエストのURLが`/hello`の場合、このメソッドが呼び出されます。
   - 複数のURLパスを指定することもできます。

#### 2. **`method`属性**
   - `method = RequestMethod.GET` のように、HTTPメソッドを指定します。この例では、GETリクエストが送られた場合にこのメソッドが呼び出されます。
   - `POST`, `PUT`, `DELETE`などの他のHTTPメソッドを指定することも可能です。
   
   ```java
   @RequestMapping(value = "/submit", method = RequestMethod.POST)
   public String submitForm() {
       return "formSubmitted";
   }
   ```

#### 3. **`params`属性**
   - 特定のリクエストパラメータが含まれている場合にメソッドを呼び出すことができます。例えば、以下の例では、`type=admin` というパラメータがリクエストに含まれている場合のみ、このメソッドが呼び出されます。

   ```java
   @RequestMapping(value = "/admin", params = "type=admin")
   public String adminPage() {
       return "adminPage";
   }
   ```

#### 4. **`headers`属性**
   - リクエストヘッダーに基づいてメソッドをマッピングすることもできます。例えば、特定の`User-Agent`ヘッダーに基づいて、メソッドを呼び出すことができます。

   ```java
   @RequestMapping(value = "/mobile", headers = "User-Agent=Android")
   public String androidPage() {
       return "androidPage";
   }
   ```

#### 5. **`produces`属性**
   - 返されるレスポンスのメディアタイプを制限するために使用します。たとえば、次の例では、レスポンスが`application/json`の場合にのみ、このメソッドが呼び出されます。

   ```java
   @RequestMapping(value = "/json", produces = "application/json")
   @ResponseBody
   public String getJson() {
       return "{\"message\":\"Hello, JSON\"}";
   }
   ```

### クラスレベルでの`@RequestMapping`
`@RequestMapping`は、メソッドだけでなく、クラスレベルでも使用できます。クラスレベルで設定されたURLパスは、メソッドレベルの`@RequestMapping`によって補完されます。

```java
@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/users")
    @ResponseBody
    public String getUsers() {
        return "User List";
    }

    @RequestMapping("/products")
    @ResponseBody
    public String getProducts() {
        return "Product List";
    }
}
```

この例では、`/api/users`と`/api/products`のエンドポイントが作成されます。

### `@GetMapping`や`@PostMapping`との違い
Spring 4.3以降では、`@RequestMapping`の簡潔なバージョンである`@GetMapping`、`@PostMapping`、`@PutMapping`、`@DeleteMapping`などが導入されています。これらは`@RequestMapping`に比べて短く記述でき、特定のHTTPメソッド専用に設計されています。

```java
@GetMapping("/hello")
@ResponseBody
public String hello() {
    return "Hello, World!";
}
```

### まとめ
- **`@RequestMapping`は、Spring MVCにおいて、リクエストのURLとコントローラメソッドをマッピングするために使用されます。**
- **複数の属性を使用することで、URL、HTTPメソッド、パラメータ、ヘッダーなどの条件に基づいてリクエストを処理できます。**
- **Spring 4.3以降では、より簡潔な`@GetMapping`や`@PostMapping`などが使用されることが多いですが、`@RequestMapping`は依然として柔軟で強力なツールです。**
