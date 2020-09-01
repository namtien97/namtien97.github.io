document.addEventListener('DOMContentLoaded', () => { //ArrowFunction
    //Khai bao cac bien cua card bang array
    const cardArray = [
        {
            name: 'fries',
            img: 'image/fries.png'
        },
        {
            name: 'fries',
            img: 'image/fries.png'
        },
        {
            name: 'cheeseburger',
            img: 'image/cheeseburger.png'
        },
        {
            name: 'cheeseburger',
            img: 'image/cheeseburger.png'
        },
        {
            name: 'hotdog',
            img: 'image/hotdog.png'
        },
        {
            name: 'hotdog',
            img: 'image/hotdog.png'
        },
        {
            name: 'ice-cream',
            img: 'image/ice-cream.png'
        },
        {
            name: 'ice-cream',
            img: 'image/ice-cream.png'
        },
        {
            name: 'milkshake',
            img: 'image/milkshake.png'
        },
        {
            name: 'milkshake',
            img: 'image/milkshake.png'
        },
        {
            name: 'pizza',
            img: 'image/pizza.png'
        },
        {
            name: 'pizza',
            img: 'image/pizza.png'
        }
    ]
    const grid = document.querySelector('.grid')//gan bien grid theo class = "grid" ben html
    const resultDisplay = document.querySelector('#result')//gan bien resultDisplay theo id = "result" ben html
    const timeDisplay = document.getElementById('time');
    let audio = document.getElementById("audio")
    let winAudio = document.getElementById("winAudio");
    let loseAudio = document.getElementById("loseAudio");
    console.log(audio);
    var cardsChosen = []

    var cardsChosenId = []
    let cardsWon = [] //kieu khai bao let se thay doi duoc gia tri con khai bao const thi khong thay doi duoc gia tri
    //tao ra bang
    function createBoard() {
        cardArray.sort(() => 0.5 - Math.random())//sap xep lai mang cardArray theo thu tu ngau nhien 
        for (let i = 0; i < cardArray.length; i++) { //dung .length de co the dem so phan tu trong mang
            var card = document.createElement('img') //tao element 'img' gan voi bien card
            card.setAttribute('src', 'image/blank.png') //card.setAttribute se gan src vao 'img' voi 2 gia tri la src va image/blank.png
            card.setAttribute('id', 'remove' + i)
            card.setAttribute('data-id', i) //them attribute la data-id voi gia tri theo bien i
            card.addEventListener('click', flipcard) //gan click voi function flipcard
            grid.appendChild(card) //them card thanh con cua grid
            audio.play();
            winAudio.pause();
            loseAudio.pause();
        }
    }
    //check for matches
    function checkForMatch() {
        var cards = document.querySelectorAll('img')//lọc tất cả các dữ liệu có img
        const optionOneId = cardsChosenId[0] //khai báo biến 
        const optionTwoId = cardsChosenId[1]
        if (optionOneId == optionTwoId) { //click cùng 1 tấm sẽ hiện ra trường hợp này
            cards[optionOneId].setAttribute('src', 'image/blank.png') //ẩn lại hình ảnh bằng cách setAtribute lại
            cards[optionOneId].removeAttribute('class', 'shake')
        } else if (cardsChosen[0] === cardsChosen[1]) {// nếu id giống nhau thì sẽ đúng
            cards[optionOneId].setAttribute('src', 'image/white.png') //hiện lên màn hình người dùng hình trắng
            cards[optionTwoId].setAttribute('src', 'image/white.png')
            cards[optionOneId].removeEventListener('click', flipcard)//de khong bam lai duoc nua
            cards[optionTwoId].removeEventListener('click', flipcard)
            cardsWon.push(cardsChosen) //thêm vào mảng cardsChosen để tí nữa xét xem đã tìm hết hình chưa
        } else {
            cards[optionOneId].setAttribute('src', 'image/blank.png')
            cards[optionTwoId].setAttribute('src', 'image/blank.png')

        }
        cardsChosen = []
        cardsChosenId = []
        resultDisplay.textContent = cardsWon.length //kết quả hiện lên màn hình sẽ bằng số lượng mảng trong array cardsWon
        if (cardsWon.length === cardArray.length / 2) {
            document.getElementById('body-1').style.display = "none";
            document.getElementById('container_grid').style.display = "none";
            playBtn.disabled = false;
            clearInterval(interval);
            win.style.display = "flex";
            audio.pause();
            winAudio.play();
        }
    }

    //flip your card
    function flipcard() {
        var cardId = this.getAttribute('data-id') //gắn data-id vào biến cardId
        cardsChosen.push(cardArray[cardId].name) //thêm phần tử .name từ cardArray
        cardsChosenId.push(cardId) //thêm phần tử cardId vào cardsChosenId
        this.setAttribute('src', cardArray[cardId].img)//chuyen hinh trang sau hinh trong cardArray
        if (cardsChosenId[0] === cardsChosenId[1]) {
            this.setAttribute('class', 'shake')
        }
        if (cardsChosen.length === 2) {
            setTimeout(checkForMatch, 500) //nếu mảng cardsChosen có độ dài bằng 2 sẽ chạy vể function checkForMatch để kiếm tra
        }

    }
    let playBtn = document.getElementById('button_play')
    let time = 60;
    let gameover = document.getElementById("gameover")
    let win = document.getElementById("win")
    function countTime() {
        time = time - 1;
        if (time === 0) {
            document.getElementById('body-1').style.display = "none";
            document.getElementById('container_grid').style.display = "none";
            clearInterval(interval);
            gameover.style.display = "flex";
            audio.pause();
            loseAudio.play();
        }
        timeDisplay.innerHTML = time;
    }
    let interval;
    function timeShow() {
        interval = setInterval(countTime, 1000);
        document.getElementById('body-1').style.display = "flex";
        document.getElementById('container_grid').style.display = "flex";
        playBtn.disabled = true;
    }
    function removeBoard() {
        for (let i = 0; i < cardArray.length; i++) {
            let img = document.getElementById('remove' + i)
            grid.removeChild(img);
        }
        time = 60;
        cardsWon = []
        resultDisplay.innerHTML = 0;
    }
    function newGame() {
        removeBoard();
        createBoard();
        playBtn.disabled = true;
        timeShow();
        gameover.style.display = "none";
        win.style.display = "none";
    }
    playBtn.addEventListener("click", newGame)
    createBoard();
})


