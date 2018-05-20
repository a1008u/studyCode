## typescriptの始め方  

 - pakage.jsonの作成
    ```
    npm init;
    ```

 - typescriptの登録
    ```
    npm i typescript --save
    ```
 - その他のインストール
 
    ```$npm
    npm i webpack webpack-cli assert chai mocha mocha-webpack ts-loader typings --save-dev
    npm install @types/mocha --save-dev
    ```
 
  - test用のコマンド
     ```$npm
     mocha-webpack --webpack-config webpack.config.test.js
     ```
   - 環境変数を通す
      ```$npm 
        export PATH=$PATH:./node_modules/.bin 
      ``` 

## 実行方法
  - 開発用
     ```$npm
    npm install // npm_moduleを取得していない場合
    export PATH=$PATH:./node_modules/.bin 
    npm run build-dev // 開発環境用
    docker-compose up --build
    ``` 
  - 本番用
    ```$npm
    npm install // npm_moduleを取得していない場合
    export PATH=$PATH:./node_modules/.bin 
    npm run build-pro // 本番環境用
    docker-compose up --build　// もし動作を見たいのなら。。
    ``` 

## Test用(karma - jasmine - webpack - tsc)
- unitTest
    ```$npm
    export PATH=$PATH:./node_modules/.bin 
    npm run test
    ```    
