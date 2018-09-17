import * as fs from 'fs';

export interface Post {
    id: number;
    title: string;
    body: string;
    postedBy: string;
}

export interface IPostsService {
    getAll(): Promise<Post[]>;
    save(post: Post): Promise<void>;
}

export class PostsService implements IPostsService {
    private _fileName: string = "posts.json";
    
    constructor() {

    }
    
    getAll(): Promise<Post[]> {
        return new Promise((resolve, reject) => {
            fs.readFile(this._fileName, "utf8", (err, data) => {
                if(err) {
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
                    if(err) {
                        reject(err);
                    }
                    else {
                        resolve();
                    }
                })
            })
        })
    }
}

export class MockPostsService implements IPostsService {
    posts: Post[] = [];
    constructor() {
        this.posts = [
            {id: 1, title: 'Test Post 1', body: 'Test Post 1', postedBy: 'Me'},
            {id: 2, title: 'Test Post 2', body: 'Test Post 2', postedBy: 'Me'},
            {id: 3, title: 'Test Post 3', body: 'Test Post 3', postedBy: 'Me'},
            {id: 4, title: 'Test Post 4', body: 'Test Post 4', postedBy: 'Me'},
        ]
    }
    
    getAll(): Promise<Post[]> {
        return Promise.resolve(this.posts);
    }
    save(post: Post): Promise<void> {
        this.posts.push(post);
        return Promise.resolve();
    }
}

export class NewsFeed {
    constructor(private _service: IPostsService) {

    }

    show() {
        this._service.getAll().then(posts => {
            posts.forEach(post => {
                console.log(`${post.title} - ${post.body}`);
            })
        });
    }
}

let newsFeed = new NewsFeed(new MockPostsService());
newsFeed.show();