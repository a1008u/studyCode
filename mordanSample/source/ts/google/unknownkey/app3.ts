import { Gmap } from "./GoogleMap"

async function executeAjax(type : number, check: (type: number) => string) {
        return new Promise(
            ( resolve:(result:Array<json>) => void , reject) => {

                let result = $.ajax({type: 'GET'
                    , url: 'https://maps.googleapis.com/maps/api/geocode/json'
                    , dataType: 'json'
                    , data: {
                        key: 'keyを設定する',
                        address: check(type),
                        language: 'ja'}
                    })

                console.log('asyncとawaitで非同期処理を実装中')
                console.log(result)

                resolve(result)
            })
}


let check:(type:number) => string = (type: number) => {

    switch (type) {

        case 1:
            return $('#zip').val()
            break

        case 2:
            return $('#searchWord').val()
            break
    }
}

async function exec(type , gmap:Gmap) {

    // awaitで待つ関数は、必ずPromiseオブジェクトを生成して返す
    await executeAjax(type, check).then( function(data) {

        if (data.status != "OK") throw new Error(data.status)

        let components = data.results[0].address_components
        components.map(function(element, index) {
            console.log(`【${index}】${element.types[0]}::${element.long_name}`)
        })

        let target : number = components.length

        // 住所自動入力
        if(type == 1) {
            $('#searchWord').val('')
            $('#zip').val(components[0].long_name)
        }

        if(type == 2) $('#zip').val(components[target - 1 ].long_name)

        let num =(type == 1) ? 2 : 3
        $('#state').val(components[target - num ].long_name)
        $('#city').val(components[target - (num + 1) ].long_name)
        $('#address1').val(components[target - (num + 2) ].long_name)

        let address2 = (components.length == 5) ? '' : (components.length < (num + 3)) ? '':  components[target - (num + 3)].long_name
        let address3 = (components.length == 6) ? '' : (components.length < (num + 4)) ? '': `ー${components[target - (num + 4)].long_name}`
        $('#address2').val(address2 + address3)

        // 地図の更新
        var componentsG = data.results[0].geometry
        let targetLat : number =componentsG.location.lat
        let targeLng : number =componentsG.location.lng
        gmap.showDefaultmap(targetLat, targeLng)

    }).catch(
        error => {
            console.log('errorが発生しました')
            console.log(error)}
    )

}

$(() => {

    let gmap = new Gmap()
    gmap.showDefaultmap(35.71, 139.8107)

    $('#btn').click((e) =>  {

        console.log(`郵便番号::${$('#zip').val()}`)
        console.log('asyncとawaitで非同期処理を実装')
        exec(1, gmap)
        console.log('asyncとawaitで非同期処理を実装完了')
    })

    $('#searchWordbtn').click((e) =>  {

        console.log(`検索ワード::${$('#searchWord').val()}`)
        console.log('asyncとawaitで非同期処理を実装')
        exec(2, gmap)
        console.log('asyncとawaitで非同期処理を実装完了')
    })

    // clear
    $('#btn2').click((e) =>  {
        console.log('asyncとawaitで非同期処理を実装_clear')
        gmap.clearMaker()
        console.log('asyncとawaitで非同期処理を実装完了_clear')
    })
})


































