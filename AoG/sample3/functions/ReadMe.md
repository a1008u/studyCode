## 手順

1.nodebrewをインストール
2.nodeのインストール
3.npmのインストール
4.firebase-toolsをインストール
5.firebaseにloginをする
6.cloud fnctionのパッケージ作成
7.firebaseとactions-on-gooleの連携ライブラリの取得

```

npm install -g firebase-tools
firebase login

mkdir xxxx
cd xxxx
firebase init functions

// 状態確認
firebase use

// デプロイ
firebase deploy --only functions

npm install actions-on-google --save

```

