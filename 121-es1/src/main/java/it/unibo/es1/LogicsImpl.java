package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> buttonValues;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.buttonValues = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.buttonValues.add(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.buttonValues.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return Collections.unmodifiableList(buttonValues);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> enable = new ArrayList<>(this.buttonValues.size());
        for (final int value: buttonValues) {
            enable.add(value != buttonValues.size());
        }
        return enable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        buttonValues.set(elem, buttonValues.get(elem) + 1);
        return buttonValues.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return buttonValues.stream().map(String::valueOf).collect(Collectors.joining("|"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return buttonValues.stream().distinct().count() <= 1;
    }
}
