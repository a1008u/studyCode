import { Config } from 'protractor';

export let config: Config = {
  framework: 'jasmine',
  multiCapabilities: [
    { browserName: 'chrome' },
    // { browserName: 'safari' },
    // tslint:disable-next-line:max-line-length
    // ,{ 'browserName': 'firefox', 'marionette': true, "firefox_binary": "$HOME/Applications/Firefox.app/Contents/MacOS/firefox-bin" }
  ],
  specs: ['../ts/*.js'],
  seleniumAddress: 'http://localhost:4444/wd/hub',

  // You could set no globals to true to avoid jQuery '$' and protractor '$'
  // collisions on the global namespace.
  noGlobals: true,

  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 100000,
    isVerbose: true,
  },

  getPageTimeout: 2000000,
};
