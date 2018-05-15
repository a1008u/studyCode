function test(){
    fetch('https://jsonplaceholder.typicode.com/posts/1')
        .then(function (response) {
            response.json()
        })
        .then(function (json) {
            console.log(json)
            var div = document.createElement('div');
            div.textContent = 'hoge';
            document.getElementById('idd').appendChild(div);
        })
}

// document.getElementById('idd')
document.addEventListener('DOMContentLoaded',  (kes)  => {

    var mo = new MutationObserver(function example() {
        console.log('dom追加検知')
    });
    mo.observe(, {
        childList: true,
        attributes: true,
        characterData: true
    });
}, false);
