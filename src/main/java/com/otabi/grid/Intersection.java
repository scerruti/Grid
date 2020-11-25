package com.otabi.grid;

import java.awt.*;

public class Intersection extends Junction {
    private final int number;

    public Intersection(int number, int row, int column) {
        super(row, column);
        this.number = number;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (thick == null) {
            normal = g2.getStroke();
            thick = new BasicStroke(2);
        }

        g.setColor(Color.white);
        g.fillOval(x, y, Grid.GRID_JUNCTION_SIZE * 2, Grid.GRID_JUNCTION_SIZE * 2);
        g2.setStroke(thick);
        g.setColor(Color.black);
        g.drawOval(x, y, Grid.GRID_JUNCTION_SIZE * 2, Grid.GRID_JUNCTION_SIZE * 2);
        g2.setStroke(normal);

        Font font = new Font("Sans", Font.PLAIN, Grid.CELL_SIZE / 3);
        g2.setFont(font);
        FontMetrics fontMetrics = g2.getFontMetrics();
        String text = Integer.toString(number);
        // Determine the X coordinate for the text
        int textX = x + (Grid.GRID_JUNCTION_SIZE * 2 - fontMetrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int textY = y + ((Grid.GRID_JUNCTION_SIZE * 2 - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        g2.drawString(text, textX, textY);    }
}
