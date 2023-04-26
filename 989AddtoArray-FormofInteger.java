class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {

        
        List<Integer> res =new ArrayList<>();
        // Deque<Integer> tem = new ArrayDeque<>();

        String s=String.valueOf(k);  
        // String s = (String) k;

        int len1 = num.length;
        int len2 = s.length();
        int index =0;
        int carry = 0;

        while(len1>0 || len2 >0 || carry!=0){

            int dig1 = len1>0 ? num[len1-1] : 0;
            int dig2 = len2>0 ? s.charAt(len2-1) - '0': 0;

            int sum = dig1 + dig2 + carry;
            res.add(sum%10);
            carry = sum/10;
    
            len1--;
            len2--;
        }
        
        // int size = tem.size();

        // while(size>0){
        //     res.add(tem.pollFirst());
        //     size--;
        // };

        Collections.reverse(res);

        return res;
        


    }
}