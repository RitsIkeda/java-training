package jpl.ch04.ex04;

interface Correction {
    void add(Object value);
    void add(Object[] values);
    void make(Object[] values);
    void delete(Object value);
    void initilize();
    int size();
    void sort();
}
