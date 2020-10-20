package app.pointData;

import java.util.Objects;

public class Point implements java.io.Serializable {
    private Double x;
    private Double y;
    private Double r;
    private String res;

    public void setX(Double x) {
        this.x = x;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setRes() {
        this.res = checkPoint();
    }

    public Double getR() {
        return r;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public String getRes(){
        return res;
   }

    @Override
    public String toString() {
        return "<tr>"+"<td>"+x.toString()+"</td>"+"<td>"+y.toString()+"</td>"+"<td>"+r.toString()+"</td>"+"<td>"+res.toString()+"</td>"+"</tr>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y) &&
                Objects.equals(r, point.r) &&
                Objects.equals(res, point.res);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, res);
    }

    public String checkPoint(){
        if((x*x + y*y <= r*r && x <= 0 && y <= 0) ||
                (y+x <= r && x>=0 && y>=0) ||
                (x<=0 && y>=0 && y<=r && x>=-r)){
            return   "Входит";
        }else{
            return "Не входит";
        }
    }
}