export let marker

export class Gmap {

    async showDefaultmap(targetLat, targeLng) {

        let defaultAjax = async () => {
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

        // awaitで待つ関数は、必ずPromiseオブジェクトを生成して返す
        let map = await defaultAjax().then( () => {
            let mapDiv : HTMLElement = document.getElementById( 'map' )
            return new google.maps.Map(mapDiv, { center: { lat: targetLat, lng: targeLng}, zoom: 15})
        })

        marker = new google.maps.Marker( {map: map
            , position: new google.maps.LatLng( targetLat, targeLng )
            , animation: google.maps.Animation.BOUNCE} )

    }

    async clearMaker() {
        // marker.setMap(null) // 削除
        marker.setVisible(false)
    }
}
