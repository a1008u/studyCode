# dockerの利用

Dockerfileに利用イメージに設定ファイルなどを追加
docker-compose.ymlを利用して、イメージを起動させる

## 起動方法
 - docker-composeの起動
   ```$docker
   docker-comose up --build
   ```
- コンテナの停止
    ```$docker
    docker stop <<CONTAINER ID>>
    ```  
- コンテナの削除
    ```$docker
    docker rm <<CONTAINER ID>>
    ``` 
- イメージの削除
    ```$docker
    docker rmi <<CONTAINER ID>>
    ``` 
