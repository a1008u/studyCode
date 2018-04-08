module.exports = {
    // webpackがビルドを始める際の開始点となるtsファイル
    entry: {
        "server":'./ts/server/app.ts'
    },

    // bundleファイルをwebpackがどこにどのような名前で出力すればいいのかを指定
    output: {
        filename: "./js/[name]_bundle.js"
    },

    // package.jsonにprodとdevのコマンドを記載しているので「npm run test」or「npm run build」で実行できる
    // もし上記記載がない場合は、以下を記載
    // webpack4から追加(modeはproductionかdevelopmentを設定する必要がある)
    // ファイルの圧縮や、モジュールの最適化などの設定が有効になる。
    // 本番時のファイルの出力にはこちらのモードを利用する。
    // mode:'production',
    //
    // エラー表示、デバッグしやすいファイルの出力、
    // 再ビルド時間の短縮（キャッシュ有効）などの設定が有効になる。
    // 開発時のファイルの出力にはこちらのモードを利用する。
    mode:'development',

    // Webpackでビルドしたファイルのsourcemapを設定する方法(基本は本番と開発で設定を変える)
    // 開発環境：cheap-module-eval-source-map
    // 本番環境：source-map
    // devtool: 'inline-source-map',

    // ビルド対象に含めたい拡張子を設定する
    resolve: {
        extensions: ['.ts', '.js']
    },

    // ファイルの種類がなんであってもwebpackが処理できるモジュールにLoaderが変換してくれることで、
    // webpackがbundleファイルを作れるようになる。
    module: {
        rules: [
            {
                // testプロパティ：拡張子を指定して、あるLoaderがどのような種類のファイルを処理するべきなのか特定する(正規表現で拡張子を指定)
                // useプロパティ：Loaderを指定して、testプロパティに指定したファイルがアプリケーションの依存関係や最終的なbundleファイルに加えられるように変換する
                test: /\.ts?$/, use: 'ts-loader'
            }
        ]
    }
};