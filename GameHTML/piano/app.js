let canvas = document.getElementById("canvas");
let c = canvas.getContext('2d');


class Piano {
    constructor(x, y, width, height, type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    };

    draw() {
        c.fillStyle = this.type;
        c.fillRect = (this.x, this.y, this.width, this.height);
        c.strokeRect = (this.x, this.y, this.width, this.height);
    };
};

class Piano {
    constructor() {

    }
}