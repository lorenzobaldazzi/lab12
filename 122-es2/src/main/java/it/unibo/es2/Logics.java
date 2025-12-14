package it.unibo.es2;

/**
 * Logics interface.
 */
public interface Logics {

    /**
     * Understand when is time to quit.
     * 
     * @param x axis
     * @param y axis
     * @return true if it is time to quit, false otherwhise
     */
    boolean toQuit(int x, int y);

    /**
     * Set the '*' or ''.
     * 
     * @param x axis
     * @param y axis
     * 
     */
    void setValue(int x, int y);

    /**
     * Get the value. 
     * 
     * @param x row
     * @param y column
     * @return the value at the position (x,y)
     */
    String getValue(int x, int y);

}
