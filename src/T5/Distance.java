package T5;
import java.util.*;

//Sample
class Point{
    public int x, y;

    //Init a point
    Point(){
        double xp = Math.random();  double yp = Math.random();
        this.x = (int)(xp*100);     this.y = (int)(yp*100);
    }
}

//Algorithm
class Solve{

    private static double distance(Point p1, Point p2){ return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)); }
    public static void preSort(Point[] PointArray){
        Arrays.sort(PointArray, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (o1.x > o2.x)?1:0;
            }
        });
    }

    static double solve(Point[] PointArray, int left, int right){
        double minDis = Double.MAX_VALUE;
        if(left == right)   return minDis;
        if(left + 1 == right)   return distance(PointArray[left], PointArray[right]);

        int middle = (left + right) / 2;
        double leftMinDis = solve(PointArray, left, middle);
        double rightMinDis = solve(PointArray, middle, right);

        minDis = Math.min(leftMinDis, rightMinDis);

        List<Integer> PINDEX = new ArrayList<>();
        for(int i = left; i <= right; i ++) if(Math.abs(PointArray[middle].x - PointArray[i].x) < minDis)   PINDEX.add(i);

        for (int i = 0; i < PINDEX.size(); i ++){
            for (int j = i  + 1; j < PINDEX.size(); j ++){
                if(Math.abs(PointArray[PINDEX.get(j)].y - PointArray[PINDEX.get(i)].y) > minDis) continue;

                double tempDis = distance(PointArray[PINDEX.get(i)], PointArray[PINDEX.get(j)]);

                minDis = Math.min(tempDis, minDis);
            }
        }

        return minDis;
    }
}

public class Distance {
    public static void main(String[] args) {
        //Create&Init sample;
        Point[] PointArray = new Point[100];
        for(int i = 0; i < 100; i ++)   PointArray[i] = new Point();
        Solve.preSort(PointArray);

        double minDis = Solve.solve(PointArray, 0, PointArray.length - 1 );
        System.out.println(minDis);
    }
}