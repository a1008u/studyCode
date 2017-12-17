/**
 * 03-01　アコーディオン
 */
$(() => {
    $('.accordion').on('click', 'li', event => {
        let $this = $(event.currentTarget)
        //コンテンツを開く
        $this.toggleClass('expanded').children('.content').slideToggle('fast')
             .end()
             .siblings()
             .removeClass('expanded').children('.content').slideUp('fast')
    })
})

/**
 * 03-02　ドロップダウンメニュー
 */
function closeItems() {$this.removeClass('open').next().hide()}

$(() => {
    $('.dropdown-menu').children('a')
        .on('click', event => {
            event.preventDefault()
            event.stopPropagation()

            let $this = $(event.currentTarget)

            $this.parent().siblings('li').each(li => {
                $(li).children('a').removeClass('open').next().hide()
            })

            if($this.hasClass('open')) {
                $this.removeClass('open').next().hide()
                $('html').off('click', closeItems)

            } else {
                $this.addClass('open').next().show()
                $('html').on('click', closeItems)
            }
        })
})

/**
 * 03-03 CSSを操作するアニメーション
 */
$(() => {
    $('.first')
        .on('mouseenter', '.btn-action', event => {
            event.preventDefault()
            $(event.currentTarget).find('img').addClass('animate')
        })
        .on('mouseleave', '.btn-action', event => {
            event.preventDefault()
            $(event.currentTarget).find('img').removeClass('animate')
        })
})

/**
 * 03-04 連続アニメーション
 */
$(function(){
    $('.second')
        .on('mouseenter', '.btn-action', event => {
            event.preventDefault();
            $(this).find('img')
                .animate({'opacity':0.5}, 300)
                .animate({'opacity':1}, 500)
        })
        .on('mouseleave', '.btn-action', event => {
            event.preventDefault();
            $(this).find('img').animate({'opacity':1}, 300)
        });
});

/**
 * 03-05 animate()を使った高度なアニメーション
 */
$(() => {
    let value = 0.5

    $('.third')
        .on('mouseenter mouseleave', '.btn-action', event => {
            event.preventDefault()
            let opacityValue = (event.type == 'mouseenter') ? value : 1
            $this = $(event.currentTarget).find('img')

            $this.animate({ opacity: opacityValue }
                            ,{ duration: 500
                                       , step : (now, tween) => { let rotate = `rotate( ${(1 - now)*(360 / value)}deg)`
                                                                  $this.css({'-webkit-transform':rotate, 'transform':rotate})
                                                                }
                                       }
                           )
        })
})

/**
 * 03-06 スライドショー
 */
$(() => {
    let intervalId
    setTimer()

    function setTimer(){ intervalId = setInterval(autoClick, 5000) }

    function autoClick(){ $('.slide').children('a.next').click() }

    function changeImage($click : jQuery){
        let findSelector : string = ''
        let $new

        private let $current = $click.siblings('.container').children('.current')

        if($click.hasClass('next')){
            $new = $current.next()
            findSelector = ':first-child'
        } else {
            $new = $current.prev()
            findSelector = ':last-child'
        }

        if($new.length == 0) $new = $current.siblings(findSelector)

        $current.removeClass('current')
        $new.addClass('current')
        setTimer()
    }

    $('.slide').on('click', '> a', event => {
            event.preventDefault()
            event.stopPropagation()

            clearInterval(intervalId)
            changeImage($(event.currentTarget))
     })
})

/**
 * 03-07 Ajaxの基礎
 */
$(() => {
    $('#fetch').on('click', event => {
        event.preventDefault()
        $this = $(event.currentTarget)

        let ajaxUrl = $this.attr('href')

        if(ajaxUrl != '#'){
            $.get(ajaxUrl , data =>  {
                console.dir(data)

                let $list : jQuery = (() => {
                    let $insertImg = $('<img>').attr('src', data.img)
                    let $insertText = $('<p></p>').text(data.article)
                    return $('<li></li>').prepend($insertImg).append($insertText).css({"opacity":0})
                })()

                $('#ajax-list').append($list)
                $list.animate({'opacity':1}, 400)

                //リンク先を変更して読み込むデータファイルを変える
                if(data.next == "") {
                    $this.attr('href', '#').addClass('disabled')
                } else {
                    $this.attr('href', data.next)
                }
            })
        }

    })
})
