import fs = require('fs');
const resemble = require('node-resemble-js');

class e2eResemble {
  constructor() {
    console.log('初期化');
  }

  private checkTarget(
    targetNewImages: string[],
    targetOldImages: string[],
    resultResembleDir: string
  ) {
    targetNewImages.forEach(
      (targetNewImage: string, i: number, fileArray: string[]) => {
        if (targetNewImage.includes('.png')) {
          let file1 = new Buffer(
            fs.readFileSync(`${__dirname}${targetNews}${targetNewImage}`)
          );
          let file2 = new Buffer(
            fs.readFileSync(`${__dirname}${targetOlds}${targetOldImages[i]}`)
          );

          resemble.outputSettings({ transparency: 0.1 });
          resemble(file1)
            .compareTo(file2)
            .onComplete(data => {
              if (data.misMatchPercentage >= 0.01) {
                data
                  .getDiffImage()
                  .pack()
                  .pipe(
                    fs.createWriteStream(
                      `${resultResembleDir}${targetNewImage}`
                    )
                  );
              }
            });
        }
      }
    );
  }

  /**
   * ディレクトリの読み込み
   * @param {string} dirPath
   * @returns {any | string[]}
   */
  private readDir(dirPath: string): any | string[] {
    let fileArray: string[] = fs.readdirSync(__dirname + dirPath);
    if (fileArray === undefined) {
      return null;
    }

    let targetHtmlArray: string[] = fileArray.filter(item =>
      item.includes('.png')
    );

    fileArray.filter(item => !item.includes('.png')).forEach(dir => {
      let nextDir: string = `${dirPath}/${dir}`;
      if (fs.statSync(__dirname + nextDir).isDirectory()) {
        this.readDir(nextDir)
          .filter(html => html !== null)
          .forEach(html => {
            targetHtmlArray.push(`${dir}/${html}`);
          });
      }
    });

    return targetHtmlArray;
  }

  makeBaseResembleDir(target: string) {
    if (!fs.existsSync(target)) {
      fs.mkdirSync(target);
      fs.mkdirSync(target + '/pc_html');
    }
  }

  createDir(dirPath: string): void {
    let targetPath: string = __dirname + dirPath;
    let fileArray: string[] = fs.readdirSync(targetPath);
    if (fileArray === undefined) {
      return null;
    }

    fileArray.filter(item => !item.includes('.png')).forEach(dir => {
      let nextDir: string = `${dirPath}/${dir}`;
      if (fs.statSync(__dirname + nextDir).isDirectory()) {
        let tmpPath: string = __dirname + nextDir;
        let replacePath = tmpPath.replace(
          '/capture/new/',
          '/capture/resemble/'
        );
        if (!fs.existsSync(replacePath)) {
          fs.mkdirSync(replacePath);
        }
        this.createDir(nextDir);
      }
    });
  }

  check(targetNews: string, targetOlds: string, resultResembleDir: string) {
    let targetNewImages: string[] = this.readDir(targetNews);
    let targetOldImages: string[] = this.readDir(targetOlds);
    this.checkTarget(targetNewImages, targetOldImages, resultResembleDir);
  }
}

let targetNews: string = '/../../capture/new/pc_html/';
let targetOlds: string = '/../../capture/old/pc_html/';
let e2eresemble: e2eResemble = new e2eResemble();
e2eresemble.makeBaseResembleDir(__dirname + '/../../capture/resemble');
e2eresemble.createDir(targetNews);
e2eresemble.check(targetNews, targetOlds, './capture/resemble/');
