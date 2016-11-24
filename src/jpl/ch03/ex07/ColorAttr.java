package jpl.ch03.ex07;


class ScreenColor{
    private Object color;

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    ScreenColor( Object color ) {
        this.color = color;
    }
    public boolean equals(ScreenColor other) {
        return (this.color == other.color);
    }
    public int hashCode() {
        return color.hashCode();
    }
}

public class ColorAttr extends Attr {
    private ScreenColor myColor;

    public boolean equals(ColorAttr other) {
        return this.myColor.equals( other.myColor);
    }
    public int hashCode() {
        return myColor.hashCode();
    }

    public ColorAttr(String name, Object value) {
        super(name,value);
        decodeColor();
    }
    public ColorAttr(String name) {
        this(name,"transparent");
    }
    public ColorAttr(String name, ScreenColor value) {
        super(name, value.toString());
        myColor = value;
    }
    public Object setValue(Object newValue){
        Object retval = super.setValue(newValue);
        decodeColor();
        return retval;
    }
    public ScreenColor setValue(ScreenColor newValue){
        super.setValue(newValue.toString());
        ScreenColor oldValue = myColor;
        myColor = newValue;
        return oldValue;
    }

    public ScreenColor getColor() {
        return myColor;
    }

    protected void decodeColor() {
        if(getValue() == null) {
            myColor = null;
        } else {
            myColor = new ScreenColor(getValue());
        }
    }


}
