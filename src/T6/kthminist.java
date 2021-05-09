public class kthminist{
    public static int find_kth_minist(int[] nums, int k){
        return findkthminist(nums, 0, nums.length, k);
    }

    private static int findkthminist(int[] nums, int start, int end, int k){

        int pivoindex = start;
        for(int index = start; index < end; index ++){
            if(nums[index] < nums[pivoindex]){
                int pivot = nums[pivoindex];
                nums[pivoindex] =  nums[index];
                nums[index] = nums[pivoindex + 1];
                nums[pivoindex + 1] = pivot;
                pivoindex ++;
            }
        }

        if(nums.length - pivoindex == k) return nums[pivoindex];
        else if(nums.length - pivoindex > k) return findkthminist(nums, pivoindex + 1, end, k);
        else return findkthminist(nums, start, pivoindex, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 45, 2, 32, 23, 65, 1, 54};
        int k = 1;
        int ans = find_kth_minist(nums, k);
        System.out.println(ans);
    }
}