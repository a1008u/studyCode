import * as ajax from './ajax'
import * as aj from './ajson'

async function exec(searchWord:[string|number|string[]]) {

    // awaitで待つ関数は、必ずPromiseオブジェクトを生成して返す
    let map = await ajax.executeAjax(searchWord).then( (results:Array<aj.ajson>) => {
        console.log(results)
        results.forEach((result, number) => {
            let tweetId:String = `tweet${number}`
            let tweetContentsId:String = `tweetContents${number}`
            let tweetUserImageId:String = `tweetUserImage${number}`
            let tweetUserTextId:String = `tweetUserText${number}`
            let tweetUserId:String = `tweetUser${number}`
            let tweetUserDateId:String = `tweetUserDate${number}`


            $('#target').append(`<div id=${tweetId} class="card-panel grey lighten-5 z-depth-1"></div>`)
            $(`#${tweetId}`).append(`<div id=${tweetContentsId} class="row valign-wrapper"></div>`)

            $(`#${tweetContentsId}`).append(`<div id=${tweetUserImageId} class="col s1"></div>`)
                .append(`<div id=${tweetUserTextId} class="col s11  borderleft"></div>`)

            $(`#${tweetUserImageId}`).append(`<img src=${result.profileImageUrl} alt="" class="circle responsive-img">`)
            $(`#${tweetUserTextId}`).append(`<p id="user" class="black-text">${result.user}<span id="userDate" class="black-text">_(${result.createdAt})</span></p>`)
                                    .append(`<p id="userText" class="black-text">${result.text}</p>`)
        })


    })

}

$(() => {

    console.log('asyncとawaitで非同期処理を実装')
    exec("%23ミスチル")
    console.log('asyncとawaitで非同期処理を実装完了')

    //テキストボックスに変更を加えたら発動
    $('input[type="search"]').change(function() {

        // 入力値の整形
        let text = $(this).val()
        let textComp = text.toString().replace(/#/g , "%23")
        console.log(`val ::${text}`)
        console.log(`text ::${textComp}`)

        // 現状を削除
        $('#target').empty()

        exec(textComp)
    })
})




