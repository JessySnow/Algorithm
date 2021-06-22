public class Main {
    public static void getResult(String A, String B) {
        if(A.equals(B)) {
            System.out.println(0);
            return;
        }

        //创建更新表，首位填充空字符串
        int[][] update_table = new int[A.length() + 1][B.length() + 1];

        //初始化更新表
        for(int i = 1;i <= A.length();i++)
            update_table[i][0] = i;
        for(int j = 1;j <= B.length();j++)
            update_table[0][j] = j;

        // 根据字符之间的相等关系进行判断，并更新 更新表
        for(int i = 1;i <= A.length();i++) {
            for(int j = 1;j <= B.length();j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    update_table[i][j] = update_table[i - 1][j - 1];
                else {
                    update_table[i][j] = Math.min(update_table[i - 1][j] + 1,
                            Math.min(update_table[i][j - 1] + 1, update_table[i - 1][j - 1] + 1));
                }
            }
        }

        //输出最终的编辑距离
        System.out.println(update_table[A.length()][B.length()]);
        return;
    }
    
    public static void main(String[] args) {
        String A = "ABBBA";
        String B = "OPPPO";
        getResult(A, B);
    }
}