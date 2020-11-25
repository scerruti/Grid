import java.awt.*;

public class Segment {
    private final int x1, y1, x2, y2;
    private Color color = Color.black;
    private static Stroke thick = null;
    private static Stroke normal;

    public Segment(Point p1, Point p2) {
        x1 = p1.x * Grid.CELL_SIZE + Grid.CELL_SIZE/2 + Grid.GRID_LEFT_OFFSET;
        y1 = p1.y * Grid.CELL_SIZE + Grid.CELL_SIZE/2 + Grid.GRID_TOP_OFFSET;

        x2 = p2.x * Grid.CELL_SIZE + Grid.CELL_SIZE/2 + Grid.GRID_LEFT_OFFSET;
        y2 = p2.y * Grid.CELL_SIZE + Grid.CELL_SIZE/2 + Grid.GRID_TOP_OFFSET;

        Grid grid = Grid.getInstance();
        for (int column = Math.min(p1.x, p2.x); column <= Math.max(p1.x, p2.x); column++) {
            for (int row = Math.min(p1.y, p2.y); row <= Math.max(p1.y, p2.y); row++) {
                grid.getCell(column, row).ifPresent(Cell::setActive);
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (thick == null) {
            normal = g2.getStroke();
            thick = new BasicStroke(3);
        }
        g.setColor(color);
        g2.setStroke(thick);
        g.drawLine(x1, y1, x2, y2);
        g2.setStroke(normal);
    }

    public void setOptimal() {
        color = Color.blue;
    }
}
