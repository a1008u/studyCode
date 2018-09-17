"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var QuizQuestion = /** @class */ (function () {
    function QuizQuestion(question, ans1, ans2, ans3, ans4, correctAns) {
        this._question = question;
        this._answer1 = ans1;
        this._answer2 = ans2;
        this._answer3 = ans3;
        this._answer4 = ans4;
        this._correctAnswer = correctAns;
    }
    Object.defineProperty(QuizQuestion.prototype, "question", {
        get: function () {
            return this._question;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(QuizQuestion.prototype, "answer1", {
        get: function () {
            return this._answer1;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(QuizQuestion.prototype, "answer2", {
        get: function () {
            return this._answer2;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(QuizQuestion.prototype, "answer3", {
        get: function () {
            return this._answer3;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(QuizQuestion.prototype, "answer4", {
        get: function () {
            return this._answer4;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(QuizQuestion.prototype, "correctAnswer", {
        get: function () {
            return this._correctAnswer;
        },
        enumerable: true,
        configurable: true
    });
    return QuizQuestion;
}());
exports.QuizQuestion = QuizQuestion;
var TrueFalseQuestion = /** @class */ (function (_super) {
    __extends(TrueFalseQuestion, _super);
    function TrueFalseQuestion(question) {
        return _super.call(this, question, "TRUE", "FALSE", null, null, 1) || this;
    }
    return TrueFalseQuestion;
}(QuizQuestion));
exports.TrueFalseQuestion = TrueFalseQuestion;
function formatQuestion(quizQuestion) {
    console.log(quizQuestion.question);
    console.log("1. " + quizQuestion.answer1);
    console.log("2. " + quizQuestion.answer2);
    console.log("3. " + quizQuestion.answer3);
    console.log("4. " + quizQuestion.answer4);
}
var quizQuestion = new QuizQuestion("Which framework is using TypeScript", "React", "Vue", "Angular", "Cycle", 3);
// formatQuestion(quizQuestion);
var trueFalseQuestion = new TrueFalseQuestion("TypeScript is a superset of JavaScript");
formatQuestion(trueFalseQuestion);
