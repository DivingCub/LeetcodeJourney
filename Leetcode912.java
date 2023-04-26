class Solution {
    public int[] sortArray(int[] nums) {
        
        
        int len = nums.length;

        if(len<=1) return nums;

        Queue<Integer> pq = new PriorityQueue<>((x1,x2)->{ return x1-x2; });

        for(int x:nums) pq.offer(x);
        int size = pq.size(); int index =0;
        for(int i=0;i<size;i++) nums[index++] = pq.poll();
        return nums;

    }
}

//divide and conquer

public class Solution {
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < k; p++) {
            nums[left + p] = temp[p];
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}