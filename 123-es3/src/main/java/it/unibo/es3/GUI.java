package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<JButton, Pair<Integer, Integer>> cells = new LinkedHashMap<>();
    private final transient Logics grid;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.grid = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        final JButton buttonSkip = new JButton(">");
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(buttonSkip, BorderLayout.SOUTH);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(i, j);
                final JButton button = new JButton(grid.getValue(i, j));
                this.cells.put(button, pos);
                panel.add(button);
            }
        }

        buttonSkip.addActionListener(e -> {
            this.grid.reload();
            for (final var cell: this.cells.entrySet()) {
                final JButton button = cell.getKey();
                final Pair<Integer, Integer> p = cell.getValue();
                button.setText(this.grid.getValue(p.x(), p.y()));
            }

            if (this.grid.toQuit()) {
                dispose();
            }
        });
        pack();
        this.setVisible(true);
    }
}
