/**
 * 06-03　カルーセルのプラグインを作成する
 * 06-04　プリロードのプラグインを作成する
 * 06-05　プラグインを別ファイルにする
 */

/* カルーセルアニメーションを実行する関数 */
function doCarousel(btn, direction , $carousel){
    // let $btn = $(btn)
    //let $carousel = $btn.closest('.carousel')

    //移動量を計算
    let $imgContainer = $carousel.find('.thumbs')
    let move = direction * $carousel.width() + $imgContainer.position().left

    $imgContainer.filter(':not(:animated)')
                 .animate({left: move}
                           ,{duration:800
                             , progress: event => {let $this = $(event.currentTarget)
                                                   let $imgList = $this.find('.thumbs-list').first()

                                                   //移動量がthumbs-listの幅を上回ったら.thumbsのポジションをリセット
                                                   let resetPos

                                                   //[<]がクリックされたとき
                                                   if(direction == 1 && 0 <= $this.position().left){
                                                     resetPos = $this.position().left - $imgList.outerWidth()
                                                     $this.css({"left": resetPos})
                                                   }

                                                   //[>]がクリックされたとき
                                                   if(direction == -1 && $imgList.outerWidth() <= Math.abs($this.position().left)){
                                                     resetPos = $this.position().left + $imgList.outerWidth()
                                                     $this.css({"left": resetPos})
                                                   }
                                                  }
                           })
}

export class plugin{

    public carousel(taret: string) {
        let $carousel = $(taret)
        $carousel.find('.thumbs-list')
                 .each(function(){ let $this = $(this)

                                       //#carouselの幅を設定
                                       $this.parent().width($this.outerWidth() * 2)

                                       //thumbs-listをクローン
                                       $this.clone().insertAfter($this)
                                      })
                 .end()
                 .on('click', 'a.prev', event => { event.preventDefault()
                                                                          doCarousel(event.currentTarget
                                                                                     , 1
                                                                                     , $carousel)})
                 .on('click', 'a.next', event => { event.preventDefault()
                                                                          doCarousel(event.currentTarget
                                                                                     , -1
                                                                                     , $carousel)})
    }

    public preloadImage(image: string){
        let $image = $(image)
        if($image.data('imgpath')) $('<img>').attr('src', $image.data('imgpath'))
    }

}
