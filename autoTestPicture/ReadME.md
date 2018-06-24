```$node
    npm install --save-dev typescript
    npm install --save-dev webpack webpack-cli ts-loader
    npm install --save-dev jasmin jasmine-core @types/jasmine
    npm install --save-dev tslint prettier tslint-plugin-prettier tslint-config-prettier tslint-config-standard
    npm install --save-dev store @types/store
    npm install --save-dev node-resemble-js fs geckodriver iedriver protractor protractor-html-reporter
    npm install --save-dev nightwatch @types/nightwatch
```

```$node
    export PATH=$PATH:./node_modules/.bin
    webdriver-manager update
    webdriver-manager start 
    
    npm run build
    npm run test-e2e
    npm run test-resemble
    
    npm run lint
```
