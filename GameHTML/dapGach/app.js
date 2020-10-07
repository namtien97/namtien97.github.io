var canvas = document.querySelector('canvas');
var c = canvas.getContext('2d');

class Ball {
    constructor(x, y, radius, startAngle, endAngle, color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.color = color;
        this.dx = 5;
        this.dy = 0;
    }

    draw() {
        c.beginPath();
        c.arc(this.x, this.y, this.radius, this.startAngle, this.endAngle);
        c.fillStyle = this.color;
        c.fill();
        c.closePath();
    }

    move() {
        if (this.x === canvas.width) {
            this.dx = -5;
        } else if (this.x === this.radius) {
            this.dx = 5;
        } else if (this.y === this.radius) {
            this.dy = 5;
        } else if (this.y === canvas.height) {
            this.dy = -5;
        }
        this.x = this.x + this.dx;
        this.y = this.y + this.dy;
        this.draw();
    }
}

class Paddle {
    constructor(x, y, width, height, color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    draw() {
        c.beginPath();
        c.rect(this.x, this.y, this.width, this.height);
        c.fillStyle = this.color;
        c.fill();
        c.closePath();
    }
}

let bar = new Paddle(canvas.width / 2, canvas.height / 1.1, 100, 20, 'blue');
let ball = new Ball(canvas.width / 2, canvas.height / 1.2, 20, 0, Math.PI * 2, 'black');


function animate() {
    c.clearRect(0, 0, canvas.width, canvas.height);
    bar.draw();
    ball.draw();
    ball.move();
    requestAnimationFrame(animate);
}

animate();

