import TodosView from './view/todosView'

namespace app {
    export const init = () => {
        const $todos = document.getElementById('todos')
        const $input = document.getElementById('todo-input')
        const $addBtn = document.getElementById('add-todo')

        // 初回実行（todoデフォルトを表示）
        const todosView = TodosView($todos, 'create app', 'learn new technology')
        todosView.render()

        // inputボタン用
        $input.addEventListener('keypress', (event) => {
            if (event['keyCode'] == 13) {
                todosView.action('add', $input['value'])
                $input['value'] = ''
            }
        })

        // addボタン用
        $addBtn.addEventListener('click', () => {
            todosView.action('add', $input['value'])
            $input['value'] = ''
        })

    }
}

app.init()
