class Solution {
    public long minimumTime(int[] time, int totalTrips) {

        Arrays.sort(time);
        
        long l = time[0];
        long r = (long)time[0]*totalTrips;

        while(l<r){

            long mid = l + (r-l)/2;

            if(helper(mid,time)<totalTrips){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return r;

    }

    private long helper(long x, int[] time){

        long sum = 0;

        for(int input:time){

            sum += x/input;
        }

        return sum;

    }

}