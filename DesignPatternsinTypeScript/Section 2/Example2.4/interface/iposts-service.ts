import { Post } from "../post";
import { IExportPostsService } from "./interface/iexport-posts-servicets-service";

export interface IPostsService {
    getAll(): Promise<Post[]>;
    save(post: Post): Promise<void>;
    export(service: IExportPostsService): Promise<string>;
}