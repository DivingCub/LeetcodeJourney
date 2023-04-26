class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> tem = new ArrayList<String>();

        for(int i=1;i<=n;i++){

            StringBuffer sbTem = new StringBuffer();

            if(i%3==0){
                sbTem.append("Fizz");
            }
            if(i%5==0){
                sbTem.append("Buzz");
            }
            if(sbTem.length()==0){
                sbTem.append(i);
            }
            tem.add(sbTem.toString());
        }
        return tem;
    }
}