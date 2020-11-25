import java.awt.*;

public abstract class Junction implements Component {
    protected final int x;
    protected final int y;

    public Junction(int row, int column) {
        this.x = (int) ((column + 0.5) * Grid.CELL_SIZE) + Grid.GRID_LEFT_OFFSET - Grid.GRID_JUNCTION_RADIUS;
        this.y = (int) ((row + 0.5) * Grid.CELL_SIZE) + Grid.GRID_TOP_OFFSET - Grid.GRID_JUNCTION_RADIUS;
    }
}
