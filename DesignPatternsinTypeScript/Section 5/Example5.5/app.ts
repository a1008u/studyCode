import { Subscription } from "./subscription";

let subscription: Subscription = new Subscription();
subscription.checkSubscriptionStatus();
subscription.dayPassed();
subscription.checkSubscriptionStatus();
for(let i=0; i<13; i++) {
    subscription.dayPassed();
    subscription.checkSubscriptionStatus();
}
subscription.pay(200);
subscription.checkSubscriptionStatus();