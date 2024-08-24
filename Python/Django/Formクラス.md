Djangoでの`Form`クラスの実装を例に説明します。

Djangoでは、フォームを作成する際に、`forms.Form`や`forms.ModelForm`を使用します。ここでは、シンプルな`Form`クラスの例を説明します。

### シンプルなFormクラス

```python
from django import forms

class ContactForm(forms.Form):
    name = forms.CharField(label='Your name', max_length=100)
    email = forms.EmailField(label='Your email')
    message = forms.CharField(widget=forms.Textarea, label='Your message')

    def clean_name(self):
        name = self.cleaned_data.get('name')
        if not name.isalpha():
            raise forms.ValidationError("Name should only contain letters.")
        return name
```

### 各フィールドの説明

1. **`name`フィールド**: `CharField`は文字列フィールドで、`max_length`で最大の文字数を制限します。
2. **`email`フィールド**: `EmailField`は、入力が有効なメールアドレスであることを確認します。
3. **`message`フィールド**: `CharField`に`Textarea`ウィジェットを適用して、複数行のテキスト入力を可能にします。

### フォームの使用方法

このフォームはビューで以下のように使用されます。

```python
from django.shortcuts import render
from .forms import ContactForm

def contact_view(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            # フォームのデータが有効である場合の処理
            name = form.cleaned_data['name']
            email = form.cleaned_data['email']
            message = form.cleaned_data['message']
            # メールを送信したり、データベースに保存したりできます。
    else:
        form = ContactForm()

    return render(request, 'contact.html', {'form': form})
```

### `ModelForm`について

データベースモデルに直接紐づくフォームを作成する場合は、`forms.ModelForm`を使用します。これにより、モデルのフィールドに基づいたフォームを自動生成できます。

```python
from django import forms
from .models import Contact

class ContactModelForm(forms.ModelForm):
    class Meta:
        model = Contact
        fields = ['name', 'email', 'message']
```

こちらも、モデルに基づいたデータベース操作が自動で行われる便利な方法です。

フォームの使い方に関して、他に質問があればお知らせください。
