var p = document.createElement("p");
if(document.cookie == ""){
	var txt = document.createTextNode("商品購入したよ。");
} else {
	var str = document.cookie.split( '=' );
	var data = str[1].split(',');
	var partnerID = data[0].split(':');
	var bannerID  = data[1].split(':');
	var txt = document.createTextNode("パートナーサイト"+partnerID[1]+"の広告"+bannerID[1]+"から商品購入したよ。");
}

p.appendChild(txt);

var test = document.getElementById('test');
test.appendChild(p);

//cookieのデータは削除する。実際のトラッキングシステムは削除しない。 この処理は要らない
//document.cookie = "accesstrade-tracking=; expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/";
