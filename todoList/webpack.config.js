module.exports = {
    entry: './src/index.ts',
    output: {
        filename: './dist/bundle.js'
    },
    mode:'production',
    // mode:'development',
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