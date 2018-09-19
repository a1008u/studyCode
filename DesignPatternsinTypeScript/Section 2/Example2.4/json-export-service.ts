import { IExportPostsService } from "./interface/iexport-posts-servicets-service";
import { Post } from "./post";

export class JsonExportService implements IExportPostsService {

    /**
     * JavaScriptの値をJSON文字列に変換します。
     * @param posts
     */
    export(posts: Post[]): string {
        return JSON.stringify(posts);
    }
}