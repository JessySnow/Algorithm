public class MergeSort {
    public static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int s1 = left, s2 = mid + 1, index = 0;
        while (s1 <= mid && s2 <= right){
            if(array[s1]  <= array[s2]) temp[index ++] = array[s1 ++];
            else                        temp[index ++] = array[s2 ++];
        }
        while (s1 <= mid)   temp[index ++] = array[s1 ++];
        while (s2 <= right) temp[index ++] = array[s2 ++];

        for(int i = 0; i < temp.length; i ++) array[i + left] = temp[i];
    }

        public static void mergesort(int[] array, int start, int end){
        if(start >= end)   return;
        int mid = (start + end) >>> 1;
        mergesort(array, start, mid);
        mergesort(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    public static void main(String[] args) {
        int[] arrayDemo = {21, 34, 324, 32, 12, 45, 56, 1234, 3, 45, 4, 2, 34, 12, 6, 78, 56, 34, 98, 456};
        mergesort(arrayDemo, 0, arrayDemo.length - 1);
        for(int i = 0; i < arrayDemo.length; i ++)  System.out.print(arrayDemo[i] + " ");
    }
}