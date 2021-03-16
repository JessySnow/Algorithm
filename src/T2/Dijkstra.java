package T2;

/*
* description:求从点a到点h的最短距离
* */
public class Dijkstra{
    private static int INF = Integer.MAX_VALUE;
    private static int[][] Matrix= {
            {0, 1, INF, INF, INF, INF, INF, INF},
            {INF, 0, INF, 2, INF, INF, INF, INF},
            {2, INF, 0, INF, INF, INF, INF, INF},
            {INF, INF, 1, 0, INF, 8, INF, INF},
            {INF, INF, INF, 2, 0, INF, 2, INF},
            {INF, INF, INF, INF, 2, 0, INF, INF},
            {INF, INF, INF, INF, INF, 3, 0, 3},
            {INF, INF, INF, INF, INF, 2, INF, 0}
    };
    public static void main(String[] args) {
        int size = Matrix.length;
        int startP = 0;
        int endP = 7;
        int[] shortest = new int[size];     //最短距离数组
        int[] visited = new int[size];      //已经访问的数组

        //初始化数组
        shortest[startP] = 0;
        visited[startP] = 1;

        //Dijkstra算法代码
        for (int i = 1; i < size; i ++){
            int k = -1;
            int min = INF;

            //从未访问的节点中选出距离当前节点距离最短的节点
            for (int j = 1; j < size; j ++)
                if (visited[j] == 0 && Matrix[startP][j] < min){
                    min = Matrix[startP][j];
                    k = j;
                }

            //更新访问数组和最短距离数组
            visited[k] = 1;
            shortest[k] = min;


            //更新从起始点开始的距离表
            for (int index = 1; index < size; index ++){
                if (visited[index] == 0){
                    //防止数据溢出
                    int tmpLength = (Matrix[startP][k] == INF || Matrix[k][index] == INF) ? INF:Matrix[startP][k] + Matrix[k][index];
                    Matrix[startP][index] = Math.min(tmpLength, Matrix[startP][index]);
                }
            }
        }

        System.out.println("从a到h的最短路径为：" + shortest[endP]);
    }
}