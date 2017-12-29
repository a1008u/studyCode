// gulp -----------------------------------
let gulp = require('gulp');
gulp.task('sample', function() {
    console.log('Hello Gulp!');
});

/** html -----------------------------------------　*/
let frontStorage = ['./source/*html' /*,'./src/css/*css','./src/js/*js*'*/]
gulp.task("move to dist", function () {
    return gulp.src(frontStorage)                // 対象のファイルを指定
        .pipe(gulp.dest("./dist/source/html"));  // 出力先を指定
});


/** css----------------------------------------  */
// sass変換----------------------------------------
gulp.task('sass to css', function(callback) {
    return runSequence(
        "refresh"
        , "sass"
        , callback
    );
});

let sass = require('gulp-sass');
let header = require('gulp-header');
let minifycss = require('gulp-minify-css')

let pathS1 = './source/sass/SpringBoot/Main.sass'

gulp.task('sass', function(){
    gulp.src(pathS1)
        .pipe(sourcemaps.init())
        .pipe(sass({outputStyle: 'expanded'}))
        .pipe(header('@charset "utf-8";\n\n'))
        .pipe(minifycss())
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest('./dist/source/css/'));
})

gulp.task('watch', () =>  {/*scssを監視*/
    gulp.watch('./*.sass', ['sass']);
    /*拡張子がscssのファイルに変更があれば、gulp.task('sass')を実行*/
})

/** js----------------------------------------------------  */
// production用 -----------------------------------
let browserify  = require('browserify');
let buffer = require('vinyl-buffer');
let uglify      = require('gulp-uglify');
let sourcemaps  = require('gulp-sourcemaps');
let source = require( 'vinyl-source-stream' );
let transform = require('vinyl-transform');
let tsify = require('tsify');
gulp.task('scripts', function(){

    let bundlerS1 = browserify({basedir: './source/ts/SpringBoot/', debug:true}).add('app.ts').plugin('tsify', {noImplicitAny: true, declaration:true});

    return bundlerS1.bundle()
        .on('error',console.error.bind(console))
        // .pipe(source('BackboneApp.js'))
        .pipe(source('main.js'))
        //.pipe(source('ErrorHelperTypeScript.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(uglify())
        .pipe(sourcemaps.write("./"))
        .pipe(gulp.dest('./dist/source/js'));
});


// karma用-------------------------------------------------
gulp.task('test-scripts', function(){

    let bundler = browserify({basedir: './source/test/', debug:true}).add('main.test.ts').plugin('tsify', {noImplicitAny: true, declaration:true});

    return bundler.bundle()
        .on('error',console.error.bind(console))
        .pipe(source('main.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(sourcemaps.write("./"))
        .pipe(gulp.dest('./dist/source/test/js'));
});

let karma = require("gulp-karma");
gulp.task('test-karma', function(cb) {
    gulp.src('./dist/source/*.test.js')
        .pipe(karma({
            configFile: 'karma.conf.js',
            action: 'run'
        }))
        .on('end', cb)
        .on('error', function(err) {
            // Make sure failed tests cause gulp to exit non-zero
            throw err;
        });
});

// browser-sync---------------------------------------------
let browserSync = require('browser-sync');
gulp.task('browser-sync', ['test'], function() {
    browserSync({
        server: {
            baseDir: "./dist"
        }
    });
    return gulp.watch([
        "./dist/source/js/*.js",
        "./dist/source/css/**.css",
        "./dist/test/**.test.js",
        // "./dist/data/**/**",
        "./index.html"
    ], [browserSync.reload]);
});

/** お掃除（ディレクトリ削除）----------------------------------------- */
let rimraf = require('rimraf')
gulp.task('cleandistDir', function (cb) {rimraf('./dist', cb)})

/** default --------------------------------------------------------- */
let runSequence = require('run-sequence')
gulp.task('default', function(callback) {
    return runSequence(
        // /*'lint',*/
        // ['tsc' /*,'tsc-tests'*/],
        // 'bundle-js',
        ['scripts', /*'test-scripts'*/],
        // 'test-karma',
        // 'browser-sync',
        callback
    )
})
