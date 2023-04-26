function addDigits(num: number): number {
    while(num >= 10){
        num = addNums(num);
    }
    return num;

    //将各位数相加的结果
    function addNums(num:number){
        let str:string = num.toString();
        let sum:number = 0;
        for(let i=0,len=str.length; i<len; i++){
            sum += Number(str[i]);
        }
        return sum;
    }
};