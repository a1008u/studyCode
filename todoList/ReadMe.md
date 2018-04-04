# typescriptの利用

- 環境変数
 ```
export PATH=$PATH:./node_modules/.bin
 ```
 
- npm  
   ```npm
    npm init
   ```
    
- typescript install  
    ```npm
    npm i typescript --save
    ```
 - その他のインストール
    ```$npm
    npm i webpack webpack-cli assert chai mocha mocha-webpack ts-loader typings --save-dev
    ```
 - typings
    ```$npm
    typings install dt~mocha --global
    ```
 - mocha-webpackの実行(testの実施)
    ```$npm
    mocha-webpack --webpack-config webpack.config.test.js  
    ```
    
 - webpackの実行（productionコード生成）
    ```$npm
    webpack --config webpack.config.js
    ```
    
