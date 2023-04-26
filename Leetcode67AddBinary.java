class Solution {
    public String addBinary(String a, String b) {
        
        StringBuffer sb = new StringBuffer();
        int i = a.length()-1;
        int j = b.length() -1;
        int carry =0;

        while(i>=0 || j>=0|| carry >=1){

            int digA = i>=0 ? a.charAt(i) - '0' : 0;
            int digB = j>=0 ? b.charAt(j) - '0' : 0;
            int sum = carry + digA + digB;
            
            carry = sum>=2? 1: 0;
            sum = sum>=2 ? sum-2: sum;
            sb.append(sum);

            i--;
            j--;                   

        }

       return sb.reverse().toString();
    }
}