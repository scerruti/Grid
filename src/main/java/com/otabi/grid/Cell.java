package com.otabi.grid;

import java.awt.*;


public class Cell implements Component {
    public final int row;
    public final int column;
    private final int y;
    private final int x;
    private Color background;

    /**
     * Creates an inactive cell in the grid at column and row specified.
     * @param column zero based column of cell
     * @param row zero based row of cell
     */
    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
        this.x = column * Grid.CELL_SIZE + Grid.GRID_LEFT_OFFSET;
        this.y = row * Grid.CELL_SIZE + Grid.GRID_TOP_OFFSET;
        this.background = Color.lightGray;
    }

    /**
     * Sets the cell to active, the background color is turned white
     */
    public void setActive() {
        this.background = Color.white;
    }

    /**
     * Paints the cell on the grid by drawing the fill and outline
     * @param g the graphics of the grid
     */
    public void paint(Graphics g) {
        g.setColor(background);
        g.fillRect(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        g.setColor(Color.black);
        g.drawRect(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
    }
}
