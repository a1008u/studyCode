## spring boot https設定

今回はspring bootに自己証明書を付与する方法。  
参考：https://qiita.com/keigohtr/items/c11b74f85cc01ea5970f

コマンドを実行すると、ディレクトリ直下に証明書ができる。

```bash
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
```

設定ファイル
``` properties
server.ssl.key-store: keystore.p12
server.ssl.key-store-password: mypassword
server.ssl.keyStoreType: PKCS12
server.ssl.keyAlias: tomcat
```

