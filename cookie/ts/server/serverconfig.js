"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var server;
(function (server) {
    server.port = 5000;
})(server = exports.server || (exports.server = {}));
var db;
(function (db) {
    db.port = 27017;
    db.host = '0.0.0.0';
    db.nodedb = 'nodedb';
})(db = exports.db || (exports.db = {}));
//# sourceMappingURL=serverconfig.js.map