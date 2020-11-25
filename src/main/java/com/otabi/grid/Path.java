package com.otabi.grid;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Path implements Component {
    private final ArrayList<Segment> segments = new ArrayList<>();

    public Path(List<Point> points) {
        this(points, false);
    }

    public Path(List<Point> points, boolean optimal) {
        for (int i = 0; i < points.size() - 1; i++) {
            segments.add(new Segment(points.get(i), points.get(i+1)));
        }
        if (optimal) setOptimal();
    }

    public void paint(Graphics g) {
        segments.forEach(segment -> segment.paint(g));
    }

    public void setOptimal() {
        segments.forEach(Segment::setOptimal);
    }
}
