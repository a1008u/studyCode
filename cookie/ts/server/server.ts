import * as http from 'http'
import * as config from './serverconfig'
import * as express from 'express'
import * as fs from 'fs'
import * as core from "express-serve-static-core";
import * as mongodb from "mongodb";


let  app: core.Express = express();

let headerSetting = (res) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Methods:*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
}

async function showList(res) {
    return await mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`);
}

class Item {
    id:number;
    name:string;

    constructor(id:number, name:string){
        this.id = id;
        this.name = name;
    }
}

app.get('/listUsers',  (req, res) => {

    let nameList : {id: number, name: string }[] = [];

    headerSetting(res);
    let li = showList(res);
    li.then(client => {
        console.log('connected to db  これを起動したのかな＞＞＞＞');
        let db = client.db(config.db.nodedb);

        db.collection('user', (err, collection) => {
            let stream = collection.find().stream();
            stream.on("data", (item: { id: number, name: string }) => {
                nameList.push(new Item(item.id, item.name));
            });
            stream.on('end', () => { res.json(nameList); })
            })
        })
        .catch(err => {
            console.log(err)
        });
});


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

    // fs.readFile(
    //     __dirname + "/" + "users.json"
    //     , 'utf8'
    //     , (err, data) => {
    //         let name : string = req.params.name
    //         let nameList: { id: number; name: string }[] = [];
    //
    //         // 検索
    //         // for (let i of JSON.parse(data)){
    //         //     if (i.name.match(name) != null) {
    //         //         nameList.push(i);
    //         //     }
    //         // }
    //
    //         JSON.parse(data)
    //             .filter((item, index) => {
    //                 if (item.name.match(name)!= null)
    //                     nameList.push(item);
    //                 }
    //             );
    //
    //
    //
    //         res.end(JSON.stringify(nameList));
    //     }
    // );

    /**
     * promise approach
     * @returns {any}
     */
    function show() {
        return mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
            .then(client => {
                console.log('connected to db')
                let db = client.db(config.db.nodedb)

                db.collection('user',(err, collection)=> {
                    let stream = collection.find().stream()
                    stream.on("data",(item) => {console.log(item)})
                    stream.on('end',()=>{console.log('end')})
                })
            })
            .catch(err => {
                console.log(err)
            })
    }

    headerSetting(res);
    show();

});

app.put('/UserInsert', (req, res) =>{
    let insert = () => {
        return mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
            .then(client => {
                console.log('connected to db')
                let db = client.db(config.db.nodedb)

                db.collection('user',(err, collection)=>{
                    let docs = [
                        { "id": 11, "name": "Mr. Nice" },
                        { "id": 12, "name": "Narco" },
                        { "id": 13, "name": "Bombasto" },
                        { "id": 14, "name": "Celeritas" },
                        { "id": 15, "name": "Magneta" },
                        { "id": 16, "name": "RubberMan" },
                        { "id": 17, "name": "Dynama" },
                        { "id": 18, "name": "Dr IQ" },
                        { "id": 19, "name": "Magma" },
                        { "id": 20, "name": "Tornado" }
                    ];

                    collection.insertMany(docs, (err, result) => {
                        console.dir(result)
                    })
                });
            })
            .catch(err => {
                console.log(err)
                res.status(404);
                res.end();
            })
    };

    headerSetting(res);
    insert();
    res.status(200);
    res.end();
});




// server -----------------------------

let server = app.listen(8082,  () => {

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

namespace  mongo{
    export let connect = () => {
        let client = mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
        return client
    }
}