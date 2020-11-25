import java.awt.*;

public class Cell implements Component {
    public final int row;
    public final int column;
    private final int y;
    private final int x;
    private Color background;

    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
        this.x = column * Grid.CELL_SIZE + Grid.GRID_LEFT_OFFSET;
        this.y = row * Grid.CELL_SIZE + Grid.GRID_TOP_OFFSET;
        this.background = Color.lightGray;
    }

    public void setActive() {
        this.background = Color.white;
    }

    public void paint(Graphics g) {
        g.setColor(background);
        g.fillRect(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
        g.setColor(Color.black);
        g.drawRect(x, y, Grid.CELL_SIZE, Grid.CELL_SIZE);
    }
}
