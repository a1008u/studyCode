import { ISubscriptionState } from "./isubscription-state";
import { Subscription } from "./subscription";
import { PaidState } from "./paid-state";

export class TrialExpiredState implements ISubscriptionState {
    constructor(private _subscription: Subscription) {}
    
    pay(amount: number): void {
        this._subscription.state = new PaidState(this._subscription, amount);
    }    
    
    checkExpiration(): void {
        throw new Error("Trial already expired");
    }

    report(): string {
        return `Trial Expired`;
    }


}