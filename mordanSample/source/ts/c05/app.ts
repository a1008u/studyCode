interface json {
    name: string,
    address: string,
    tel: string,
    solar: string,
    kids: string,
    natural: string
}

/**
 * 05-02　データからテーブルを生成する
 */
//テーブルを表示する
function renderTable(data: Array<json>){
    let $table = $('#shop')
    $table.find('tr').remove(':not(:first-child)')

    $(data).each(function(){
        let shop = this

        let $name = $('<td></td>').text(shop.name)
        let $address = $('<td></td>').text(shop.address)
        let $tel = $('<td></td>').text(shop.tel)
        let $solar = $('<td></td>').html(getImage('solar', shop.solar))
        let $kids = $('<td></td>').html(getImage('kids', shop.kids))
        let $natural = $('<td></td>').html(getImage('natural', shop.natural))

        $('<tr></tr>')
            .append($name)
            .append($address)
            .append($tel)
            .append($solar)
            .append($kids)
            .append($natural)
            .appendTo($table)
    })
}

/**
 * 05-03　データに合わせてアイコン画像を切り替える
 */
//画像を返す
let getImage = (type : string , number : string) => {
	let suffix = (parseInt(number))? 'yes': 'no'

	let fileName = type + '-' + suffix + '.png'
	let path = '../../images/' + fileName

	return $('<img>').attr('src', path)
}

/**
 * 05-04　データをフィルタする
 */
//フィルタした結果の新たなデータを作成して返す
let filterData = (data, filterName) => {

	let newData = []

	$(data).each( function () {
		let num = parseInt(this[filterName])
		if(num == 1){ newData.push(this) }
	})

	return newData
}

$(function(){

    /**
     * 05-01　JSONデータを取得する
     */
    //フィルタした結果の新たなデータを作成して返す
    $.ajax({
        type: 'GET',
        url: '../../js/c05/shopdata.json',
        dataType: 'json',
        success: json => {
            shopdata = json
            renderTable(shopdata)
            console.log(shopdata)
        },
        error:() => {
            alert('店舗データをダウンロードできませんでした。しばらく経ってからまたお試しください。')
        }
    })

    //データをフィルタする
    $('.filter-btn')
		.on('click', 'li > a', event => {
			event.preventDefault()

			let $this = $(event.currentTarget)

			//ボタンのアピアランスを変更する
			$this.parent('li').siblings().addClass('off')
									   .end()
									   .removeClass('off')

			// idからフィルタリング
			let idName = $this.parent().attr('id')
			if(idName == 'all'){
				renderTable(shopdata)
			} else {
				let newData = filterData(shopdata, idName)
				renderTable(newData)
			}
		})
})

