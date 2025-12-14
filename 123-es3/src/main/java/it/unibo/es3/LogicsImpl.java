package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Implements logics.
 */
public final class LogicsImpl implements Logics {
    private static final String ASTERISK = "*";
    private static final String SPACE = " ";
    private final List<List<String>> grid;

    /**
     * Constructor.
     * 
     * @param width label
     */
    public LogicsImpl(final int width) {
        this.grid = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            grid.add(new ArrayList<>(Collections.nCopies(width, SPACE)));
        }
        final Random casual = new Random();
        final Set<String> used = new HashSet<>();
        int i = 0;
        while (i < 3) {
            final int xc = casual.nextInt(width);
            final int yc = casual.nextInt(width);
            final String key = xc + "|" + yc;
            if (!used.contains(key)) {
                used.add(key);
                grid.get(xc).set(yc, ASTERISK);
                i++;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return grid.stream().flatMap(List::stream).allMatch(ASTERISK::equals);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue(final int x, final int y) {
        return grid.get(x).get(y);
    }

    @Override
    public void reload() {
        final int size = this.grid.size();

        final List<List<String>> tmpGrid = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            tmpGrid.add(new ArrayList<>(this.grid.get(i)));
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (ASTERISK.equals(this.grid.get(x).get(y))) {
                    //in alto
                    if (x > 0) {
                        tmpGrid.get(x - 1).set(y, ASTERISK);
                    }

                    //in basso
                    if (x < size - 1) {
                        tmpGrid.get(x + 1).set(y, ASTERISK);
                    }

                    //sinistra
                    if (y > 0) {
                        tmpGrid.get(x).set(y - 1, ASTERISK);
                    }

                    //destra
                    if (y < size - 1) {
                        tmpGrid.get(x).set(y + 1, ASTERISK);
                    }

                    //in alto a destra
                    if (x > 0 && y < size - 1) {
                        tmpGrid.get(x - 1).set(y + 1, ASTERISK);
                    }

                    //in alto a sinistra
                    if (x > 0 && y > 0) {
                        tmpGrid.get(x - 1).set(y - 1, ASTERISK);
                    }

                    //in basso a destra
                    if (x < size - 1 && y < size - 1) {
                        tmpGrid.get(x + 1).set(y + 1, ASTERISK);
                    }

                    //in basso a sinistra
                    if (x < size - 1 && y > 0) {
                        tmpGrid.get(x + 1).set(y - 1, ASTERISK);
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            this.grid.set(i, tmpGrid.get(i));
        }
    }
}
