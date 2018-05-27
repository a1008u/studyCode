module.exports = function(config) {
    config.set({
        basePath: '',
        frameworks: ['jasmine'],
        files: [
            "src/js/*.js",
            "test/*.js"
        ],
        exclude: [],
        preprocessors: {
            'src/js/*.js': ['webpack','coverage']
            , 'test/*.js': ['webpack']
        },
        webpack: {
            mode: 'development'
            ,devtool: 'inline-source-map'
            ,module: {
                rules: [
                    { test: /\.js/, exclude: /node_modules/,  loader: 'babel-loader'}
                ]
            },
            watch: true
        },
        reporters: ['mocha','coverage','kjhtml','spec'],
        port: 9876,
        colors: true,
        logLevel: config.LOG_INFO,
        autoWatch: true,
        browsers: ['Chrome','Firefox','Safari'],
        singleRun: false,
        concurrency: Infinity
    })
}
