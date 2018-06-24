import { browser } from 'protractor';
let fs = require('fs');

namespace prepareE2e {
  export const makeNewDir = (target: string) => {
    if (!fs.existsSync(target)) {
      fs.mkdirSync(target);
    }

    if (!fs.existsSync(target + '/new/')) {
        fs.mkdirSync(target + '/new/');
    }

    if (!fs.existsSync(target + '/new/pc_html/')) {
        fs.mkdirSync(target + '/new/pc_html/');
    }
  };

  export const readDir = (dirPath: string): any | string[] => {
    let fileArray: string[] = fs.readdirSync(`${__dirname}${dirPath}`);

    if (fileArray === undefined) {
      return null;
    }

    let tmpFileArray = fileArray
      .filter(dir => dir !== 'css')
      .filter(dir => dir !== 'img')
      .filter(dir => dir !== 'js');

    let targetHtml: string[] = tmpFileArray.filter(item =>
      item.includes('.html')
    );

    // 新規のキャプチャを入れるディレクトリを作成
    tmpFileArray.filter(item => !item.includes('.html')).forEach(dir => {
      let nextDir: string = `${dirPath}/${dir}`;
      if (fs.statSync(__dirname + nextDir).isDirectory()) {
        let tmpPath: string = __dirname + nextDir;
        let replacePath = tmpPath.replace('/atss_design/', '/capture/new/');
        if (!fs.existsSync(replacePath)) {
          fs.mkdirSync(replacePath);
        }

        readDir(nextDir);
      }
    });

    // 　テスト用のディレクトリのpathを取得
    tmpFileArray.filter(item => !item.includes('.html')).forEach(dir => {
      let nextDir: string = `${dirPath}/${dir}`;
      if (fs.statSync(__dirname + nextDir).isDirectory()) {
        readDir(nextDir)
          .filter(html => html !== null)
          .forEach(html => {
            targetHtml.push(`${dir}/${html}`);
          });
      }
    });

    return targetHtml;
  };

  const writeScreenShot = (data, filename) => {
    let stream = fs.createWriteStream('./capture/new/pc_html/' + filename);
    stream.write(new Buffer(data, 'base64'));
    stream.end();
  };

  export const screeenShot = (i: number | string) => {
    browser.takeScreenshot().then(data => {
      writeScreenShot(data, `${i}.png`);
    });
  };
}

describe('takeCapture', () => {
  // if (fs.existsSync(__dirname + '/../../capture/old')) {
  //   fs.rmdirSync(__dirname + '/../../capture/old');
  // }

  fs.renameSync(
    __dirname + '/../../capture/new',
    __dirname + '/../../capture/old'
  );

  // newディレクトリの作成
  prepareE2e.makeNewDir(__dirname + '/../../capture');

  // 検索開始
  let dirPath: string = '/../../atss_design/pc_html';
  let result = prepareE2e.readDir(dirPath);

  it('atagの確認(answer1)', () => {
    let width: number = 1440;
    let height: number = 900;
    browser.driver
      .manage()
      .window()
      .setSize(width, height);

    // 非Angularのページの場合に必要
    browser.ignoreSynchronization = true;

    result.forEach(targetHtml => {
      let baseURL: string = 'https://localhost/pc_html/';
      browser.get(baseURL + targetHtml).then(targetHref => {
        prepareE2e.screeenShot(targetHtml);
      });
    });
  });
});
