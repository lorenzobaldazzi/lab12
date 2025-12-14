package it.unibo.es3;

/**
 * Interface logics.
 */
public interface Logics {

    /**
     * Check if it is time to quit.
     * 
     * @return true if it is time to quit, false otherwhise
     */
    boolean toQuit();

    /**
     * Get the value. 
     * 
     * @param x row
     * @param y column
     * @return the value at the position (x,y)
     */
    String getValue(int x, int y);

    /**
     * Change the contentens of cells with "*" next to them.
     */
    void reload();
}
