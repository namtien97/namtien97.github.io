let secondApp = document.getElementById("second");
let millisecondApp = document.getElementById("millisecond");
let button_start = document.getElementById("button_start");
let button_stop = document.getElementById("button_stop");
let button_reset = document.getElementById("button_reset");
let interval;

let second = 00;
let millisecond = 00;

button_start.onclick = function () {
    clearInterval(interval);
    interval = setInterval(startTimer, 10);
    console.log((interval));
}

button_stop.onclick = function () {
    clearInterval(interval);
}

button_reset.onclick = function () {
    clearInterval(interval);
    second = '00';
    millisecond = '00';
    secondApp.innerHTML = second;
    millisecondApp.innerHTML = millisecond;
}


function startTimer() {
    millisecond++;
    if (millisecond < 9) {
        millisecondApp.innerHTML = '0' + millisecond;
    }
    if (millisecond > 9) {
        millisecondApp.innerHTML = millisecond;
    }
    if (millisecond > 99) {
        second++;
        secondApp.innerHTML = '0' + second;
        millisecond = 0;
        millisecondApp.innerHTML = '0' + 0;
    }
    if (second > 9) {
        secondApp.innerHTML = second;
        console.log(second);
    }
}


