package com.otabi.Grid;

import java.awt.*;

public class Intersection extends Junction {
    public Intersection(int row, int column) {
        super(row, column);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (thick == null) {
            normal = g2.getStroke();
            thick = new BasicStroke(2);
        }

        g2.setStroke(thick);
        g.setColor(Color.black);
        g.drawRect(x, y, Grid.GRID_JUNCTION_SIZE * 2, Grid.GRID_JUNCTION_SIZE * 2);
        g2.setStroke(normal);
    }
}
