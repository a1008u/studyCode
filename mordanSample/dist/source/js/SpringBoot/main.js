(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
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
function executeAjax(searchWord) {
    return __awaiter(this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            try {
                return [2, new Promise(function (resolve, reject) {
                        var results = $.ajax({ type: 'GET',
                            url: "http://127.0.0.1:8080/svc/v1/tweets/" + searchWord,
                            dataType: 'json'
                        });
                        console.log('asyncとawaitで非同期処理を実装中');
                        resolve(results);
                    })];
            }
            catch (error) {
                console.error(error);
            }
            return [2];
        });
    });
}
exports.executeAjax = executeAjax;

},{}],2:[function(require,module,exports){
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
var ajax = require("./ajax");
function exec(searchWord) {
    return __awaiter(this, void 0, void 0, function () {
        var map;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4, ajax.executeAjax(searchWord).then(function (results) {
                        console.log("twitter\u3088\u308A\u53D6\u5F97\u3057\u305Fjson:::" + results);
                        results.forEach(function (result, number) {
                            var tweetId = "tweet" + number;
                            var tweetContentsId = "tweetContents" + number;
                            var tweetUserImageId = "tweetUserImage" + number;
                            var tweetUserTextId = "tweetUserText" + number;
                            var tweetUserId = "tweetUser" + number;
                            var tweetUserDateId = "tweetUserDate" + number;
                            $('#target').append("<div id=" + tweetId + " class=\"card-panel grey lighten-5 z-depth-1\"></div>");
                            $("#" + tweetId).append("<div id=" + tweetContentsId + " class=\"row valign-wrapper\"></div>");
                            $("#" + tweetContentsId).append("<div id=" + tweetUserImageId + " class=\"col s1\"></div>")
                                .append("<div id=" + tweetUserTextId + " class=\"col s11  borderleft\"></div>");
                            $("#" + tweetUserImageId).append("<img src=" + result.profileImageUrl + " alt=\"\" class=\"circle responsive-img\">");
                            $("#" + tweetUserTextId).append("<p id=\"user\" class=\"black-text\">" + result.user + "<span id=\"userDate\" class=\"black-text\">_(" + result.createdAt + ")</span></p>")
                                .append("<p id=\"userText\" class=\"black-text\">" + result.text + "</p>");
                        });
                    })];
                case 1:
                    map = _a.sent();
                    return [2];
            }
        });
    });
}
$(function () {
    console.log('asyncとawaitで非同期処理を実装');
    exec("%23ミスチル");
    console.log('asyncとawaitで非同期処理を実装完了');
    $('input[type="search"]').change(function () {
        var text = $(this).val();
        var textComp = text.toString().replace(/#/g, "%23");
        console.log("val ::" + text);
        console.log("text ::" + textComp);
        $('#target').empty();
        exec(textComp);
    });
});

},{"./ajax":1}]},{},[2])

//# sourceMappingURL=main.js.map
