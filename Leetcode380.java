class RandomizedSet {

    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;
        int size = list.size();
        map.put(val,size);
        list.add(val);
        return true;
        //check 是否有也已经存在
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int tem = list.get(list.size()-1);
        list.set(index,tem);
        map.put(tem,index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
    
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */