import * as c3 from 'c3'

let chart = c3.generate({
    bindto:'#chart'
    ,size: {height: 500, width: 500}
    ,data: {
        type:'donut'
        , columns:[['good',50], ['bad',50]]
    }
    ,donut: {title:'Macの使いやすさについて'}
    ,onmouseover() {
        console.log('マウスが。。。。');
    }
})