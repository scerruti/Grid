import java.awt.*;

public class Intersection extends Junction {
    public Intersection(int row, int column) {
        super(row, column);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, Grid.GRID_JUNCTION_RADIUS * 2, Grid.GRID_JUNCTION_RADIUS * 2);
    }
}
