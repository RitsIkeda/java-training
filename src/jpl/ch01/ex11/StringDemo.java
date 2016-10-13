package jpl.ch01.ex11;

class StringDemo {
    public static void main(String[] args) {
        String occupation = "theoretical physicist";

        String myName = "Albert";
        myName += " Einstein ";
        myName += "(" + occupation + ")";

        System.out.println("Name = " + myName);

    }
}
