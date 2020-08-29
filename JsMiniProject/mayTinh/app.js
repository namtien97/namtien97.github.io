let input = document.getElementById("input");
let cong = document.getElementById("cong");
let tru = document.getElementById("tru");
let nhan = document.getElementById("nhan");
let chia = document.getElementById("chia");
let button_0 = document.getElementById("button_0");
let button_1 = document.getElementById("button_1");
let button_2 = document.getElementById("button_2");
let button_3 = document.getElementById("button_3");
let button_4 = document.getElementById("button_4");
let button_5 = document.getElementById("button_5");
let button_6 = document.getElementById("button_6");
let button_7 = document.getElementById("button_7");
let button_8 = document.getElementById("button_8");
let button_9 = document.getElementById("button_9");
let button_dot = document.getElementById("button_dot");
let button_del = document.getElementById("button_del");
let button_equal = document.getElementById("button_equal");
let arrInput = [];

function fill_0() {
    arrInput.push('0')
    console.log('0');
    console.log(arrInput);
    input.innerHTML = arrInput;
}

console.log(arrInput,'ngoai');

function fill_1() {
    arrInput.push('1')
}

function cal() {

    console.log(arrInput);


}
cal();

