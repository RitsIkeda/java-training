package jpl.ch01.ex14;

class WalkMan {
    private int serial;
    private static int nextSerial = 0;
    WalkMan() {
        serial = nextSerial++;
    }
    public int getSerial() {
        return serial;
    }
    /* nextSerialは非公開 */

    public void doBaseThing() {
        /* 基本的な機能が実装される */
    }
}

class  SpecialFeature {
    /* ウォークマン固有の特別な機能を持つ関数 */
    public void doSpecialThing() {
        /* 固有な機能が実装される */
    }
}

class SpecialWalkMan extends WalkMan {
    private SpecialFeature specialFeature; /* ウォークマン固有の特別な機能を搭載する */

    /* コンストラクタをオーバーロード */
    SpecialWalkMan(){
        super();
        specialFeature = new SpecialFeature();
    }
    /* 基本機能をオーバーロード */
    public void doBaseThing() {
        super.doBaseThing();
        specialFeature.doSpecialThing();
    }
}
