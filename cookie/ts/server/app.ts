import * as http from 'http'
import * as config from './serverconfig'
import * as fs from 'fs'

class Main {
    constructor() {

        const server: http.Server = http.createServer(
            (req: http.IncomingMessage, rep: http.ServerResponse) =>
                // this.htmlHandler(req, rep)
                this.requestHandler(req, rep)
        )

        // const server: http.Server = http.createServer(
        //     (req: http.IncomingMessage, rep: http.ServerResponse) =>
        //         this.Handler(req, rep)
        // )

        // const server: http.Server = http.createServer()
        // server.on('request',(_, response: http.ServerResponse) =>
        //     this.requestHandler(_, response))

        // サーバーを起動してリクエストを待ち受け状態にする
        server.listen(config.server.port)
        console.log('server listening.....')

    }

    /*
    * サーバーにリクエストがあった時に実行される関数
    */
    private requestHandler(request: http.IncomingMessage,
                           response: http.ServerResponse): void {
        response.end('Hello! Node.js with TypeScript');
    }

    /**
     *
     * @param {"http".IncomingMessage} request
     * @param {"http".ServerResponse} response
     * @constructor
     */
    private Handler(request: http.IncomingMessage,
                    response: http.ServerResponse): void {

        let msg : string = (request.url == '/test')
            ? 'Hello! test'
            : 'Hello! world written by typescript'

        response.end(msg)
    }

    private htmlHandler(request: http.IncomingMessage,
                    response: http.ServerResponse): void {

        let path : string = __dirname + '/../../html/p/blog1.html'
        fs.readFile(path ,'utf-8',(err, data) => {

            console.log(__dirname)
            if (err) {
                response.writeHead(404,{'Content-Type': 'text/plain'})
                response.write('not found')
                return response.end()
            }

            response.writeHead(200,{'Content-Type':'text/html'})
            response.write(data)
            return response.end()

        })

    }
}

const main = new Main();