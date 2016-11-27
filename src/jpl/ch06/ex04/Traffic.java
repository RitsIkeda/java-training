package jpl.ch06.ex04;

class Color {
    public int r,g,b;
    Color(int r,int g,int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}


enum Traffic{
    RED(255,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);

    Color color;
    Traffic(int r,int g,int b) {
        color = new Color(r,g,b);
    }
    Color getColor() {
        return color;
    }
}
