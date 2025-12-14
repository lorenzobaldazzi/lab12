package it.unibo.es2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Logics impl interface.
 */
public class LogicsImpl implements Logics {
    private static final String ASTERISK = "*";
    private static final String SPACE = " ";
    private final List<List<String>> grid;

    /**
     * Constructor.
     * 
     * @param size label
     */
    public LogicsImpl(final int size) {
        this.grid = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<>(Collections.nCopies(size, SPACE)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit(final int x, final int y) {
        return checkRow(x) || checkColumn(y);
    }

    /**
     * Check if the row in full of "*".
     * 
     * @param x row
     * @return true if the row is full of "*", false otherwise
     */
    public boolean checkRow(final int x) {
        for (final String cell: grid.get(x)) {
            if (!ASTERISK.equals(cell)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the column in full of "*".
     * 
     * @param y column
     * @return true if the column is full of "*", false otherwise
     */
    public boolean checkColumn(final int y) {
        for (final List<String> row: grid) {
            if (!ASTERISK.equals(row.get(y))) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(final int x, final int y) {
        grid.get(x).set(y, SPACE.equals(grid.get(x).get(y)) ? ASTERISK : SPACE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue(final int x, final int y) {
        return grid.get(x).get(y);
    }

}
