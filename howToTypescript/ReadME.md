## https対応

> 今回は、自己証明（オレオレ証明）を作成して、httpsでの利用を行う。  
> ＊本来は認証局で発行してもらったサーバ証明書を利用します。

keysディレクトリに下記ファイルを作成する。  
- server.key *秘密鍵
- server.csr *証明書署名要求(サーバ証明書を作成したら不要)
- server.crt *サーバ証明書（本来は認証局で発行してもらった証明書を利用）

```bash
mkdir keys
brew list openssl 
openssl genrsa 2048 > server.key
openssl req -new -key server.key > server.csr
openssl x509 -in server.csr -days 100 -req -signkey server.key > server.crt
```
