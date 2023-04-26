//自己最基本的写法

class TwoSum {

    List<Integer> list;

    public TwoSum() {
        this.list = new ArrayList<>();        
    }
    
    public void add(int number) {

        list.add(number);
        
    }
    
    public boolean find(int value) {

        int[] tem = new int[list.size()];

        int index = 0;
        for( ; index < list.size();index++ ){
            tem[index] = list.get(index);
        }

        int le = 0;
        int ri = tem.length-1;
        Arrays.sort(tem);

        while(le<ri){

            int sum = tem[le] + tem[ri];

            if(sum == value){
                return true;
            }else if(sum < value){
                le++;
            }else{
                ri--;
            }          

        }

        return false; 
    }
}

//熟练使用了 Collections.sort(Arraylist)的方法之后采用的方法
//直接使用参考答案 
import java.util.Collections;

class TwoSum {
  private ArrayList<Integer> nums;
  private boolean is_sorted;

  /** Initialize your data structure here. */
  public TwoSum() {
    this.nums = new ArrayList<Integer>();
    this.is_sorted = false;
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    this.nums.add(number);
    this.is_sorted = false;
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    if (!this.is_sorted) {
      Collections.sort(this.nums);
      this.is_sorted = true;
    }
    int low = 0, high = this.nums.size() - 1;
    while (low < high) {
      int twosum = this.nums.get(low) + this.nums.get(high);
      if (twosum < value)
        low += 1;
      else if (twosum > value)
        high -= 1;
      else
        return true;
    }
    return false;
  }
}

//使用HashMap来进行操作时候，自己想打能做的事情

class TwoSum {

    Map<Integer,Integer> map ;    

    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number,map.getOrDefault(number,0)+1);
    }
    
    public boolean find(int value) {

        for(Map.Entry<Integer,Integer> entry: this.map.entrySet()){

            int compli = value - entry.getKey();

            if(compli!= entry.getKey()){
                if(map.containsKey(compli)){
                    return true;
                }else{
                    continue;
                }
            }else{
                if(entry.getValue()>1) return true;
            }
        }
        return false;       
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

