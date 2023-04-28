function minEatingSpeed(piles: number[], h: number): number {

    

    let le = 1;
    let rig = Math.max(...piles);

    while(le<rig){

        let mid = le + Math.floor((rig -le)/2);

        if(checkPoint(piles,mid)>h){
            le = mid +1;
        }else{
            rig = mid;
        }
    }
    
    return le;


    function checkPoint(piles: number[], speed: number):number{
        let time = 0;
        for(const pile of piles){
            time += Math.ceil(pile / speed);
        }
        return time;
    }


};