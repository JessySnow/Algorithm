class Point{
    public int x, y, id;

    public boolean comp_x(){
        return true;
    }

    public boolean comp_y(){
        return true;
    }

    private double calculate(Point p1, Point p2){
        double distance = Math.sqrt( Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return distance;
    }

    public void update(Point p1, Point p2, double min){   
        double distance = calculate(p1, p2);
        if(distance < min) min = distance;
    }

}
public class Distance{
    public static void main(String[] args) {
        int MIN = Integer.MAX_VALUE;
        System.out.println(MIN);
    }
}