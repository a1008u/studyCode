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
    npm install
    export PATH=$PATH:./node_modules/.bin 
    npm run test
    ```   

## tslintの設定
  - tslint (tslint.jsonに設定)
    ```$npm
      export PATH=$PATH:./node_modules/.bin 
      npm run lint
    ```  
 
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
    npm install --save-dev webpack webpack-cli ts-loader typings 
    npm install --save-dev jasmin jasmine-core @types/jasmine
    
    npm install --save-dev karma karma-cli karma-coverage karma-typescript karma-webpack karma-jasmine
    npm install --save-dev karma-chrome-launcher  karma-edge-launcher karma-firefox-launcher karma-ie-launcher karma-safari-launcher
    npm install --save-dev karma-sourcemap-loader
    npm install --save-dev karma-jasmine-html-reporter karma-mocha-reporter karma-spec-reporter
    npm install --save-dev tslint prettier tslint-plugin-prettier tslint-config-prettier tslint-config-standard
    ```
 
  - test用のコマンド
     ```$npm
     npm run test
     ```
   - 環境変数を通す
      ```$npm 
        export PATH=$PATH:./node_modules/.bin 
      ``` 
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
  
