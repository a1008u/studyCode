export namespace  itp{

    export let hasITP = (userAgent) =>{
        let ua = userAgent.toLowerCase();
        if ((ua.indexOf('macintosh') !== -1 || ua.indexOf('iphone') !== -1 || ua.indexOf('ipad') !== -1)
             && ua.indexOf('safari') !== -1
             && ua.indexOf('version') !== -1
             && ua.indexOf('chrome') === -1
             && ua.indexOf('firefox') === -1
             && ua.indexOf('edge') === -1) {

            let iosVersion = ua.match(/os (\d{2})_/);
            if (iosVersion !== null && +iosVersion[1] >= 11) {
                return true;
            }

            let macVersion = ua.match(/mac os x 10_(\d{2})/);
            if (macVersion !== null && +macVersion[1] >= 13) {
                return true;
            }
        }

        console.log("itp対応の端末かブラウザでないです")
        return false;
    }
}
