const square = document.querySelectorAll('.square') //gan bien square voi class square
const mole = document.querySelectorAll('.mole') //gan bien mole voi class mole
const timeLeft = document.querySelector('#time-left') //gan bien timeLeft voi id time-left
let score = document.querySelector('#score') //gan bien score voi id score

let result = 0 // khai bao bien result bang 0
let currentTime = timeLeft.textContent //khai bao bien currentTime se truyen time vao trong id timeLeft
// tao function random cac o vuong
function randomSquare() {
    square.forEach(className => {
        className.classList.remove('mole')//se xoa id mole trong o vuong duoc goi toi
    })
    let randomPosition = square[Math.floor(Math.random() * 9)]//khai bao 1 vi tri ngau nhien
    randomPosition.classList.add('mole')//them id mole vao vi tri ngau nhien do

    //assign the id of the randomPosition to hitPosition for us use later
    hitPosition = randomPosition.id
}
//tao function de moi khi kich vao se tang them 1 diem
square.forEach(id => {
    id.addEventListener('mouseup', () => {
        if (id.id === hitPosition) {
            result = result + 1
            score.textContent = result
        }
    })
})

//function se di chuyen mole theo 1 thoi gian nhat dinh
function moveMole() {
    let timerId = null
    timerId = setInterval(randomSquare, 1000)
}

moveMole()
//function dem nguoc thoi gian, khi nao het thoi gian se bao diem
function countDown() {
    currentTime --
    timeLeft.textContent = currentTime

    if(currentTime === 0){
        clearInterval(timerId)
        alert('GAME OVER! Your final score is' + result)
    }
}
//khai bao bien timerId, moi 1s se tru 1 lan
let timerId = setInterval(countDown, 1000)