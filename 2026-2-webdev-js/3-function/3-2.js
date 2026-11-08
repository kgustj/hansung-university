let light, water, temp, nut, grow;

function tree() {
    this.light = 0;
    this.water = 0;
    this.temp = 0;
    this.nut = 0;
    this.grow = 0;

    this.giveLight = function (light) {
        this.light += light;
        document.getElementById("light").innerHTML = this.light;
    };

    this.giveWater = function (water) {
        this.water += water;
        document.getElementById("water").innerHTML = this.water;
    };

    this.giveTemp = function (temp) {
        this.temp += temp;
        document.getElementById("temp").innerHTML = this.temp;
    };

    this.giveNut = function (nut) {
        this.nut += nut;
        document.getElementById("nut").innerHTML = this.nut;
    };

    this.growth = function () {
        let isGrow = true;
        if (this.light <= 0 || this.water <= 0) isGrow = false;
        if (this.temp < 15 || 40 < this.temp) isGrow = false;

        if (isGrow) {
            if (this.nut >= 1) {
                this.grow += 2;
            } else {
                this.grow++;
            }
            document.getElementById("growth").innerHTML = this.grow;
            document.getElementById("treeImg").style.width = `${100 + this.grow * 10}px`;
        }
    };
    setInterval(() => this.growth(), 1000);
}

let green = new tree();
