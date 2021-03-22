package T3;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);

        //生成一个数组
        int MAX = 10000000;
        int[] array = new int[MAX];
        for (int i = 0; i < MAX; i ++) array[i] = (int)(Math.random()*MAX);
        Arrays.sort(array); //使数组有序

        int seek, seekIndex = -1;
        int middle, left = 0, right = MAX - 1;

        System.out.println("输入需要查找的数:");
        seek = keyIn.nextInt();

        while (left <= right){
            middle = left + right >> 1;
            if(array[middle] > seek)         right = middle - 1;
            else if(array[middle] < seek)    left = middle + 1;
            else{ seekIndex = middle; break; }
        }

        if(seekIndex != -1)    System.out.println("在数组中的下标位置是：" + seekIndex);
        else                   System.out.println("不在数组中");

        keyIn.close();
    }
}
