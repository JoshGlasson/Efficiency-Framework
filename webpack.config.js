var path = require('path');

module.exports = {
    entry: {
    homePage: './src/main/js/app.js',
    sortPage: './src/main/js/graphs/sort.js',
    reversePage: './src/main/js/graphs/reverse.js',
    shufflePage: './src/main/js/graphs/shuffle.js',
    lastPage: './src/main/js/graphs/last.js',
    duplicatesPage: './src/main/js/graphs/duplicates.js',
    frequencyPage: './src/main/js/graphs/frequency.js'
    },
    devtool: 'sourcemaps',
    mode: 'development',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/[name].js'
    },
    module: {
        rules: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel-loader',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};
