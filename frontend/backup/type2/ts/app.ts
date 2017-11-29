

import {UseDom} from "./usedom";
import {saveText} from "./usedom";
import {showText} from "./usedom";


let calculateBirthday = function () {
    saveText()
    showText()
}


// 実行
let formButtonk = document.getElementById("formButtonk");
formButtonk.addEventListener("click", calculateBirthday,false)
