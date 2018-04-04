module.exports = {
    entry: './test/index.ts',
    mode:'production',
    resolve: {
        extensions: ['.ts', '.js']
    },
    module: {
        rules: [
            {
                test: /\.ts?$/, loader: 'ts-loader'
            }
        ]
    }
};