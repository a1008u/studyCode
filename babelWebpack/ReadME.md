## webpack+babelの始め方  

 - pakage.jsonの作成
    ```
    npm init;
    ```

 - インストール
    ```
    npm install --save-dev webpack webpack-cli babel-core babel-loader babel-preset-env babel-polyfill
    npm install --save-dev prettier eslint eslint-config-prettier eslint-plugin-prettier
    
    npm install --save-dev karma karma-cli karma-coverage karma-webpack karma-jasmine 
    npm install --save-dev karma-chrome-launcher  karma-edge-launcher karma-firefox-launcher karma-ie-launcher karma-safari-launcher
    npm install --save-dev karma-sourcemap-loader jasmine-core 
    npm install --save-dev karma-jasmine-html-reporter karma-mocha-reporter karma-spec-reporter karma-jasmine-html-reporter   
    ```
    
 - 環境変数を通す
   ```$npm 
     export PATH=$PATH:./node_modules/.bin 
   ``` 
 - webpackの設定
 　詳細は、webpack.config.jsを確認
 
 - eslintの適用(eslint + prettier)
   ```$npm （development用）
   npm run lint
   ``` 
 - トランスパイル(処理に必要なjsを記載していること)
   ```$npm （development用）
   npm rnn build-dev // development用
   ``` 
   ```$npm （production用）
   npm rnn build-pro // production用
   ``` 
   
 - testの実施
   ```$npm 
   npm rnn　test
   ``` 
 
## 参考サイト
https://ics.media/entry/16028
 
 
## windowsでの実行方法
  - ツールのインストール  
    スタートを押して，コマンドプロンプトを右クリックし，管理者として実行をクリック
    ```
     @"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"
    ```
  - gitのインストール(nodeバージョン管理ツール)
    ```
    choco install git
    ```
  - nodistのインストール(nodeバージョン管理ツール)
    ```
    choco install nodist
    ```
  - nodeのインストール
    ```
    nodist dist
    nodist バージョン指定
    node -v
    ```
  
