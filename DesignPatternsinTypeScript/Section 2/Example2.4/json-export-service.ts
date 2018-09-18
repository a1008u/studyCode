import { IExportPostsService } from "./iexport-posts-service";
import { Post } from "./post";

export class JsonExportService implements IExportPostsService {
    export(posts: Post[]): string {
        return JSON.stringify(posts);
    }
}