import readline from 'readline';
import { resolve } from 'url';

export class ProfileConfiguration {
    protected _rl: readline.ReadLine;

    constructor() {
        this._rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
    }

    async start(): Promise<any> {
        await this.configureAccountSecurity();
        await this.configureEmailIntegration();
        await this.configureSupportMethod();
        await this.configurePaymentsMethod();
        this._rl.close();
    }

    async configureAccountSecurity(): Promise<any> {
        throw new Error("Method not implemented");
    }

    async configureEmailIntegration(): Promise<any> {
        throw new Error("Method not implemented");
    }

    async configureSupportMethod(): Promise<any> {
        throw new Error("Method not implemented");
    }

    async configurePaymentsMethod(): Promise<any> {
        throw new Error("Method not implemented");
    }
}

export class BasicPlanProfileConfiguration extends ProfileConfiguration {
    async configureAccountSecurity(): Promise<any> {
        console.log("Click here to enter a security question");
    }

    async configureEmailIntegration(): Promise<any> {
        console.log("Click here to setup email server");
    }

    async configureSupportMethod(): Promise<any> {
        console.log("Click here to create a 'Contact us' page");
    }

    async configurePaymentsMethod(): Promise<any> {
        console.log("Click here to setup Paypal");
    }
}

export class PremiumPlanProfileConfiguration extends ProfileConfiguration {
    async configureAccountSecurity(): Promise<any> {
        return new Promise((resolve, reject) => {
            this._rl.question("What security method would you like to use?\n1. Security Question\n2. Two Factor Authentication\n", answer => {
                if(parseInt(answer) == 1) {
                    console.log("Click here to enter a security question");
                }
                else if(parseInt(answer) == 2) {
                    console.log("Click here to setup two factor authentication");
                }
                resolve();
            });
        });
    }   

    async configureEmailIntegration(): Promise<any> {
        console.log("Click here to setup MailChimp");
        return Promise.resolve();
    }

    async configureSupportMethod(): Promise<any> {
        console.log("Click here to setup Intercom");
        return Promise.resolve();
    }

    async configurePaymentsMethod(): Promise<any> {
        return new Promise((resolve, reject) => {
            this._rl.question("Would you like to use\n1. Paypal\nor\n2. Stripe\nas your payment method?", answer => {
                if(parseInt(answer) == 1) {
                    console.log("Click here to configure PayPal");
                }
                else if(parseInt(answer) == 2) {
                    console.log("Click here to configure Stripe");
                }
                resolve();
            });
        });
    }
}

let basicPlanConfig = new BasicPlanProfileConfiguration();
let premiumPlanConfig = new PremiumPlanProfileConfiguration();

// basicPlanConfig.start();
premiumPlanConfig.start();