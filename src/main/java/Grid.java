import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Grid extends JFrame {

    public static final int GRID_WIDTH = 24;
    public static final int GRID_HEIGHT = 16;
    public static final int CELL_SIZE = 24;
    public static final int GRID_LEFT_OFFSET = CELL_SIZE;
    public static final int GRID_TOP_OFFSET = (int) (CELL_SIZE * 0.75);
    public static final int GRID_JUNCTION_SIZE = CELL_SIZE / 4;

    private static final Grid instance = new Grid();

    private final ArrayList<Component> components = new ArrayList<>();
    private final Canvas canvas;

    private Grid()
    {
        super("Grid");

        // create a empty canvas
        canvas = new Canvas() {
            public void paint(Graphics g) {
                components.forEach(component -> component.paint(g));
            }
        };

        // set background
        canvas.setBackground(Color.white);

        add(canvas);

        int width = (GRID_WIDTH + 2) * CELL_SIZE;
        int height = (int) ((GRID_HEIGHT + 1.5) * CELL_SIZE) + 20;
        setSize(width, height);

        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                components.add(new Cell(x, y));
            }
        }
    }

    public static Grid getInstance() {
        return instance;
    }

    // Main Method
    public static void main(String[] args)
    {
        Grid grid = Grid.getInstance();

        ArrayList<Point> path = new ArrayList<>();
        path.add(new Point(0,0));
        path.add(new Point(3,0));
        path.add(new Point(3,4));
        path.add(new Point(3, 6));
        path.add(new Point(7, 6));
        path.add(new Point(7, 4));
        grid.addPath(path);

        path = new ArrayList<>();
        path.add(new Point(3, 2));
        path.add(new Point(7, 2));
        path.add(new Point(7, 4));
        grid.addPath(path, true);

        grid.addTerminator(0, 0);
        grid.addTerminator(4, 7);

        grid.addIntersection(2, 3);

        grid.setVisible(true);
        grid.saveImage();

    }

    public void addTerminator(int row, int column) {
        components.add(new Terminator(row, column));
    }

    public void addIntersection(int row, int column) {
        components.add(new Intersection(row, column));
    }

    public Optional<Cell> getCell(int column, int row) {
        return components.stream()
                .filter(component -> component instanceof Cell)
                .map(component -> ((Cell) component))
                .filter(cell -> cell.column == column && cell.row == row)
                .findFirst();
    }

    public void addPath(ArrayList<Point> path) {
        components.add(new Path(path));
    }

    public void addPath(ArrayList<Point> path, boolean optimal) {
        components.add(new Path(path, optimal));
    }

    public void saveImage() {
        BufferedImage image=new BufferedImage(canvas.getWidth(), canvas.getHeight(),BufferedImage.TYPE_INT_RGB);

        Graphics2D g2=(Graphics2D)image.getGraphics();

        canvas.paint(g2);
        try {
            ImageIO.write(image, "png", new File("/tmp/canvas.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}