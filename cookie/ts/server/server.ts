import * as http from 'http'
import * as config from './serverconfig'
import * as express from 'express'
import * as fs from 'fs'
import * as core from "express-serve-static-core";


let  app: core.Express = express();

let headerSetting = (res) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Methods:*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
}



app.get('/listUsers',  (req, res) => {

    headerSetting(res);
    fs.readFile(
        __dirname + "/" + "users.json"
        , 'utf8'
        , (err, data) => {
            console.log( data );
            res.end( data );
    });
})

app.get('/User/:id', (req, res) => {

    headerSetting(res);
    fs.readFile(
        __dirname + "/" + "users.json"
        , 'utf8'
        , (err, data) => {
            let id = 'user'+ req.params.id
            console.log(JSON.parse(data)[`user${req.params.id}`]);
            res.json(JSON.parse(data)[`user${req.params.id}`]);
        }
    );
})

app.get('/Users/:name', (req, res) => {

    headerSetting(res);

    fs.readFile(
        __dirname + "/" + "users.json"
        , 'utf8'
        , (err, data) => {
            let name : string = req.params.name
            let nameList: { id: number; name: string }[] = [];

            // 検索
            for (let i of JSON.parse(data)){
                if (i.name.match(name) != null) {
                    nameList.push(i);
                }
            }

            res.end(JSON.stringify(nameList));
        }
    );
});



let server = app.listen(8081,  () => {

    let host = server.address().address
    let port = server.address().port

    console.log(
        "Example app listening at http://%s:%s"
        , host
        , port)

});

interface user {
    id:number
    name:string
}