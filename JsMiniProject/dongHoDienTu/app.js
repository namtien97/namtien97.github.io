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
        s = (s < 10) ? "0" + s : s;
        seconds.innerHTML = s;
    }
    if (s >= 60) {
        s = 0;
        m++;
        m = (m < 10) ? "0" + m : m;
        minutes.innerHTML = m;
    }
    if (m >= 60) {
        m = 0;
        minutes.innerHTML = m;
        h++;
        h = (h < 10) ? "0" + h : h;
        hour.innerHTML = h;
    }
    if (h >= 24) {
        h = 0;
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