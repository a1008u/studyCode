import {plugin} from "./myplugin"

/**
 * 06-01　カルーセル
 */
$(() => {

    let p = new plugin()
    p.carousel('#carousel')
    $('img[data-imgpath]').each(event => { p.preloadImage(event)})

})


/**
 * 06-02　大きな画像を表示する
 */
/* キャプションを表示する */
let changeCaption = (caption: string) => {
    $('.gallery').find('.caption')
        .stop()
        .animate({'text-indent':-50, 'opacity':0},
            {
                duration: 400,
                complete: function() {$(this).text(caption).css({'text-indent':50})}
            })
        .animate({'text-indent':0, 'opacity':1})
}

/* 画像を切り替える */
function changeImage(path: string){
    let $image = $('<img>').attr('src', path).css('opacity', 0)
    $('.mainimage').append($image)
    $image.siblings('img').stop()
    $image.animate({opacity: 1},
        {
            duration: 1000,
            complete: () => { $(this).addClass('front').siblings('img').remove() }
        })
}

$(() => {
	$('.thumbs-list')
	.on('click', 'li', event => {
		let $targetLi = $(event.currentTarget)
		let myIndex = $targetLi.prevAll().length

		/* サムネイルのハイライト */
		$targetLi.closest('.thumbs').find('li').removeClass('selected')
		                                      .end()
			       						      .children('.thumbs-list').each(() => {
												$(this).children('li').eq(myIndex).addClass('selected')
											  })

		changeImage($targetLi.find('img').data('imgpath'))
		changeCaption($targetLi.data('caption'))
	})
})