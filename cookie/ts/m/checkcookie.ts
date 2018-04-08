namespace cv {
    export const init = () => {

        let extracted : () => string = () => {
            let [partnerId, bannerId] = document.cookie.split('=')[1].split(',');
            return `注意：パートナーサイト[${partnerId}]の広告は[${bannerId}]を経由して購入しましたね？？？`
        }

        let txt : string = (document.cookie == "") ? "商品購入したよ。" : extracted()
        let $txt: Text = document.createTextNode(txt)
        const $p : Node = document.createElement("p");
        $p.appendChild($txt);

        document
            .getElementById('result')
            .appendChild($p);

        console.log(txt)
    }
}

cv.init()

