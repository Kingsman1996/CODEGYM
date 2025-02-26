/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size, v) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;
    this.v = v

    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    }

    this.moveRight = function () {
        this.left += this.v;
    }

}

var hero = new Hero("./yasuo.jpg", 20, 30, 200, 2);

function start() {
    if (hero.left < window.innerWidth - hero.size) {
        hero.moveRight();
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    requestAnimationFrame(start);
}

start();