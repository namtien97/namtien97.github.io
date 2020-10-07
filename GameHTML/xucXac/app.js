let roll = document.getElementById('roll');



let dice1 = document.getElementById('dice-1');
let dice2 = document.getElementById('dice-2');

let img = ['dice/dice-1.png', 'dice/dice-2.png', 'dice/dice-3.png', 'dice/dice-4.png', 'dice/dice-5.png', 'dice/dice-6.png']

roll.addEventListener('click', function () {

    dice1.style.display = 'block';
    dice2.style.display = 'block';
    let number1 = Math.floor(Math.random() * 6);
    let number2 = Math.floor(Math.random() * 6);
    let number = number1 + number2;
    dice1.src = img[number1];
    dice2.src = img[number2];
    let score1 = document.getElementsById('score1');
    let score2 = document.getElementsById('score2');
    console.log(number);
    score1.innerHTML = number;
})