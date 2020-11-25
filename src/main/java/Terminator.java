import java.awt.*;

public class Terminator extends Junction {
    public Terminator(int row, int column) {
        super(row, column);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(x, y, Grid.GRID_JUNCTION_RADIUS * 2, Grid.GRID_JUNCTION_RADIUS * 2);
    }
}
