"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = y[op[0] & 2 ? "return" : op[0] ? "throw" : "next"]) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [0, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
exports.__esModule = true;
var mongodb = require("mongodb");
var config = require("./serverconfig");
var Main = /** @class */ (function () {
    function Main() {
    }
    // constructor() {
    //
    //     // mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`, (err, client) => {
    //     //     if(err) {return console.dir(err)}
    //     //     console.log('connected to db')
    //     //
    //     //     let db = client.db(config.db.nodedb)
    //     //     db.collection('user',(err, collection)=>{
    //     //         let docs = [
    //     //             {name:'taguchi', score:40},
    //     //             {name:'fkoji', score:80},
    //     //             {name:'ichigawa', score:60}
    //     //         ]
    //     //
    //     //         collection.insertMany(docs, (err,result) => {
    //     //             console.dir(result)
    //     //         })
    //     //     })
    //     // })
    //
    // }
    /**
     * promise approach
     * @returns {any}
     */
    Main.prototype.insert = function () {
        return mongodb.MongoClient.connect("mongodb://" + config.db.host + "/" + config.db.port)
            .then(function (client) {
            console.log('connected to db');
            var db = client.db(config.db.nodedb);
            db.collection('user', function (err, collection) {
                var docs = [
                    { name: 'taguchi', score: 40 },
                    { name: 'fkoji', score: 80 },
                    { name: 'ichigawa', score: 60 }
                ];
                collection.insertMany(docs, function (err, result) {
                    console.dir(result);
                });
            });
        })["catch"](function (err) {
            console.log(err);
        });
    };
    Main.prototype.show = function () {
        return mongodb.MongoClient.connect("mongodb://" + config.db.host + "/" + config.db.port)
            .then(function (client) {
            console.log('connected to db');
            var db = client.db(config.db.nodedb);
            db.collection('user', function (err, collection) {
                var stream = collection.find().stream();
                stream.on("data", function (item) { console.log(item); });
                stream.on('end', function () { console.log('end'); });
            });
            // db.collection('user',(err, collection)=>{
            //     collection.find({name:'taguchi'}).toArray((err,items)=>{
            //         console.log(items)
            //     })
            // })
        })["catch"](function (err) {
            console.log(err);
        });
    };
    Main.prototype.show2 = function () {
        return __awaiter(this, void 0, void 0, function () {
            var client, db, error_1;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4 /*yield*/, mongoConnect()];
                    case 1:
                        client = _a.sent();
                        console.log('connected to db');
                        db = client.db(config.db.nodedb);
                        db.collection('user', function (err, collection) {
                            var stream = collection.find().stream();
                            stream.on("data", function (item) { console.log(item); });
                            stream.on('end', function () { console.log('end'); });
                        });
                        return [2 /*return*/, client];
                    case 2:
                        error_1 = _a.sent();
                        console.log("Unable to connect to db");
                        return [3 /*break*/, 3];
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    return Main;
}());
function mongoConnect() {
    var client = mongodb.MongoClient.connect("mongodb://" + config.db.host + "/" + config.db.port);
    return client;
}
// async function s(url: string){
//
//     let client = await mongodb.MongoClient.connect(url)
//     return new Promise((resolve) => {
//         resolve(client)
//     })
//
// }
// let promise = new Promise((resolve, reject) => {
//     mongodb.MongoClient.connect(`mongodb://${config.db.host}/${config.db.port}`, (err, db) => {
//         if(err) reject(err);
//         resolve(db);
//     });
// });
//
// promise.then(db=> {db(config.db.nodedb).collection('user',(err, collection)=> {
//     let stream = collection.find().stream()
//     stream.on("data",(item) => {console.log(item)})
//     stream.on('end',()=>{console.log('end')})
// })})
var main = new Main();
main.show();
main.show2();
