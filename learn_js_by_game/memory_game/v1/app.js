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

    cardArray.sort(() => 0.5 - Math.random())//sap xep lai mang cardArray theo thu tu ngau nhien 

    const grid = document.querySelector('.grid')//gan bien grid theo class = "grid" ben html
    const resultDisplay = document.querySelector('#result')//gan bien resultDisplay theo id = "result" ben html
    var cardsChosen = [] 
    var cardsChosenId = []
    const cardsWon = [] //kieu khai bao let se thay doi duoc gia tri con khai bao const thi khong thay doi duoc gia tri
    //tao ra bang
    function createBoard() {
        for (let i = 0; i < cardArray.length; i++) { //dung .length de co the dem so phan tu trong mang
            var card = document.createElement('img') //tao element 'img' gan voi bien card
            card.setAttribute('src', 'image/blank.png') //card.setAttribute se gan src vao 'img' voi 2 gia tri la src va image/blank.png
            card.setAttribute('data-id', i) 
            card.addEventListener('click', flipcard) 
            grid.appendChild(card) //them card thanh con cua grid
        }
    }
    //check for matches
    function checkForMatch() {
        var cards = document.querySelectorAll('img') //lọc tất cả các dữ liệu có img
        const optionOneId = cardsChosenId[0] //khai báo biến 
        const optionTwoId = cardsChosenId[1]

        if (optionOneId == optionTwoId) { //click cùng 1 tấm sẽ hiện ra trường hợp này
            cards[optionOneId].setAttribute('src', 'image/blank.png') //ẩn lại hình ảnh bằng cách setAtribute lại
            cards[optionTwoId].setAttribute('src', 'image/blank.png')
            alert('You have clicked the same image!') 
        } else if (cardsChosen[0] === cardsChosen[1]) {// nếu id giống nhau thì sẽ đúng
            alert('You found a match')
            cards[optionOneId].setAttribute('src', 'image/white.png') //hiện lên màn hình người dùng hình trắng
            cards[optionTwoId].setAttribute('src', 'image/white.png')
            cards[optionOneId].removeEventListener('click', flipcard)
            cards[optionTwoId].removeEventListener('click', flipcard)
            cardsWon.push(cardsChosen) //thêm vào mảng cardsChosen để tí nữa xét xem đã tìm hết hình chưa
        } else {
            cards[optionOneId].setAttribute('src', 'image/blank.png') 
            cards[optionTwoId].setAttribute('src', 'image/blank.png')
            alert('Sorry, try again')
        }
        cardsChosen = []
        cardsChosenId = []
        resultDisplay.textContent = cardsWon.length //kết quả hiện lên màn hình sẽ bằng số lượng mảng trong array cardsWon
        if (cardsWon.length === cardArray.length / 2) {
            resultDisplay.textContent = 'Congratulations! You found them all!'
        }
    }

    //flip your card
    function flipcard() {
        var cardId = this.getAttribute('data-id') //gắn data-id vào biến cardId
        cardsChosen.push(cardArray[cardId].name) //thêm phần tử .name từ cardArray
        cardsChosenId.push(cardId) //thêm phần tử cardId vào cardsChosenId
        this.setAttribute('src', cardArray[cardId].img) 
        if (cardsChosen.length === 2) {
            setTimeout(checkForMatch, 500) //nếu mảng cardsChosen có độ dài bằng 2 sẽ chạy vể function checkForMatch để kiếm tra
        }
    }
    createBoard()
})

