"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var StatsTracker = /** @class */ (function () {
    function StatsTracker() {
        this.buttonClicks = 0;
        this.facebookShares = 0;
        this.twitterShares = 0;
        this.widgetViews = 0;
        if (StatsTracker._instance) {
            throw new Error("Cannot initialize singleton class using new");
        }
        StatsTracker._instance = this;
    }
    Object.defineProperty(StatsTracker, "instance", {
        get: function () {
            return StatsTracker._instance;
        },
        enumerable: true,
        configurable: true
    });
    StatsTracker._instance = new StatsTracker();
    return StatsTracker;
}());
exports.StatsTracker = StatsTracker;
