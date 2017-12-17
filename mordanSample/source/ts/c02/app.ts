/**
 * 02-01　開閉するボックス
 */
$(() => { $('.nav-info').on('click', () => {
            $('.wrapper-headerinfo').slideToggle(400)
        })
})

/**
 * 02-02　レスポンシブなナビゲーション
 */
$(() => {
    $(window).on('resize', () => {
        let listFloat = $('.nav-global').find('li').css('float')
        let state = (listFloat == 'none')? 'none' : 'block'
        $nav.css('display', state)
    })

    $('.menubtn').on('click', () => {
        $('.nav-global').slideToggle(400)
    })
})

/**
 * 02-03　コンテンツを切り替えるタブ
 */
$(() => {
    $('.tab-menu').on('click', 'li > a', event => {
        event.preventDefault()
        let $this = $(event.currentTarget)


        //ボタンのアピアランスを変更する
        $this.parent().siblings().removeClass('selected')
                      .end()
                      .addClass('selected')


        //コンテンツを切り替える
        let jqueryArray: JQuery[] = $this.closest('.tab').find('.tab-contents').children()
        jqueryArray.each(content => {
            if($(content).data('contentid') == $this.data('tabid')){
                $(content).removeClass('hidden')
            } else {
                $(content).addClass('hidden')
            }
        })
    })
})

/**
 * 02-04　簡易的なイメージギャラリー
 */
$(() => {
    function preloadImage(path :JQuery){ $('<img>').attr('src', path) }

    $('.thumbnails')
    .on('click', 'li > a', event => {
        event.preventDefault()
        let $this = $(event.currentTarget)

        //ボタンのアピアランスを変更する
        $this.parent().siblings().removeClass('selected')
                      .end()
                      .addClass('selected')

        //イメージを差し替え
        let imagePath = $this.data('img')
        $('.gallery .mainimage img').attr('src', imagePath)

    }).children('li').each( li => {

        let imgPath = $(li).children('a').data('img')
        preloadImage(imgPath)
    })
})