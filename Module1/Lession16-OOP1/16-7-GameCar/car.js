const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")
canvas.width = window.innerWidth / 3
canvas.height = window.innerHeight - 50


class Car {
    constructor(x, y, v, rong, dai) {
        this.x = x
        this.y = y
        this.v = v
        this.rong = rong
        this.dai = dai
        this.image1 = new Image()
        this.image2 = new Image()
        this.image1.src = "./imgs/ferrari-laferrari-top-view-design-800x450-1.jpg"
        this.image2.src = "./imgs/rock.jfif"
    }

    draw() {
        ctx.clearRect(0, 0, canvas.width, canvas.height)
        ctx.drawImage(this.image1, this.x, this.y, this.rong, this.dai);
        ctx.drawImage(this.image2, 100, 100, 100, 100);
    }

    manualMove() {
        document.addEventListener("keydown", (ev) => {
            switch (ev.key) {
                case "ArrowUp":
                    this.y -= this.v
                    break;
                case "ArrowDown":
                    this.y += this.v
                    break;
                case "ArrowLeft":
                    this.x -= this.v
                    break;
                case "ArrowRight":
                    this.x += this.v
                    break
                case "Control":
                    this.v += 5
            }
            if (this.x)
            this.draw()
        })
    }
}

const car = new Car(canvas.width / 2 - 50, canvas.height - 100, 10, 100, 100)

car.image1.onload = () => {
    car.draw();
    car.manualMove();
};