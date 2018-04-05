import TodoModel from '../model/todoModel'

const todoCollection = (...titleArr: string[]) => {
    let collection: object[] = titleArr.map((title, index) => { return TodoModel(index, title) })

    /**
     * TodoModelを取得する
     * @returns {object[]}
     */
    const get = (): object[] => { return collection }

    /**
     *
     * @param {string} title
     */
    const add = (title: string): void => {
        const id = collection.length
        collection = [...collection, TodoModel(id, title)]
    }

    /**
     *
     * @param {number} id
     */
    const remove = (id: number): void => {
        collection = collection.filter((todoModel) => {return todoModel['id'] !== id} )
    }

    const toggleCompleted = (id: number): void => {
        collection = collection.map((todoModel) => {
            if (todoModel['id'] === id) return {...todoModel, completed: !todoModel['completed']}
            return todoModel
        })
    }

    return {
        get,
        add,
        remove,
        toggleCompleted
    }
}

export default todoCollection
