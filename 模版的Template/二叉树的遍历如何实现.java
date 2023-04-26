//前序遍历

public static void PreOrderRecur(TreeNode root){
    if(root == null) return;
    System.out.println(root.data);
    PreorderRecur(root.left);
    PreorderRecur(root.right);
}

//Or
static List<Interger> PreOrderTraversal(TreeNode root){
    List(Interger) result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();
    if(root == null) return result;
    stack.push(root);//首先把根节点放入栈中
    while(!stack.isEmpty(){
    //当栈中不为空的时候，执行以下操作
    TreeNode temp = stack.pop();//取出栈中的节点，用一个临时变量保存
    result.add(temp.val);//将变量的值加入结果队列中
    if(tmp.right!=null)
        stack.push(root.right);//如果该节点的右⼦树不为空，则把有节点放⼊栈
    if(tmp.left!=null)
        stack.push(root.left);//如果该节点的左⼦树不为空，则把左⼦树放⼊栈中。
        }
    return result;
}
    
    





//中序遍历
public static void InOrderRecur(TreeNode root){
    if(root == null) return;
    InorderRecur(root.left);
    System.out.println(root.data);
    InorderRecur(root.right);
}

//Or

public List<Integer> InOrderTraversal(TreeNode root){
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.isEmpty())
    {
        if(root != null){
            stack.push(root);
            root=root.left;
        }
        else{
            root = stack.pop();
            res.add(root.data);
            root=root.right;
        
        }
    }
    return res;
}




//后序遍历
public static void PostOrderRecur(TreeNode root){
    if(root == null) return;
    PostorderRecur(root.left);
    PostorderRecur(root.right);
    System.out.println(root.data);
}


