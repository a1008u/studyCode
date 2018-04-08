import * as mongodb from 'mongodb'
import * as config from './serverconfig'
import {MongoClient} from "mongodb";

class Main {

    /**
     * promise approach
     * @returns {any}
     */
    insert(){
        return mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
            .then(client => {
                console.log('connected to db')
                let db = client.db(config.db.nodedb)

                db.collection('user',(err, collection)=>{
                    let docs = [
                        {name:'taguchi', score:40},
                        {name:'fkoji', score:80},
                        {name:'ichigawa', score:60}
                    ]

                    collection.insertMany(docs, (err, result) => {
                        console.dir(result)
                    })
                })

            })
            .catch(err => {
                console.log(err)
            })
    }

    /**
     * promise approach
     * @returns {any}
     */
    show() {
        return mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
            .then(client => {
                console.log('connected to db')
                let db = client.db(config.db.nodedb)
                db.collection('user',(err, collection)=> {
                    let stream = collection.find().stream()
                    stream.on("data",(item) => {console.log(item)})
                    stream.on('end',()=>{console.log('end')})
                })

                // db.collection('user',(err, collection)=>{
                //     collection.find({name:'taguchi'}).toArray((err,items)=>{
                //         console.log(items)
                //     })
                // })

            })
            .catch(err => {
                console.log(err)
            })
    }

    /**
     * async await approach
     * @returns {Promise<MongoClient>}
     */
    async show2(){
        try {
            let client:MongoClient = await mongo.connect()
            console.log('connected to db')
            let db = client.db(config.db.nodedb)
            db.collection('user',(err, collection)=> {
                let stream = collection.find().stream()
                stream.on("data",(item) => {console.log(item)})
                stream.on('end',()=>{console.log('end')})
            })

            return client

        } catch (error) {
            console.log("Unable to connect to db");
        }
    }

}

namespace  mongo{
    export let connect = () => {
        let client = mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`)
        return client
    }
}


const main = new Main()
main.show()
main.show2()

