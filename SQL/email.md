
(問題例)
```
EMAIL
------------------------------
scott.tiger@example.co.jp
KING.LION@ORACLE.COM
……以下略……
```

email 列の@ より後ろのドメイン部分に大文字／小文字を問わず「oracle」という文字列を含んでいる行を抽出したいと思います。どの問合せを使用しますか（2 つ選択してください）。


(回答)
・select * from customers WHERE UPPER(SUBSTR(email, INSTR(email,'@')+1)) LIKE '%ORACLE%' ;
・select * from customers WHERE UPPER(SUBSTR(email, INSTR(email,'@')+1)) LIKE UPPER('%oracle%') ;

(重要）
・email 列の「@」より後ろの文字列を得るためには、「SUBSTR(email, INSTR(email,'@')+1)」を実行
・大文字／小文字を問わず「oracle」という文字列が含まれているかを判定するため、UPPERファンクションで大文字化したうえで、「LIKE '%ORACLE%'」で評価
・「LIKE UPPER('%oracle%')」は、「LIKE '%ORACLE%'」と同等

（NG例）
・select * from customers WHERE SUBSTR(email, INSTR(email,'@')+1) LIKE '%oracle%' ;
→　小文字の「oracle」という文字列しか得られない

・select * from customers WHERE INITCAP(SUBSTR(email, INSTR(email,'@')+1)) LIKE '%ORACLE%';
→　UPPERファンクションではなくINITCAPファンクションを使っている
→　INITCAPファンクションは文字列内の各単語の最初の文字を大文字
