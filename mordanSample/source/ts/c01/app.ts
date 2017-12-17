

class Sample {
    static useDom() {
        let dom = document.querySelector('#paragraph') as Element
        dom.innerHTML = 'typescriptを利用して変更'
    }

    static changeOutline(selector :JQuery){
        selector.on('mouseenter', function(){$(this).css('outline', '1px solid gold')})
                .on('mouseleave', function(){$(this).css('outline', 'none')})
    }

}

window.onload = () => { Sample.useDom() }

$(()=> {
    //<p>がマウスオーバーされたらアウトラインを付ける
    Sample.changeOutline($('p'))

    $('input[type=text]').on('focus', function(){$(this).css('background-color', 'orange')})
                         .on('blur', function(){$(this).css('background-color', 'transparent');})

    $('table').find('td').on('click', function(){
        let $this = $(this)
        $this.closest('table').find('td').css('background-color', 'transparent')
        $this.css('background-color', 'lightblue')
    })

    let checkbox : JQuery = $('input[type=checkbox]')
    checkbox.on('change', event => { let $this = $(event.currentTarget)
                                                     $this.parent().css('color', 'black')
                                                     $this.filter(':checked').parent().css('color', 'gold')
                                                   })

    $('input[type=radio]').on('change', function(){
        let $parent = $(this).parent()
        $parent.siblings().css('color', 'black')
        $parent.css('color', 'gold')
    })

    $('#unordered').find('li').on('click', event => {

        let $target = $(event.currentTarget)
        let count = 37
        let newString : stirng = `このリストを${ count + 1 }回クリックしました。`

        $target.text(newString)

    })


    /* CSS操作
    $('ul').css('background-color', 'yellowgreen');
    $('#ordered').css('background-color', 'wheat');
    $('.external').css('text-decoration', 'none');
    $('form p').css('border-bottom', '1px solid #ddd');
    $('tr:nth-child(even)').css('background-color', 'lightblue');
    $('input[type=text]').css('background-color', 'orange');
    $('h1, h2').css('color', 'steelblue');
    */
});