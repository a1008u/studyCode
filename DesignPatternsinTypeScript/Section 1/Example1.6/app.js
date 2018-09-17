"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var fs = require("fs");
var PostsService = /** @class */ (function () {
    function PostsService() {
        this._fileName = "posts.json";
    }
    PostsService.prototype.getAll = function () {
        var _this = this;
        return new Promise(function (resolve, reject) {
            fs.readFile(_this._fileName, "utf8", function (err, data) {
                if (err) {
                    reject(err);
                }
                resolve(JSON.parse(data));
            });
        });
    };
    PostsService.prototype.save = function (post) {
        var _this = this;
        return new Promise(function (resolve, reject) {
            _this.getAll().then(function (posts) {
                posts.push(post);
                fs.writeFile(_this._fileName, posts, function (err) {
                    if (err) {
                        reject(err);
                    }
                    else {
                        resolve();
                    }
                });
            });
        });
    };
    return PostsService;
}());
exports.PostsService = PostsService;
var MockPostsService = /** @class */ (function () {
    function MockPostsService() {
        this.posts = [];
        this.posts = [
            { id: 1, title: 'Test Post 1', body: 'Test Post 1', postedBy: 'Me' },
            { id: 2, title: 'Test Post 2', body: 'Test Post 2', postedBy: 'Me' },
            { id: 3, title: 'Test Post 3', body: 'Test Post 3', postedBy: 'Me' },
            { id: 4, title: 'Test Post 4', body: 'Test Post 4', postedBy: 'Me' },
        ];
    }
    MockPostsService.prototype.getAll = function () {
        return Promise.resolve(this.posts);
    };
    MockPostsService.prototype.save = function (post) {
        this.posts.push(post);
        return Promise.resolve();
    };
    return MockPostsService;
}());
exports.MockPostsService = MockPostsService;
var NewsFeed = /** @class */ (function () {
    function NewsFeed(_service) {
        this._service = _service;
    }
    NewsFeed.prototype.show = function () {
        this._service.getAll().then(function (posts) {
            posts.forEach(function (post) {
                console.log(post.title + " - " + post.body);
            });
        });
    };
    return NewsFeed;
}());
exports.NewsFeed = NewsFeed;
var newsFeed = new NewsFeed(new MockPostsService());
newsFeed.show();
