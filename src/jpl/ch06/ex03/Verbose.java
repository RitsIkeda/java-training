package jpl.ch06.ex03;

interface Verbose {
    enum Level {
        SILENT, TESRSE, NORMAL, VERBOSE;
    }
    void setVerbosity(Level level);
    Level getVerbosity();
}
