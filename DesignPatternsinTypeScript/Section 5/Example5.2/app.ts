import { Car } from "./car";
import { resolve } from "url";

testObservers();

/**
 * 
 */
async function testObservers(): Promise<any> {
    let car = new Car(200);
    car.registerCurrentSpeedObserver(reportCurrentSpeed);
    car.registerCurrentSpeedObserver(checkSpeedLimit);

    while(car.currentSpeed < car.maxSpeed) {
        car.currentSpeed += 10;
        await sleep(1000);
    }
}

/**
 * 
 * @param newValue 
 * @param oldValue 
 */
function reportCurrentSpeed(newValue: number, oldValue: number) {
    console.log("Car running at " + newValue + " km/h");
}

/**
 * 
 * @param newValue 
 * @param oldValue 
 */
function checkSpeedLimit(newValue: number, oldValue: number) {
    const speedLimit = 100;
    if(newValue < speedLimit && newValue > (speedLimit - 30)) {
        console.log("Approaching speed limit!!（法定速度以下）");
    } else if(newValue == speedLimit) {
        console.log("Running at speed limit!!!（法定速度）");
    } else if(newValue > speedLimit) {
        console.log("You have exceeded the speed limit（違反）");
    }
}

/**
 * 
 * @param duration 
 */
async function sleep(duration: number): Promise<any> {
    return new Promise((resolve, reject) => {
        setTimeout(resolve, duration);
    });
}



