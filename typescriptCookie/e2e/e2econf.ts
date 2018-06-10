import { browser, Config } from 'protractor';
import { SpecReporter } from 'jasmine-spec-reporter';
import { Configuration } from 'jasmine-spec-reporter/built/configuration';

export let config: Config = {
  framework: 'jasmine',
  multiCapabilities: [
    { browserName: 'chrome' },
    // ,{ 'browserName': 'firefox', 'marionette': true, "firefox_binary": "$HOME/Applications/Firefox.app/Contents/MacOS/firefox-bin" }
  ],
  specs: ['./spec/*.js'],
  seleniumAddress: 'http://localhost:4444/wd/hub',

  // You could set no globals to true to avoid jQuery '$' and protractor '$'
  // collisions on the global namespace.
  noGlobals: true,

  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 3000,
    isVerbose: true,
  },

  onPrepare: () => {
    // clの表示を綺麗にする
    let conf: Configuration = { summary: { displayStacktrace: true } };
    let reporter = new SpecReporter(conf);
    jasmine.getEnv().addReporter(reporter);

    let jasmineReporters = require('jasmine-reporters');
    jasmine
      .getEnv()
      .addReporter(
        new jasmineReporters.JUnitXmlReporter({
          consolidateAll: true,
          savePath: './e2e/report/testresults',
          filePrefix: 'xmloutput',
        })
      );
  },
  onComplete: function() {
    let jasmineReporters = require('jasmine-reporters');
    let junitReporter = new jasmineReporters.JUnitXmlReporter({
      savePath: __dirname,
      consolidateAll: false,
    });
    jasmine.getEnv().addReporter(junitReporter);

    let browserName, browserVersion;
    let capsPromise = browser.getCapabilities();

    capsPromise.then(caps => {
      browserName = caps.get('browserName');
      browserVersion = caps.get('version');

      let testConfig = {
        reportTitle: 'Test Execution Report',
        outputPath: './e2e/report/testresults',
        screenshotPath: './screenshots',
        testBrowser: browserName,
        browserVersion: browserVersion,
        modifiedSuiteName: false,
        screenshotsOnlyOnFailure: true,
      };

      let HTMLReport = require('protractor-html-reporter');
      new HTMLReport().from(
        './e2e/report/testresults/xmloutput.xml',
        testConfig
      );
    });
  },

  getPageTimeout: 100000,
};
