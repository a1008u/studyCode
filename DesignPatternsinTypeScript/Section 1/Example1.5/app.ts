export interface ISmartDevice {
    openApp(path: string): void;
    connectToWifi(ssid: string, password: string): void;
}

export interface IPhoneDevice {
    call(contact: string): void;
    sendSms(contact: string, content: string): void;
}

export class SmartPhone implements ISmartDevice, IPhoneDevice {
    call(contact: string): void {
        console.log(`Calling ${contact}`);
    }
    sendSms(contact: string, content: string): void {
        console.log(`Sending ${content} to ${contact}`);
    }
    openApp(path: string): void {
        console.log(`Opening app ${path}`);
    }
    connectToWifi(ssid: string, password: string): void {
        console.log(`Connecting to wifi ${ssid} with password ${password}`);
    }
}

export class Tablet implements ISmartDevice {
    openApp(path: string): void {
        console.log(`Opening app ${path}`);
    }
    connectToWifi(ssid: string, password: string): void {
        console.log(`Connecting to wifi ${ssid} with password ${password}`);
    }
}

let smartPhone = new SmartPhone();
smartPhone.call("John");
smartPhone.sendSms("John", "Hey, how are you?");
smartPhone.openApp("Facebook");
smartPhone.connectToWifi("MyWorkWifi", "MySuperStrongPassword");

let tablet = new Tablet();
// tablet.call("John");
// tablet.sendSms("Jake", "Hey!");