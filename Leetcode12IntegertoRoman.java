//使用模拟的写法来进行：

class Solution {
    public String intToRoman(int num) {

        StringBuffer sb = new StringBuffer();

        if(num >= 1000){
            sb.append("M".repeat(num/1000));
            num %= 1000;
        }

        if(num/100 ==9){
            sb.append("CM");
            num %= 900;
        }

        if(num/100 >= 5){
            sb.append("D");
            num %= 500;
        }

        if(num/100 ==4){
            sb.append("CD");
            num %= 400;
        }

        if(num/100 >=0){
            sb.append("C".repeat(num/100));
            num %= 100;
        }

        //10 -99 部分

        if(num/10 ==9){
            sb.append("XC");
            num %= 90;
        }

        if(num/10 >=5){
            sb.append("L");
            num %= 50;
        }

        if(num / 10 ==4){
            sb.append("XL");
            num %= 40;
        }

        if(num /10 >0){
            sb.append("X".repeat(num/10));
            num %= 10;
        }
        //个位数 0 - 9 的部分
        if(num ==9){
            sb.append("IX");
            num %= 9;
        }

        if(num >=5){
            sb.append("V");
            num %= 5;
        }

        if(num ==4){
            sb.append("IV");
            num %= 4;
        }

        if(num >=1){
            sb.append("I".repeat(num/1));
            num %= 1;
        }


        return sb.toString();
    }
}

// 使用贪心的方法来进行：

class Solution {

    private static final int[] values = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 ,5, 4,1
    };

    private static final String[] symbols = {
        "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV", "I"
    };


    public String intToRoman(int num) {

        StringBuffer sb = new StringBuffer();
        
        int index = 0;
        
        while(num >0){

            int k = num / values[index];

            for(int i=0;i<k;i++){
                sb.append(symbols[index]);
                num -= values[index];
            }

            index++;

        }
        
        return sb.toString();

    }
}














//其他答案参考

// 哈希表解法
class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}

// 字典法
class Solution {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}