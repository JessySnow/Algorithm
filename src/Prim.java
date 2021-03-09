import java.util.Scanner;

/*
* description: 定义邻接矩阵表示图
* Vertex: 点集
* Matrix: 邻接矩阵
* INF: 权值比较初始值
* */
class AdjMatrix{
    char[] Vertex;
    int[][] Matrix;
    final int INF = Integer.MAX_VALUE;
}

public class Prim {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        AdjMatrix adm = new AdjMatrix();
        int size;
        int lenght = 0;
        char[] prim;
        int[] weight;
        int[] accessed;

        //初始化数组
        System.out.println("输入顶点的个数");
        size = keyIn.nextInt();
        int index = 0;
        final int SP = 0;
        prim = new char[size];
        weight = new int[size];
        adm.Vertex = new char[size];
        adm.Matrix = new int[size][size];

        //输入数组
        System.out.println("输入顶点");
        String black = keyIn.nextLine();
        String line = keyIn.nextLine();
        for (int i = 0; i < line.length(); i++) adm.Vertex[i] = line.charAt(i);

        //输入邻接矩阵
        System.out.println("输入邻接矩阵");
        for (int i = 0; i < size; i ++)
            for (int j = 0; j < size; j ++){
                adm.Matrix[i][j] = keyIn.nextInt();
                if(i != j && adm.Matrix[i][j] == 0) adm.Matrix[i][j] = adm.INF;
            }

        //选定出发顶点(默认第一个),初始化权值数组
        prim[index ++] = adm.Vertex[SP];
        System.arraycopy(adm.Matrix[SP], 0, weight, 0, size);
        weight[SP] = 0;   //无圈图设定自身到自身的距离为0;

        for (int i = 0; i < size; i ++){
            if(i == SP)   continue;   //跳过出发的节点
            int  j = 0, k = 0, min = adm.INF;

            for (j = 0; j < size; j ++)
                if(weight[j] != 0 && weight[j] < min){
                    min = weight[j];
                    k = j;
                }

            prim[index++] = adm.Vertex[k];
            weight[k] = 0;

            for (j = 0; j < size; j ++)
                if(weight[j] != 0 && adm.Matrix[k][j] < weight[j])
                    weight[j] = adm.Matrix[k][j];
        }

        //输出对应的最小生成树序列
        System.out.println("从 " + adm.Vertex[SP] + " 出发的最小生成树对应序列如下:");
        for (int i = 0; i < size; i++)  System.out.print(prim[i]);
    }
}
