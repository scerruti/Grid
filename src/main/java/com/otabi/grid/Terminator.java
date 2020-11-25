package com.otabi.grid;

import java.awt.*;

public class Terminator extends Junction {
    public Terminator(int row, int column) {
        super(row, column);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (thick == null) {
            normal = g2.getStroke();
            thick = new BasicStroke(2);
        }

        g.setColor(Color.black);
        g2.setStroke(thick);
        g.drawOval(x, y, Grid.GRID_JUNCTION_SIZE * 2, Grid.GRID_JUNCTION_SIZE * 2);
        g2.setStroke(normal);
    }
}
