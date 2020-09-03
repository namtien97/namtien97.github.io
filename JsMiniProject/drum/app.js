document.addEventListener('DOMContentLoaded', () => {

    let crash = document.getElementById("crash");
    let ride = document.getElementById("ride");
    let floor_tom = document.getElementById("floor-tom");
    let kich_drum = document.getElementById("kich-drum");
    let high_tom = document.getElementById("high-tom");
    let mid_tom = document.getElementById("mid-tom");
    let open_hat = document.getElementById("open-hat");
    let snare = document.getElementById("snare");
    let hi_hat_closed = document.getElementById("hi-hat-closed");
    let body = document.querySelector("body").addEventListener("keydown", drum);
    function drum(event) {
        if (event.keyCode === 69) {
            crash.play();
        } else if (event.keyCode === 82) {
            ride.play();
        } else if (event.keyCode === 70) {
            floor_tom.play();
        } else if (event.keyCode === 71) {
            mid_tom.play();
        } else if (event.keyCode === 72) {
            high_tom.play();
        } else if (event.keyCode === 86 || event.keyCode === 66) {
            kich_drum.play();
        } else if (event.keyCode === 74) {
            snare.play();
        } else if (event.keyCode === 73) {
            open_hat.play();
        } else if (event.keyCode === 75) {
            hi_hat_closed.play();
        }
    }
})