class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){

                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }

            }
        }

        return uf.size;

        
    }


    class UnionFind{

        int[] roots;
        int size;

        public UnionFind(int n){

            roots = new int[n];

            for(int i=0;i<n;i++){

                roots[i] = i;

            }

            size = n;
        }

        public int find(int i){

            if(roots[i] == i ){
                return i;
            }

            return roots[i] = find(roots[i]);

        }


        public void union(int p,int q){

            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot!=qRoot) {
                roots[pRoot] = qRoot;
                size--;
            }
        }
    }


}