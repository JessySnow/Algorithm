import java.util.Scanner;
 
public class MatrixChainOrder
{
    private static int n;
    private static int[][] m = new int[100][100];
    private static int[][] s = new int[100][100];
    private static int[] p = new int[105];
    private static final int MAX = Integer.MAX_VALUE;
 
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i <= n; i++)
        {
            p[i] = scan.nextInt();
            m[i][i] = 0;
        }
 
        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = MAX;
                for (int k = i; k <= j - 1; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                    {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        print(1, n);
        System.out.printf(" %d\n", m[1][n]);
    }
 
    public static void print(int i, int j)
    {
        if (i == j)
            System.out.print("A" + i);
        else
        {
            System.out.print("(");
            print(i, s[i][j]);
            print(s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}