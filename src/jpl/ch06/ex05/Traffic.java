package jpl.ch06.ex05;

class Color {
    public int r,g,b;
    Color(int r,int g,int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public static Color getRedColor() {
        return new Color(255,0,0);
    }
    public static Color getYellowColor() {
        return new Color(255,255,0);
    }
    public static Color getGreenColor() {
        return new Color(0,255,0);
    }
}

enum Traffic {
    /* 連取問題6.5。定数固有のメソッドを使用。
        enumで定義したカラーと完全一致したカラーが返ることが保障されないため、
        推奨されない。 */
    RED(255,0,0) {
        Color getColor() { return Color.getRedColor(); }
    },
    YELLOW(255,255,0){
        Color getColor()  { return Color.getYellowColor(); }
    },
    GREEN(0,255,0){
        Color getColor()  { return Color.getGreenColor(); }
    };
    Color color;
    abstract Color getColor();
    Traffic(int r,int g,int b) {
        color = new Color(r,g,b);
    }

}
