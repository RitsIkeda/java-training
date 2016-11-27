package jpl.ch06.ex03;

interface Vehibose {
    enum Level {
        SILENT, TESRSE, NORMAL, VERBOSE;
    }
    void setVehibosity(Level level);
    Level getVhibosity();

}
