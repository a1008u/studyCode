# typescriptの利用

ローカル端末を汚したくないので、ローカルディレクトリ内での作業だけを行うようにする。
＊グローバルに設定を行わない

## 初回の設定
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

## 初回以降の設定(別端末で利用の場合)
- 環境変数
 ```
export PATH=$PATH:./node_modules/.bin
 ```
- npm  
   ```npm
    npm install
   ```
~~typings~~
    ~~typings install dt~mocha --global~~

 - typesを利用(typingsの代わりに) ＊型はnpmで管理する
    ```$npm
    npm install --save @types/mocha
    ```

--------

## webpackの利用
 - webpack.configの設定
    本番(開発)とテスト用にconfigファイルを作成する

 - mocha-webpackの実行(testの実施)
    ```$npm
    mocha-webpack --webpack-config webpack.config.test.js 
    
    // scriptを設定しているのでこっちでいい
    npm run test
    ```
    
 - webpackの実行（productionコード生成）
    ```$npm
    webpack --config webpack.config.js
    ```
    
