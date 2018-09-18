import { NewsFeed } from "./news-feed";

import { MockPostsService } from "./mock-posts-service";
import { JsonExportService } from "./json-export-service";

let mockService = new MockPostsService();
mockService.export(new JsonExportService()).then(result => console.log(result));

