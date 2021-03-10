import java.util.Scanner;
import java.util.Arrays;

/*
* description: 边结构体
* start: 边的起点
* end: 边的终点
* weight: 边的权值
* */
class side implements Comparable{

    public int start, end, weight;

    side(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //将边的权重作为排序的依据
    @Override
    public int compareTo(Object o) {
        side newSIde = (side) o;
        return this.weight - newSIde.weight;
    }
}

/*
* description: 并查集
* init: 初始化父节点表,将所有父节点设置为-1
*/
class Parent {
    int length;
    int[] parents;

    public Parent(int length){
        this.length = length;
        parents = new int[length];
    }

    public void init() { Arrays.fill(parents, -1); }

    /*
    * description: 查找某个节点的根节点
    * */
    private int find_root(int p1){
        int p1_root = p1;
        while (parents[p1_root] != -1){ p1_root = parents[p1_root]; }
        return p1_root;
    }

    /*
    * description: 合并两个集合
    * */
    public boolean unify(int p1, int p2){
        int p1_root = find_root(p1);
        int p2_root = find_root(p2);
        if(p1_root != p2_root) {
            parents[p1_root] = p2_root;
            return true;
        }
        return false;
    }
}

public class Kruskal {
    public static void main(String[] args) {
        int sideNum, start, end, weight, pNum;
        Parent parents;     //并查集
        side[] sides;       //边结构体数组
        Scanner keyIn = new Scanner(System.in);

        //输入边的数目和顶点的数目
        System.out.println("输入边的个数和顶点数");
        sideNum = keyIn.nextInt();      //边数
        pNum = keyIn.nextInt();         //顶点数


        //初始化或填充数组;初始化并查集
        sides = new side[sideNum];
        System.out.println("输入边的起点和终点及其权值");
        for(int i = 0; i <sideNum; i ++){       //循环填充sides数组
            start = keyIn.nextInt();
            end = keyIn.nextInt();
            weight = keyIn.nextInt();
            sides[i] = new side(start, end, weight);
        }
        parents = new Parent(pNum);             //并查集初始化，所有父节点均设为-1
        parents.init();

        //对边的结构体数组进行排序
        Arrays.sort(sides);
        //Test
//        for(side len:sides) System.out.print(len.weight + "  ");
//        System.out.println();

        //使用并查集选择边是否加入最小生成树中
        for(int i = 0; i < sideNum; i ++){
            int startP = sides[i].start;
            int endP   = sides[i].end;
            if(parents.unify(startP, endP)) System.out.println(startP + "----" + endP);
        }
    }
}


/*
* description: 样例，前两个数字为顶点，后一个数字为边的权值
* 本样例一共12条边
* */
/*
0 1 12
0 5 16
0 6 14
1 5 7
1 2 10
2 5 6
2 4 5
2 3 3
3 4 4
4 5 2
4 6 8
5 6 9
 */