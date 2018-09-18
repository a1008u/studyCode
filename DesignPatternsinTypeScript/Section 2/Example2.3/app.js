"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var game_characters_factory_1 = require("./game-characters-factory");
var warrior = game_characters_factory_1.GameCharactersFactory.getWarrior(12);
var mage = game_characters_factory_1.GameCharactersFactory.getMage(12);
console.log("Warrior at level 12: ", warrior);
console.log("Mage at level 12: ", mage);
