# node.jsの利用

node.jsを利用して、アクセスの確認とmongoを利用

## node.jsでWebアプリケーションサーバ
 - docker-composeでmongoの起動
    ```$docker
    docker-compose up --build
    ```
    
 - tsのコンパイル（サーバとDBの起動）
    ```$npm
    npm run server
    npm run db
    ```
 
 - serverの利用
   ```$node
   node ./ts/server/app.js
   node ./ts/server/mongoapp.js
   ```
