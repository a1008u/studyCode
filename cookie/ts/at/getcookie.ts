namespace app {
    export const init = () => {

        setTimeout(() => {

            const arg = {}
            const pair : string[] = location.search.substring(1).split('&')
            pair.forEach((item) => {
                let [key, value] = item.split('=')
                arg[key] = value
            })

            document.cookie = `at=partnerId:${arg['partnerId']}, bannerId:${arg['bannerId']}; path=/; expires=Thu, 1-Jan-2030 00:00:00 GMT;`

            console.log(document.cookie)
            window.location.href = '../m/landing.html'
        }, 2000)

    }
}

app.init()
