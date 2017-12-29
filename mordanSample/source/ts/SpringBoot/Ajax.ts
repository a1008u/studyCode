import jqXHR = JQuery.jqXHR

export async function executeAjax(searchWord:[string|number|string[]] ) {
    try {
        return new Promise(
            ( resolve:(result:jqXHR) => void , reject) => {
                let results:jqXHR = $.ajax({type: 'GET'
                    , url: `http://127.0.0.1:8080/svc/v1/tweets/${searchWord}`
                    , dataType: 'json'
                })

                console.log('asyncとawaitで非同期処理を実装中')
                resolve(results)

            })

    } catch (error) {
        console.error(error)
    }
}