document.addEventListener('DOMContentLoaded', () => {
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

    let answer = 0;

    cong.addEventListener('click', function () {
        arrInput.push('+');
        input.innerHTML = arrInput.join(' ');
    })
    tru.addEventListener("click", function () {
        arrInput.push('-');
        input.innerHTML = arrInput.join(' ');
    });
    nhan.addEventListener("click", function () {
        arrInput.push('*')
        input.innerHTML = arrInput.join(' ');
    });
    chia.addEventListener("click", function () {
        arrInput.push('/');
        input.innerHTML = arrInput.join(' ');
    });

    button_0.addEventListener('click', function () {
        arrInput.push('0');
        input.innerHTML = arrInput.join(' ');
    })
    button_1.addEventListener('click', function () {
        arrInput.push('1');
        input.innerHTML = arrInput.join(' ');
    })
    button_2.addEventListener('click', function () {
        arrInput.push('2');
        input.innerHTML = arrInput.join(' ');
    })
    button_3.addEventListener('click', function () {
        arrInput.push('3');
        input.innerHTML = arrInput.join(' ');
    })
    button_4.addEventListener('click', function () {
        arrInput.push('4');
        input.innerHTML = arrInput.join(' ');
    })
    button_5.addEventListener('click', function () {
        arrInput.push('5');
        input.innerHTML = arrInput.join(' ');
    })
    button_6.addEventListener('click', function () {
        arrInput.push('6');
        input.innerHTML = arrInput.join(' ');
    })
    button_7.addEventListener('click', function () {
        arrInput.push('7');
        input.innerHTML = arrInput.join(' ');
    })
    button_8.addEventListener('click', function () {
        arrInput.push('8');
        input.innerHTML = arrInput.join(' ');
    })
    button_9.addEventListener('click', function () {
        arrInput.push('9');
        input.innerHTML = arrInput.join(' ');
    })
    button_dot.addEventListener('click', function () {
        arrInput.push('.');
        input.innerHTML = arrInput.join(' ');
    })
    button_del.addEventListener('click', function () {
        arrInput.splice(0, arrInput.length);
        input.innerHTML = arrInput.join(' ');

    })

    button_equal.addEventListener('click', function () {
        input.innerHTML = eval(arrInput.join(''));
    })
    function check() {
        if (arrInput.length === 0) {
            cong.setAttribute("disabled", "disabled");
            tru.setAttribute("disabled", "disabled");
            nhan.setAttribute("disabled", "disabled");
            chia.setAttribute("disabled", "disabled");
            button_dot.setAttribute("disabled", "disabled");
        } else {
            cong.removeAttribute("disabled");
            tru.removeAttribute("disabled");
            nhan.removeAttribute("disabled");
            chia.removeAttribute("disabled");
            button_dot.removeAttribute("disabled");
        }
    }
    setInterval(check, 100);
});
