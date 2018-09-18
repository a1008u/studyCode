"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var mock_posts_service_1 = require("./mock-posts-service");
var json_export_service_1 = require("./json-export-service");
var mockService = new mock_posts_service_1.MockPostsService();
mockService.export(new json_export_service_1.JsonExportService()).then(function (result) { return console.log(result); });
