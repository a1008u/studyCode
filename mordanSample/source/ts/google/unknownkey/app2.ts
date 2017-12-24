async function executeAjax() {
    try {

        return new Promise(
            ( resolve:(result:Array<json>) => void , reject) => {

                let result = $.ajax({type: 'GET'
                    , url: 'https://maps.googleapis.com/maps/api/geocode/json'
                    , dataType: 'json'
                    , data: {
                        key: 'keyを設定する',
                        address: $('#zip').val(),
                        language: 'ja'}
                    })

                console.log('asyncとawaitで非同期処理を実装中')
                console.log(result)
                resolve(result)

            })

    } catch (error) {
        console.error(error)
    }
}

async function exec() {

    // awaitで待つ関数は、必ずPromiseオブジェクトを生成して返す
    await executeAjax().then( function(data) {
        if (data.status == "OK") {
            var components = data.results[0].address_components;

            if (components.length == 5) {
                $('#state').val(components[3].long_name);
                $('#city').val(components[2].long_name);
                $('#address1').val(components[1].long_name);
            } else if (components.length == 6) {
                $('#state').val(components[4].long_name);
                $('#city').val(components[3].long_name);
                $('#address1').val(components[2].long_name);
                $('#address2').val(components[1].long_name);
            }
        }
    })

}


$(() => {
    $('#btn').click((e) =>  {

        console.log(`郵便番号::${$('#zip').val()}`)
        console.log('asyncとawaitで非同期処理を実装')
        exec()
        console.log('asyncとawaitで非同期処理を実装完了')
    })
})
