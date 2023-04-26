class Solution {
    public int evalRPN(String[] tokens) {

        int len = tokens.length;

        Deque<Integer> dq = new ArrayDeque<>();


        for(int i=0;i<len;i++){

            String tem = tokens[i];

            if( tem.equals("+") || tem.equals("-")||tem.equals("/") || tem.equals("*")){
                int num2 = dq.pollLast();
                int num1 = dq.pollLast();

                if(tem.equals("+")){
                    int addResult = num1+num2;
                    dq.addLast(addResult);
                }else if(tem.equals("-")){
                    dq.addLast(num1-num2);
                }else if(tem.equals("*")){
                    dq.addLast(num1*num2);
                }else{
                    dq.addLast(num1/num2);
                }
            }else{
                int num = Integer.valueOf(tem);
                dq.addLast(num);
            }
        }

        return dq.size()==1 ? dq.pollLast():-1;
    }
}