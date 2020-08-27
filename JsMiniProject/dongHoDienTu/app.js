let hour = document.getElementById("hour");
let minutes = document.getElementById("minutes");
let seconds = document.getElementById("seconds");

let t = new Date();
let h = t.getHours();
let m = t.getMinutes();
let s = t.getSeconds();

let interval;

function timer() {
    if (s < 60) {
        s++;
        seconds.innerHTML = s;
    }
    if (s >= 60) {
        s = '00';
        m++;
        minutes.innerHTML = m;
    }
    if (m >= 60) {
        m = '00';
        minutes.innerHTML = m;
        h++;
        hour.innerHTML = h;
    }
    if (h >= 24) {
        h = '00';
        hour.innerHTML = h;
    }
}

interval = setInterval(timer, 1000)

function showTime(h, m, s) {
    hour.innerHTML = h;
    minutes.innerHTML = m;
    seconds.innerHTML = s;
}
showTime(h, m, s);