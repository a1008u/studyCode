import { ISubscriptionState } from "./isubscription-state";
import { Subscription } from "./subscription";
import { TrialExpiredState } from "./trial-expired-state";

export class PaidState implements ISubscriptionState {
    amountPaid: number = 0;
    
    constructor(private _subscription: Subscription, amount: number) {
        this.amountPaid = amount;
    }
    
    pay(amount: number): void {
        throw new Error("Alread paid");
    }    
    
    checkExpiration(): void {
        this._subscription.state = new TrialExpiredState(this._subscription);
    }
    report(): string {
        return `On paid plan with ${this.amountPaid}$ subscription`;
    }


}