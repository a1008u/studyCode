
/* scssからcssを作成 */
var gulp = require('gulp')
var runSequence = require('run-sequence')
gulp.task('sass to css', function(callback) {
    return runSequence(
        "refresh"
        , "sass"
        , callback
    );
});

/** sass変換----------------------------------------  */
var sass = require('gulp-sass');
var header = require('gulp-header');
gulp.task('sass', function(){
    gulp.src('./src/sass/*.sass')
        .pipe(sass({outputStyle: 'expanded'}))
        .pipe(header('@charset "utf-8";\n\n'))
        .pipe(gulp.dest('./src/css/'));
});

/** tmpディレクトリを削除----------------------------------------  */
var del = require("del");
gulp.task("refresh", function(){
    del('./src/css');
});

/** PostCss設定----------------------------------------  */
var postcss = require('gulp-postcss')
// 様々な機能をオールインワンで実現
var cssnext = require('postcss-cssnext')
// Sassライクな変数を利用できるようにするプラグイン
var PostcssSimpleVars = require('postcss-simple-vars')
// ネストが使えるようになるプラグイン
var PostcssNested = require('postcss-nested')
// Sassライクなmixinsを利用できるようにするプラグイン
var PostcssMixins = require('postcss-mixins')
// Sassライクなimportを利用できるようにするプラグイン
var PostcssImport = require('postcss-import')

gulp.task("css", function() {

    var processors = [
        cssnext(),
        PostcssMixins(),
        PostcssSimpleVars(),
        PostcssNested(),
        PostcssImport(),
    ]

    return gulp.src('./src/postcss/style.css')
        .pipe(postcss(processors))
        .pipe(gulp.dest('./src/css'))
})


/** js(typeScript対応)----------------------------------------- */
let typescript = require('gulp-typescript');
let tsconfig = typescript.createProject("tsconfig.json");
let concat = require('gulp-concat');
let uglify = require('gulp-uglify');
let sourcemaps = require('gulp-sourcemaps');
let bundleconfig = require('./bundleconfig.json');
let merge = require('merge-stream');
let browserify = require('browserify');
let babel = require("gulp-babel");
let tsify = require('tsify');
var buffer = require('vinyl-buffer');
var source = require( 'vinyl-source-stream' );

gulp.task('altjs', function() {

    let tasks = bundleconfig.map(function (bundle) {
        let task = gulp.src( bundle.inputFiles, { base: "." })
                       .pipe(sourcemaps.init({loadMaps: true}))// ソースマップ生成機構を仕掛ける
                       .pipe(typescript(tsconfig.compilerOptions))          // tsconfigの読み込み
                       .pipe(babel())                       // babelの利用
                       .pipe(concat(bundle.outputFileName)) // concat で連結(Bundle)
                       .pipe(uglify())                      // uglify で難読&縮小化(Minify)
                       .pipe(gulp.dest("./src/js"))         // typescriptをjsへ
                       .pipe(sourcemaps.write("./"))        // ソースマップを出力
                       .pipe(gulp.dest("./src/js"))         // typescriptとjsのマッピングファイル作成
        return task;
    });

    return merge(tasks);

});


gulp.task('scripts', function(){

    let bundler = browserify({basedir: './src/ts/', debug:true}).add('app.ts').plugin('tsify', {noImplicitAny: true, declaration:true});

    return bundler.bundle()
        .on('error',console.error.bind(console))
        .pipe(source('all.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(gulp.dest('./src/js'))
        //.pipe(uglify())
        .pipe(sourcemaps.write("./"))
        .pipe(gulp.dest('./src/js'));
});


/** お掃除（ディレクトリ削除）----------------------------------------- */
let rimraf = require('rimraf')

// cssの削除
gulp.task('cleancss', function (cb) {rimraf('./src/css/*css', cb)})

// jsの削除
gulp.task('cleanjs', function (cb) {rimraf('./src/js/*js*', cb)})

// compDirの削除
gulp.task('cleancomp', function (cb) {rimraf('./src/comp', cb) })

/** ファイルの移動 -----------------------------------------　*/
let frontStorage = ['./src/html/*html','./src/css/*css','./src/js/*js*']
let rename = require("gulp-rename");
gulp.task("move to comp", function () {
    return gulp.src(frontStorage)               // 対象のファイルを指定
               //.pipe(rename("hello.md"))      // ファイル名を変更
               .pipe(gulp.dest("./src/comp"));  // 出力先を指定
});

/** comp作成用 -----------------------------------------　*/
gulp.task('make compDir', function(callback) {
    return runSequence(
        ['cleancss','cleanjs','cleancomp'],
        ['scripts', 'sass to css'],
        'move to comp',
        callback
    )
})




