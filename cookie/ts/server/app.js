"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var http = require("http");
var config = require("./serverconfig");
var fs = require("fs");
var Main = /** @class */ (function () {
    function Main() {
        var _this = this;
        var server = http.createServer(function (req, rep) {
            // this.htmlHandler(req, rep)
            return _this.requestHandler(req, rep);
        });
        // const server: http.Server = http.createServer(
        //     (req: http.IncomingMessage, rep: http.ServerResponse) =>
        //         this.Handler(req, rep)
        // )
        // const server: http.Server = http.createServer()
        // server.on('request',(_, response: http.ServerResponse) =>
        //     this.requestHandler(_, response))
        // サーバーを起動してリクエストを待ち受け状態にする
        server.listen(config.server.port);
        console.log('server listening.....');
    }
    /*
    * サーバーにリクエストがあった時に実行される関数
    */
    Main.prototype.requestHandler = function (request, response) {
        response.end('Hello! Node.js with TypeScript');
    };
    /**
     *
     * @param {"http".IncomingMessage} request
     * @param {"http".ServerResponse} response
     * @constructor
     */
    Main.prototype.Handler = function (request, response) {
        var msg = (request.url == '/test')
            ? 'Hello! test'
            : 'Hello! world written by typescript';
        response.end(msg);
    };
    Main.prototype.htmlHandler = function (request, response) {
        var path = __dirname + '/../../html/p/blog1.html';
        fs.readFile(path, 'utf-8', function (err, data) {
            console.log(__dirname);
            if (err) {
                response.writeHead(404, { 'Content-Type': 'text/plain' });
                response.write('not found');
                return response.end();
            }
            response.writeHead(200, { 'Content-Type': 'text/html' });
            response.write(data);
            return response.end();
        });
    };
    return Main;
}());
var main = new Main();
//# sourceMappingURL=app.js.map