var isAnagram = function(s, t) {

    if(s.length != t.length) return false;
    const res = new Array(26).fill(0);
    const base = "a".charCodeAt();


    for(const i of s){
        res[i.charCodeAt() - base] ++;
    }
    for(const i of t){
        if(!res[i.charCodeAt() - base]) return false;
        res[i.charCodeAt()- base] --;
    }
    return res.every(i => i===0);
};