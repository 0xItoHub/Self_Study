`@ModelAttribute` は、Spring Framework で使用されるアノテーションで、主に以下の2つの役割を果たします。

1. **コントローラのメソッド引数としてデータをバインドする**: フォームデータなどのリクエストデータをモデルオブジェクトにバインドします。
2. **ビューにデータを追加する**: コントローラがビューをレンダリングする際に、モデルにデータを追加するために使用されます。

### 1. フォームデータのバインディング

`@ModelAttribute` を使うと、フォームやリクエストから送信されたデータを自動的にJavaオブジェクトにバインド（マッピング）できます。Spring MVCは、フォームのデータを対応するフィールドに基づいてJavaオブジェクトに変換します。

#### 基本的な使用例

例えば、フォームでユーザー情報を送信する場合、以下のようなコードになります。

```java
public class User {
    private String name;
    private int age;
    
    // ゲッターとセッター
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

```java
@Controller
public class UserController {

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        // user オブジェクトには、フォームデータがバインドされています
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        
        // 次のビューにリダイレクト
        return "userAdded";
    }
}
```

### 2. モデルにデータを追加する

`@ModelAttribute` をメソッドに付与することによって、メソッドが返すオブジェクトをモデルに自動的に追加し、ビューで利用できるようにします。このアプローチは、共通のデータを複数のビューで使用したい場合などに便利です。

#### 使用例

```java
@Controller
public class ProductController {

    @ModelAttribute("categories")
    public List<String> populateCategories() {
        // 例として、製品のカテゴリをモデルに追加
        return Arrays.asList("Electronics", "Books", "Clothing");
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        // "categories" が自動的にモデルに追加され、ビューで使用可能
        return "productList";
    }
}
```

上記の例では、`populateCategories` メソッドが実行され、その結果がモデルに "categories" という名前で自動的に追加されます。このデータは、`productList.html` のビューで使用できるようになります。

### `@ModelAttribute`の詳細

#### 1. **メソッド引数のバインディング**
- `@ModelAttribute`をコントローラメソッドの引数に付けると、Springはリクエストからフォームデータやパラメータを引数として自動的にバインドします。
- フォームデータを扱う場合、このアノテーションを使って簡単にリクエストデータをオブジェクトに変換できます。

#### 2. **ビューへのデータの追加**
- `@ModelAttribute` をメソッドに付けると、そのメソッドはコントローラがリクエストを処理する前に呼び出されます。これにより、ビューで使用するためのデータを事前にモデルに設定することができます。
- 名前を省略した場合、メソッドの戻り値の型名がデフォルトでモデルに追加されます（例: `User` 型の戻り値の場合、`user` というキーでモデルに追加されます）。

#### 3. **フォームバインディングのフロー**
`@ModelAttribute` を使用してリクエストデータをバインドする際の基本的なフローは次のとおりです。

- リクエストデータがフォームから送信されると、Spring MVC はリクエストパラメータの名前とJavaオブジェクトのフィールド名を一致させようとします。
- 一致した場合、Springはリクエストデータを対応するJavaオブジェクトのフィールドにバインドします。
- バインディングが成功すると、そのオブジェクトはコントローラメソッド内で使用可能です。

### `@ModelAttribute`の活用例

#### ユーザー情報のフォームデータを扱う例

```java
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";  // userForm.html というテンプレートが表示される
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("user") User user) {
        // フォームから送信されたデータが User オブジェクトにバインドされる
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        
        return "userDetails";  // userDetails.html というテンプレートが表示される
    }
}
```

この例では、`/user/form` にアクセスすると、`userForm.html` が表示され、そのフォームには空の `User` オブジェクトがバインドされています。フォームが送信されると、`@ModelAttribute` を使って送信されたデータが `User` オブジェクトにバインドされ、次のページでそのデータが表示されます。

### まとめ

- **`@ModelAttribute` は、Spring MVC でフォームデータをオブジェクトにバインドするためや、ビューで使用する共通データをモデルに追加するために使用されます。**
- **フォームの入力内容を自動的にオブジェクトに変換する機能や、ビューにデータを提供する機能を簡単に実装できます。**
