## 画面テストの方法（e2e）
web

## テストの方法

- 事前にdockerまたはserverを利用して、  
webページを起動させたのちに下記を行う

``` $node
export PATH=$PATH:./node_modules/.bin

webdriver-manager update
webdriver-manager start 
```

``` $node
tsc ./e2e/e2econf.ts
Protractor ./e2e/e2econf.js

npm run tsce2e
npm run teste2e
```

テストの入れ物作成（コード化予定）
``` $ shell
mkdir ./capture/
mkdir ./capture/safari
mkdir ./capture/safari/test1nesAndeu
mkdir ./capture/safari/test2nesAndneu
mkdir ./capture/safari/test3nesAndeu
mkdir ./capture/safari/test4nesAndeu
mkdir ./capture/safari/test5nesAndeu
mkdir ./capture/test1nesAndeu
mkdir ./capture/test2nesAndneu
mkdir ./capture/test3nesAndeu
mkdir ./capture/test4nesAndeu
mkdir ./capture/test5nesAndeu
```

## 参考
https://qiita.com/frost_star/items/a10555b34ec00e09d5a2



