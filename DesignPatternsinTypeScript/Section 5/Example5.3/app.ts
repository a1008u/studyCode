import { CommandWorker } from "./command-worker";
import { LogCommandParams, LogCommand } from "./log-command";

async function sleep(duration: number): Promise<any> {
    return new Promise((resolve, reject) => {
        setTimeout(resolve, duration);
    });
}

async function testCommandPattern(): Promise<any> {
    // Run the command worker every 5 seconds
    let commandWorker = new CommandWorker(5000);

    while(true) {
        try {
            await sleep(1000);
            let b: any = 100;
            b();
        }
        catch(err) {
            let params: LogCommandParams = {
                title: "Oops something went wrong",
                body: "Please try again later",
                error: err,
                filename: './logs/error.log'
            }
            commandWorker.registerCommand(new LogCommand(params));
        }
    }
}

testCommandPattern();