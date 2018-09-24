import { IErrorLoggingStrategy } from "./interface/ierror-logging-strategy";
import fs from 'fs'

export class FileErrorLoggingStrategy implements IErrorLoggingStrategy {
    log(err: Error): Promise<any> {
        return new Promise((resolve, reject) => {
            fs.appendFile("logs/error.log", `${err}\n`, "utf8", (error) => {
                if(error) {
                    console.error("Error Logging failed");
                    resolve(error);
                } else {
                    resolve();
                }
            });
        });
    }
}