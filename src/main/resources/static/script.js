const form = document.querySelector('#hidden_form_on_edit_data_cell')
const date = document.querySelector('#on_edit_data_cell___date')
const newValue = document.querySelector('#on_edit_data_cell___new_value')
const isDeadlineEdited = document.querySelector('#on_edit_data_cell___is_deadline_edited')

const inputCells = document.querySelectorAll('.input_cell')
inputCells.forEach((elem) => elem.onblur = () => {
    const row = elem.parentElement.parentElement

    date.value = row.children[1].textContent
    newValue.value = elem.value
    isDeadlineEdited.value = elem.parentElement === row.firstElementChild

    form.submit()
})
