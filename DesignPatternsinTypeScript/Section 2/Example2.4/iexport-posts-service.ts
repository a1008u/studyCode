import { Post } from "./post";

export interface IExportPostsService {
    export(post: Post[]): string;
}