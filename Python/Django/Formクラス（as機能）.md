`as_` メソッドは、Djangoフォームのレンダリング方法を制御する便利なメソッドです。これを使うことで、フォームのフィールドを異なるHTMLタグでラップして表示できます。

Djangoのフォームでは、次の3つの `as_` メソッドが提供されています。

### 1. `as_p()`
各フォームフィールドを `<p>` タグでラップしてレンダリングします。

```python
form.as_p()
```

### 2. `as_table()`
各フォームフィールドを `<tr>` タグでラップし、テーブル形式でレンダリングします。

```python
form.as_table()
```

### 3. `as_ul()`
各フォームフィールドを `<li>` タグでラップして、リスト形式でレンダリングします。

```python
form.as_ul()
```

### 使用例

以下は、`ContactForm`をビューでこれらのメソッドを使ってレンダリングする例です。

```python
from django.shortcuts import render
from .forms import ContactForm

def contact_view(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            # フォームの処理を行う
            pass
    else:
        form = ContactForm()

    # as_p()を使ってフォームを<p>タグでレンダリング
    return render(request, 'contact.html', {'form': form.as_p()})

    # as_table()を使ってフォームをテーブル形式でレンダリング
    # return render(request, 'contact.html', {'form': form.as_table()})

    # as_ul()を使ってフォームをリスト形式でレンダリング
    # return render(request, 'contact.html', {'form': form.as_ul()})
```

### テンプレートでの表示例

フォームをテンプレートでレンダリングする場合、例えば `as_p()` を使って次のように書けます。

```html
<form method="post">
    {{ form.as_p }}
    <button type="submit">Submit</button>
</form>
```

### それぞれのレンダリング形式

1. **`as_p()`**:
   ```html
   <p>
       <label for="id_name">Your name:</label>
       <input type="text" name="name" maxlength="100" required id="id_name">
   </p>
   <p>
       <label for="id_email">Your email:</label>
       <input type="email" name="email" required id="id_email">
   </p>
   ```

2. **`as_table()`**:
   ```html
   <tr>
       <th><label for="id_name">Your name:</label></th>
       <td><input type="text" name="name" maxlength="100" required id="id_name"></td>
   </tr>
   <tr>
       <th><label for="id_email">Your email:</label></th>
       <td><input type="email" name="email" required id="id_email"></td>
   </tr>
   ```

3. **`as_ul()`**:
   ```html
   <li>
       <label for="id_name">Your name:</label>
       <input type="text" name="name" maxlength="100" required id="id_name">
   </li>
   <li>
       <label for="id_email">Your email:</label>
       <input type="email" name="email" required id="id_email">
   </li>
   ```

### まとめ

- `as_p()`: フォームフィールドを段落(`<p>`)タグでラップして表示します。
- `as_table()`: フォームフィールドをテーブル行(`<tr>`)で表示します。
- `as_ul()`: フォームフィールドをリストアイテム(`<li>`)で表示します。

デフォルトのHTML構造を簡単にカスタマイズする必要がある場合に、これらのメソッドは便利です。また、HTMLの構造を自由に変更したい場合は、フォームフィールドをテンプレート内で手動でレンダリングすることもできます。
