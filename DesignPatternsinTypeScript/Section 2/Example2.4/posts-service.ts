import { IPostsService } from "./iposts-service";
import { Post } from "./post";
import * as fs from 'fs'
import { IExportPostsService } from "./iexport-posts-service";

export class PostsService implements IPostsService {
    private _fileName: string = "posts.json";
    constructor() {
    }
    getAll(): Promise<Post[]> {
        return new Promise((resolve, reject) => {
            fs.readFile(this._fileName, "utf8", (err, data) => {
                if (err) {
                    reject(err);
                }
                resolve(JSON.parse(data));
            });
        });
    }
    save(post: Post): Promise<void> {
        return new Promise((resolve, reject) => {
            this.getAll().then(posts => {
                posts.push(post);
                fs.writeFile(this._fileName, posts, err => {
                    if (err) {
                        reject(err);
                    }
                    else {
                        resolve();
                    }
                });
            });
        });
    }

    export(service: IExportPostsService): Promise<string> {
        return this.getAll().then(posts => service.export(posts));
    }
}