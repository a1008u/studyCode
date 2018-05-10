


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
