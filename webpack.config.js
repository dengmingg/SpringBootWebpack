/**
 * Created by coolman on 2017-10-7.
 */
var path = require('path');

module.exports = {
    entry: {
        helloWebpack: './src/main/js/ui/helloWebpack.js',
        helloVue: './src/main/js/ui/helloVue.js',
        helloReact: './src/main/js/ui/helloReact.js',
        'subfolder/sub': './src/main/js/ui/subfolder/sub.js'
    },
    resolveLoader: {
        root: path.join(__dirname, 'node_modules'),
    },
    resolve: {
        alias: {vue: 'vue/dist/vue.js'}
    },
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname + '/src/main/resources/static/ui',
        filename: '[name].js'
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};