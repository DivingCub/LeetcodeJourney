class Solution {
    public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        // 左括号入栈  -- 把左右边动作给弄出来， 那天做什么事情，标明
        if (c == '(' || c == '{' || c == '[') stack.push(c);
        // 右括号
        else {
            // 栈不空且匹配，弹出栈顶元素
            if (!stack.isEmpty() && getLeft(c) == stack.peek()) stack.pop();
            else return false;
        }
    }
    return stack.isEmpty();
}
// 根据右括号返回对应的左括号
private char getLeft(char c) {
    if (c == ')') return '(';
    if (c == '}') return '{';
    return '[';
}
}