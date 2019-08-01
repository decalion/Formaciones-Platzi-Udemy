const compose = (...functions) => data =>
  functions.reduceRight((value, func) => func(value), data)

/*
 {
 tag: 'h1',
 attr:{
    class: 'title'
}

}
*/
const attrsToString = (obj = {}) =>{
  const keys = Object.keys(obj);
  const attrs = []

  for(let i =0; i<keys.length; i++){
    let attr = keys[i]
    attrs.push(`${attr}="${obj[attr]}"`);
  }

  const string = attrs.join('');

  return string;
}

const tagAttrs = obj => (content = '') =>
  `<${obj.tag}${obj.attrs ? ' ' :	 ''}${attrsToString(obj.attrs)}>${content}</${obj.tag}>`
const tag = t => {
  if(typeof t === 'string') {
    return tagAttrs({ tag: t })
  }
  return tagAttrs(t)
}

const tableRowTag = tag('tr')
const tableRow = items => compose(tableRowTag, tableCells)(items)

const tableCell = tag('td')
const tableCells = items => items.map(tableCell).join('')


const trashIcon = tag({tag: 'i', attrs:{class: 'fas fa-trash-alt'} })('');

//                <button class="btn btn-outline-danger" onclick="removeItem(index);">
//                  <i class="fas fa-trash-alt"></i>
//                </button>
//console.log(tag('h1')('Title')); //<h1>Title</h1>

let description = $('#description')
let carbs = $('#carbs')
let calories = $('#calories')
let protein = $('#protein')

let list = []


description.keypress(() => {
  description.removeClass('is-invalid');
})

carbs.keypress(() => {
  carbs.removeClass('is-invalid');
})

calories.keypress(() => {
  calories.removeClass('is-invalid');
})

protein.keypress(() => {
  protein.removeClass('is-invalid');
})

const validateInputs = () => {

  description.val() ? '' : description.addClass('is-invalid');
  calories.val() ? '' : calories.addClass('is-invalid');
  carbs.val() ? '' : carbs.addClass('is-invalid');
  protein.val() ? '' : protein.addClass('is-invalid');

  if(description.val() && calories.val() && carbs.val() && protein.val()){

    add();
  }



}

const add = () => {
  const newItem = {
     description: description.val(),
     calories: parseInt(calories.val()),
     carbs: parseInt(carbs.val()),
     protein: parseInt(protein.val())
  }
  list.push(newItem);
  clearInputs();
  updateTotal();
  renderItem();
}

const updateTotal = () =>{
  let calories = 0 , carbs = 0, protein = 0;

  list.map(item => {
    calories += item.calories,
    carbs += item.carbs,
    protein += item.protein
  })

  $('#totalCalories').text(calories);
  $('#totalCarbs').text(carbs);
  $('#totalProtein').text(protein);

}


const clearInputs =() => {
  description.val('');
  calories.val('');
  carbs.val('');
  protein.val('');
}

const renderItem = () =>{
  $('tbody').empty();

  list.map( (item , index)=> {

    const removeButton = tag({
      tag: 'button',
      attrs:{
        class: 'btn btn-outline-danger',
        onclick: `removeItem(${index})`
      }
    })(trashIcon);

    $('tbody').append(tableRow([item.description, item.calories,item.carbs, item.protein,removeButton]))
  })
}

const removeItem =(index) =>{
  list.splice(index,1);

  updateTotal();
  renderItem();
}
