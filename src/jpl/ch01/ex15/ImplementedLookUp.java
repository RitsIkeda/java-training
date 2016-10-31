package jpl.ch01.ex15;

interface LookUp {
    /* nameと関連ついた値を返す */
    Object find(String name);
    /* nameと関連つくオブジェクトを追加する */
    boolean add(String name, Object value);
    /** nameと関連ついた値を削除 */
    boolean remove(String name);
}

public class ImplementedLookUp implements LookUp {
    private static final int ARRAY_SIZE = 1000;

    private String[] names = new String[ARRAY_SIZE];
    private Object[] values = new Object[ARRAY_SIZE];

    public Object find(String name) {
        for(int i = 0; i < names.length; i++) {
            if(names[i] != null && names[i].equals(name)) {
                return values[i];
            }
        }
        return null;
    }
    public boolean add(String name, Object value) {
        for(int i = 0; i < names.length; i++) {
            if(names[i] == null) {
                names[i] = name;
                values[i] = value;
                return true;
            }
        }
        return false;
    }

    public boolean remove(String name) {
        for(int i = 0; i < names.length; i++) {
            if(names[i].equals(name)) {
                names[i] = null;
                values[i] = null;
                return true;
            }
        }
        return false;
    }
}
