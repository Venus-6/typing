function show_hide_password(target){
	var input = document.getElementById('password-input');
	if (input.getAttribute('type') == 'password') {
		target.classList.add('view');
		input.setAttribute('type', 'text');
	} else {
		target.classList.remove('view');
		input.setAttribute('type', 'password');
	}
	return false;
}

const quoteDispElem = document.getElementById('quoteDisplay')
const quoteInpElem = document.getElementById('quoteInput')
const timerElem = document.getElementById('timer')

quoteInpElem.addEventListener('input', () =>{
  const arrayQuote = quoteDispElem.querySelectorAll('span')
  const arrayValue = quoteInpElem.value.split('')

  let correct = true;
  arrayQuote.forEach((characterSpan, index) => {
    const character = arrayValue[index]
    if(character == null){
      characterSpan.classList.remove('correct')
      characterSpan.classList.remove('incorrect')
      correct = false
    } else if(character === characterSpan.innerText){
      characterSpan.classList.add('correct')
      characterSpan.classList.remove('incorrect')
    } else {
      characterSpan.classList.remove('correct')
      characterSpan.classList.add('incorrect')
      correct = false
    }
  })
})

function score(){
  const quote = document.getElementsByClassName('o-hide');
  for (var i = 0; i < quote.length; i++) {
    var quoteText = quote[i].innerText;
  }
  quoteDispElem.innerHTML = '';
  quoteText.split('').forEach(character => {
    const characterSpan = document.createElement('span')
    characterSpan.innerHTML = character
    quoteDispElem.appendChild(characterSpan)
  });
  quoteInpElem.value = null;
  startTimer();
}

let startTime 
function startTimer(){
  timerElem.innerText = 0
  startTime = new Date()
  setInterval(()=>{
    timer.innerText = getTimerTime()
  }, 1000)
}

function getTimerTime(){
  return Math.floor((new Date() - startTime) / 1000)
}