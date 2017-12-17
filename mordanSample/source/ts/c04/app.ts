/**
 * 04-01　モーダルウィンドウ
 */
//モーダルウィンドウを開く
namespace modalWindow{

	// main
    let showModal = (event) => {
        event.preventDefault()

        let $shade = $('<div></div>')
        $shade.attr('id', 'shade')
            .on('click', hideModal)

        let $modalWin = $('#modalwin')
        let $window = $(window)
        let posX = ($window.width() - $modalWin.outerWidth()) / 2
        let posY = ($window.height() - $modalWin.outerHeight()) / 2

        $modalWin.before($shade)
            .css({left: posX, top: posY})
            .removeClass('hide')
            .addClass('show')
            .on('click', 'button', () => {hideModal($shade, $modalWin)} )
            .on('click', '.modal-close', () => {hideModal($shade, $modalWin)} )
    }

    //モーダルウィンドウを閉じる
    let hideModal = ($shade : jQuery, $modalWin: jQuery) => {
        $shade.remove()
        $modalWin.removeClass('show').addClass('hide')
    }
}


$(() => {
	$('.show-modal').on('click', modalWindow.showModal)
})

/**
 * 04-02　ウィンドウ上端でグローバルナビゲーションを固定する
 * 04-03　指定した位置でサイドメニューを固定する
 */
$(() => {

	function mediaDetect(query: string) : boolean{
		return (window.matchMedia) ? window.matchMedia(query).matches : false
	}

    $(window).on('scroll', event => {
        let scrollValue = $(event.currentTarget).scrollTop()
        $('.fixedmenu').trigger('customScroll', {posY: scrollValue})
    })

    $('.fixedmenu')
        .each(function(){
            let $this = $(this)
            $this.data('initial', $this.offset().top)
        })
        .on('customScroll', (event, object) => {
            let $this = $(event.currentTarget)

            if($this.hasClass('noresponsive') && mediaDetect('(max-width:600px)')){
                //なにもしない
            } else {
                let offsetTop = ($this.data('offsettop')) ? $this.data('offsettop'): 0

                if($this.data('initial') - offsetTop <= object.posY) {

                    //要素を固定
                    if(!$this.hasClass('fixed')) {

                        let $substitute = $('<div></div>').css({'margin':'0', 'padding':'0', 'font-size':'0', 'height':'0'})
                                                          .addClass('substitute')
                                                          .height($this.outerHeight(true))
                                                          .width($this.outerWidth(true))

                        $this.after($substitute)
                             .addClass('fixed')
                             .css({top: offsetTop})
                    }
                } else {
                    //要素の固定を解除
                    $this.next('.substitute').remove()
                    $this.removeClass('fixed')
                }
            }
        })
})

/**
 * 04-04　スクロールしてページ内のリンク先まで移動する
 * 04-05　スクロールしてページトップに戻る
 */
$(() => {
	$('a.scroll-link').on('click', event => {
		event.preventDefault()
		
		let $this = $(event.currentTarget)
		let linkTo = $this.attr('href')
        let pos = (linkTo != '#top') ? $(linkTo).offset().top - $(linkTo).data('offsettop') : 0

         $('html,body').animate({scrollTop: pos}, 400)
	})
})

/**
 * 04-06　スクロール位置に合わせてリンクをハイライトする
 */
$(() => {
    $(window).on('scroll', window => {
        $('a.scroll-track').each(function(){
            let $window = $(window.currentTarget)
            let $this = $(this)

            let $target = $($this.attr('href'))
            let offset = $target.data('offsettop') || 0
            let tolerance = 1
            let topLimit = $target.offset().top - offset - tolerance
            let bottomLimit = $target.offset().top + $target.outerHeight() - offset + tolerance

            if(topLimit <= $window.scrollTop() && $window.scrollTop() <= bottomLimit){
                $this.addClass('selected')
            } else {
                $this.removeClass('selected')
            }
        })
    })
})