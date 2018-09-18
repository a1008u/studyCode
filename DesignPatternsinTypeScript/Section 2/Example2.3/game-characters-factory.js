"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var GameCharactersFactory = /** @class */ (function () {
    function GameCharactersFactory() {
    }
    GameCharactersFactory.getWarrior = function (level) {
        var warrior;
        if (level < 10) {
            warrior = {
                strength: 18,
                dexterity: 12,
                health: 20,
                magic: 0
            };
        }
        else {
            warrior = {
                strength: 30,
                dexterity: 21,
                health: 32,
                magic: 0
            };
        }
        return warrior;
    };
    GameCharactersFactory.getMage = function (level) {
        var mage;
        if (level < 10) {
            mage = {
                strength: 0,
                dexterity: 8,
                health: 10,
                magic: 32
            };
        }
        else {
            mage = {
                strength: 2,
                dexterity: 12,
                health: 14,
                magic: 92
            };
        }
        return mage;
    };
    return GameCharactersFactory;
}());
exports.GameCharactersFactory = GameCharactersFactory;
