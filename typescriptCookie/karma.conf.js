// Karma configuration
// Generated on Sun May 20 2018 13:25:54 GMT+0900 (JST)
module.exports = function(config) {
    config.set({
        mime: {
            'text/x-typescript': ['ts','tsx']
        },

        // base path that will be used to resolve all patterns (eg. files, exclude)
        basePath: '',

        // frameworks to use
        // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
        frameworks: ['jasmine', 'karma-typescript'],

        // list of files / patterns to load in the browser
        files: [
            'src/ts/lpcompletion.ts'
            , 'test/ts/lpcompletion_test.ts'
            , 'src/ts/service/*.ts'
            , 'test/ts/service/*.ts'
        ],

        // list of files / patterns to exclude
        exclude: [
        ],

        // preprocess matching files before serving them to the browser
        // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
        preprocessors: {
            'src/ts/lpcompletion.ts': ['webpack',"karma-typescript",'coverage']
            , 'test/ts/lpcompletion_test.ts': ['webpack',"karma-typescript"]
            , 'src/ts/service/*.ts': ['webpack',"karma-typescript",'coverage']
            ,'test/ts/service/*.ts': ['webpack',"karma-typescript"]
        },

        webpack: {
            resolve: {
                extensions: ['.ts', '.js']
            },
            module: {
                rules: [
                    {test: /\.ts$/, use: [{loader: 'ts-loader'}]}
                ]
            }
        },

        // test results reporter to use
        // possible values: 'dots', 'progress'
        // available reporters: https://npmjs.org/browse/keyword/karma-reporter
        // テスト結果
        reporters: ['mocha','coverage','spec', 'kjhtml', "karma-typescript"],

        // web server port
        port: 9876,


        // enable / disable colors in the output (reporters and logs)
        colors: true,


        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_DEBUG,


        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: true,


        // start these browsers(自分の環境に合わせてbrowserを設定する)
        // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
        // browsers: ['Chrome','Firefox','Safari','IE','Edge'],
        browsers: ['Chrome','Firefox','Safari'],


        // Continuous Integration mode
        // if true, Karma captures browsers, runs the tests and exits
        singleRun: false,

        // Concurrency level
        // how many browser should be started simultaneous
        concurrency: Infinity
    })
};
