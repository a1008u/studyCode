"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var JsonExportService = /** @class */ (function () {
    function JsonExportService() {
    }
    JsonExportService.prototype.export = function (posts) {
        return JSON.stringify(posts);
    };
    return JsonExportService;
}());
exports.JsonExportService = JsonExportService;
