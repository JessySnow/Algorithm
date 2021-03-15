package T2;

public class Floyd {
    private static final int INF = Integer.MAX_VALUE;   //用INF来代表两个点直接没有直接相连的路径
    //有向图的邻接矩阵和距离矩阵
    private static int[][] adjMatrix = {{0, 2, 6, 4},
                                        {INF, 0, 3, INF},
                                        {7, INF, 0, 1},
                                        {5, INF, 12, 0}},
                                        Distance = adjMatrix;
    public static void main(String[] args) {
        int size = adjMatrix.length;

        //Floyd核心代码
        for (int k = 0; k < size; k ++)
            for (int i = 0; i < size; i ++)
                for (int j = 0; j < size; j ++){
                    //防止溢出
                    int tmp = (Distance[i][k] == INF || Distance[k][j] == INF) ? INF : (Distance[i][k] + Distance[k][j]);
                    Distance[i][j] = Math.min(tmp, Distance[i][j]);
                }

        //输出路径矩阵
       for (int i = 0; i < size; i++)
           for (int j = 0; j < size; j ++){
               if(j != size - 1)    System.out.print(Distance[i][j] + " ");
               else                 System.out.println(Distance[i][j]);
           }
    }
}