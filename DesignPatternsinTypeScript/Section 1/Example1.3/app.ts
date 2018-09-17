
export class ErrorHandler {
    private messageBox: any;

    constructor(messageBox, httpClient) {
        this.messageBox = messageBox;
    }

    wrapError(err, publicResponse, severity) {
        let error = {
            originalError: err,
            publicResponse, 
            severity
        }
        if(severity < 5) {
            this.handleWarning("Warning", publicResponse);
        }
        else {
            this.handleError("Critical Error", publicResponse);
        }
    }

    private handleWarning(header, content) {
        this.messageBox.show(header, content);
    }

    private handleError(header, content) {
        this.messageBox.show(header, content);
    }
}

export class ErrorLogger {
    private _endpoint: string = "api/log";
    
    constructor(private _httpClient) {

    }

    logError(errorObject): Promise<any> {
        return this._httpClient.post(this._endpoint, errorObject);
    }
}

export class ErrorHandlerWithLogging extends ErrorHandler {
    private _logger: ErrorLogger;
    
    constructor(messageBox, httpClient, logger: ErrorLogger) {
        super(messageBox, httpClient);
        this._logger = logger;
    }

    wrapError(err, publicResponse, severity) {
        return this._logger.logError(err).then(() => {
            super.wrapError(err, publicResponse, severity);
        });
    }
}