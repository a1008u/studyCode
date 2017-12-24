async function executeAjax() {
    try {

        return new Promise(
            ( resolve:(result:Array<json>) => void , reject) => {

                let result = $.ajax({type: 'GET'
                              , url: 'https://maps.googleapis.com/maps/api/js?key=keyを設定する'
                              , dataType: 'jsonp'})

                console.log('asyncとawaitで非同期処理を実装中')
                resolve(result)

            })

    } catch (error) {
        console.error(error)
    }
}

async function exec() {

    // awaitで待つ関数は、必ずPromiseオブジェクトを生成して返す
    let map = await executeAjax().then( () => {
                let mapDiv : HTMLElement = document.getElementById( 'map' )
                return new google.maps.Map(mapDiv, { center: { lat: 35.71, lng: 139.8107}, zoom: 15})
              })

    let marker = new google.maps.Marker( {map: map
        , position: new google.maps.LatLng( 35.71, 139.8107 )
        , animation: google.maps.Animation.BOUNCE} )

}


console.log('asyncとawaitで非同期処理を実装')
exec()
console.log('asyncとawaitで非同期処理を実装完了')