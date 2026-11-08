const green = {
    light: 0,
    water: 0,
    temp: 0,
    nut: 0,
    grow: 0,

    giveLight(light) {
        this.light += light;
        document.getElementById("light").innerHTML = this.light;
    },
    giveWater(water) {
        this.water += water;
        document.getElementById("water").innerHTML = this.water;
    },
    giveTemp(temp) {
        this.temp += temp;
        document.getElementById("temp").innerHTML = this.temp;
    },
    giveNut(nut) {
        this.nut += nut;
        document.getElementById("nut").innerHTML = this.nut;
    },
    growth() {
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
    },
};
setInterval(() => green.growth(), 1000);
