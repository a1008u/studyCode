import { ICommand } from "./icommand";
import fs from 'fs';

export interface LogCommandParams {
    title: string;
    body: string;
    error: Error;
    filename: string;
}

export class LogCommand implements ICommand {
    private readonly _logCommandParams: LogCommandParams;

    constructor(params: LogCommandParams) {
        this._logCommandParams = params;
    }

    execute(): Promise<any> {
        return new Promise((resolve, reject) => {
            const contents = `${this._logCommandParams.title}: ${this._logCommandParams.body} - ${this._logCommandParams.error}\n`;
            fs.appendFile(this._logCommandParams.filename, contents, "utf8", err => {
                if(err) {
                    console.error("Logger failed");
                    reject(err);
                }
                else {
                    resolve();
                }
            });
        });
    }
}