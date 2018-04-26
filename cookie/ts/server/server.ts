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

// select ---------------------------------------------------------------------------------------------

app.get('/listUsers',  (req, res) => {

    let nameList : {id: number, name: string }[] = [];

    headerSetting(res);
    let li = showList(res);
    li.then(client => {
        console.log('connected to db  これを起動したのかな＞＞＞＞');
        let db = client.db(config.db.nodedb);

        db.collection('user', (err, collection) => {
            let stream = collection.find().stream();
            stream.on("data", (item: { id: number, name: string }) => { nameList.push(new Item(item.id, item.name)); });
            stream.on('end', () => { res.json(nameList); })
            })
        })
        .catch(err => {
            console.log(err)
        });
});

app.get('/User/:id', (req, res) => {

    let userId = req.params.id;
    let nameList : {id: number, name: string }[] = [];
    headerSetting(res);
    let li = showList(res);
    li.then(client => {
            console.log('connected to db  これを起動したのかなid＞＞＞＞');
            let db = client.db(config.db.nodedb);

            db.collection('user', (err, collection) => {
                let stream = collection.find({ id: Number.parseInt(userId)}).stream();
                stream.on("data", (item: { id: number, name: string }) => {
                    console.log(item)
                    nameList.push(new Item(item.id, item.name));
                });
                stream.on('end', () => { res.json(nameList); })
            })
        })
        .catch(err => {
            console.log(err)
        });
});

app.get('/Users/:name', (req, res) => {
    /**
     * promise approach
     * @returns {any}
     */
    function show(userName) {
        return mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
            .then(client => {
                console.log('connected to db');
                let db = client.db(config.db.nodedb);
                let nameList : {id: number, name: string }[] = [];

                db.collection('user',(err, collection)=> {
                    let stream = collection.find(userName).stream()
                    stream.on("data",(item: { _id:string, id: number, name: string })=> {
                        console.log(item)
                        nameList.push(new Item(item.id, item.name));})
                    stream.on('end',()=>{ res.json(nameList); })
                })
            })
            .catch(err => {
                console.log(err)
            })
    }

    headerSetting(res);
    let userName = req.params.name
    let query = ({name: new RegExp(".*" + userName + ".*" , "i")})
    show(query);

});

// Insert ---------------------------------------------------------------------------------------------
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

// update ---------------------------------------------------------------------------------------------
app.put('/update/:name', (req, res) =>{

    let nameList : {id: number, name: string }[] = [];
    let userName = req.params.name
    let query = ({name: userName})

    headerSetting(res);
    let li = showList(res);

    li.then(client => {
        console.log('connected to db  これを起動したのかな＞＞＞＞');
        let db = client.db(config.db.nodedb);

        db.collection('user').updateMany({id:11},{$set: query}, () =>  {
                let stream = db.collection('user').find({ id: 11}).stream();
                stream.on("data", (item: { id: number, name: string }) => {
                    console.log(item)
                    nameList.push(new Item(item.id, item.name));
                });
                stream.on('end', () => { res.json(nameList); })
            })
        })
        .catch(err => {
            console.log(err)
        });

})
// delete ---------------------------------------------------------------------------------------------
app.delete('/delete/:id', (req, res) =>{

    let nameList : {id: number, name: string }[] = [];

    headerSetting(res);
    let li = showList(res);

    li.then(client => {
        console.log('connected to db  これを起動したのかな＞＞＞＞');
        let db = client.db(config.db.nodedb);

        db.collection('user').deleteMany({id: Number.parseInt(req.params.id)})
            .then( () => {
                let stream = db.collection('user').find().stream();
                stream.on("data", (item: { id: number, name: string }) => {
                    console.log(item)
                    nameList.push(new Item(item.id, item.name));
                });
                stream.on('end', () => { res.json(nameList); })
            })
        })
      .catch(err => {
          console.log(err)
      });
})


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