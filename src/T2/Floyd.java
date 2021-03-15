package T2;
import java.util.Scanner;
/*
* description: 定义距离矩阵
* */
class disMatrix{
    public int size;
    public int[][] weight;
    private final int INF = Integer.MAX_VALUE;
    public void trans(int[][] Matrix, int size){
        for(int i = 0; i < size; i ++)
            for(int j = 0; j < size; j ++)
                if(Matrix[i][j] == 0 && i != j) Matrix[i][j] = INF;
    }
}

public class Floyd {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        disMatrix diM = new disMatrix();
        System.out.println("输入点的个数");
        diM.size = keyIn.nextInt();
        diM.weight = new int[diM.size][diM.size];
        int[][] distanceM = new int[diM.size][diM.size];

        System.out.println("输入权值矩阵，不相连的用0代替");
        for (int i = 0; i < diM.size; i ++)
            for (int j = 0; j < diM.size; j ++)
                diM.weight[i][j] = keyIn.nextInt();
        diM.trans(diM.weight, diM.size);

        for (int k = 0; k < diM.size; k ++)
            for (int i = 0; i < diM.size; i ++)
                for (int j = 0; j < diM.size; j ++)
                    distanceM[i][j] = Math.min(diM.weight[i][j], diM.weight[j][k] + diM.weight[k][j]);

        for (int i = 0; i < diM.size; i ++)
            for (int j = 0; j < diM.size; j ++)
                if(j != diM.size - 1) System.out.print(distanceM[i][j] + " ");
                else                  System.out.println(distanceM[i][j]);
    }
}

/*
* 输入样例:距离矩阵
* 节点： 1， 2， 3， 4*/
/*
0 2 6 4
0 0 3 0
6 0 0 1
5 0 12 0
* */

/*
输出：距离矩阵
* */
