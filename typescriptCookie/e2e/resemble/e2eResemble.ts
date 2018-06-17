const fs = require('fs');
const resemble = require('node-resemble-js');

let safariCapTest1 : string = '/capture/safari/test1nesAndeu';
let chromeCapTest1 : string = '/capture/test1nesAndeu';
let targetArray1 : string[] = readDir(safariCapTest1);
let targetArray2 : string[] = readDir(chromeCapTest1);
checkTarget(targetArray1, targetArray2);

function checkTarget(fileArray1: string[], fileArray2: string[]) {

    fileArray1.forEach((file:string, i:number, fileArray:string[]) => {
        console.log(__dirname + safariCapTest1 + '/' + file);
        console.log(__dirname + chromeCapTest1 + '/' + fileArray2[i]);

        if (file.includes('.png')) {
            let file1 = new Buffer(fs.readFileSync(__dirname + safariCapTest1 + '/' + file));
            let file2 = new Buffer(fs.readFileSync(__dirname + chromeCapTest1 + '/' + fileArray2[i]));

            let testName = `test${i}.png`;
            resemble.outputSettings({transparency: 0.1});
            resemble(file1)
                .compareTo(file2)
                .onComplete(data => {
                    if (data.misMatchPercentage >= 0.01) {
                        data
                            .getDiffImage()
                            .pack()
                            .pipe(fs.createWriteStream('./capture/result/' + testName));
                    }
                });
        }
    })

}

function readDir(capTest :string) : any | string[]{
    let fileArray = fs.readdirSync(__dirname + capTest);
    return fileArray;
}
