package app.model;

import app.pointData.Point;

import java.util.ArrayList;
import java.util.List;


public class Model {
    List<Point> pointList;

    public List<Point> getPointList() {
        return pointList;
    }

    public void addPoint(Point point) {
        this.pointList.add(0, point);
    }

    public Model(){
        pointList = new ArrayList<>();
    }
}
