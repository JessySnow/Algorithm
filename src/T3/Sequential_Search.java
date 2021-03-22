package T3;

import java.util.Arrays;
import java.util.Scanner;

public class Sequential_Search {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);

        //生成一个数组
        int MAX = 10000000;
        int[] array = new int[MAX];
        for (int i = 0; i < MAX; i ++) array[i] = (int)(Math.random()*MAX);
        Arrays.sort(array);

        int seek, seekIndex = -1;
        int middle, left = 0, right = MAX - 1;

        System.out.println("输入需要查找的数:");
        seek = keyIn.nextInt();

        for (int i = 0; i < MAX; i ++){
            if(array[i] == seek){
                seekIndex = i;
                break;
            }
        }

        if(seekIndex == -1) System.out.println("未找到该数.");
        else                System.out.println("该数的下标为:" + seekIndex);
    }
}
