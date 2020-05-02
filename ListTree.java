import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void preorderTraversal(TreeNode root) {
        //给定一个二叉树，返回它的 前序 遍历（非递归）（非递归 写 递归 要用 栈）

        //1.创建一个栈。初始情况下，把根节点入栈
        //2.进入循环
        // a.取栈顶元素（出栈）
        // b.访问该元素
        // c.若该元素的右子树不为空，就入栈;
        //   若该元素的左子树不为空，也入栈;
        //   当栈为空时，遍历完成

        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();//创建一个栈
        stack.push(root);//根节点
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();//取出栈顶元素
            System.out.print(top.val + " ");//输出栈顶元素
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }
    //用 List 写非递归的先序遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();//创建一个栈
        stack.push(root);//根节点
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();//取出栈顶元素
            //System.out.print(top.val + " ");//输出栈顶元素
            list.add(Integer.valueOf(top.val));
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
        return list;
    }

    public void inorderTraversal(TreeNode root) {
        //给定一个二叉树，返回它的 中序 遍历(非递归)
        //1.创建一个栈
        //2.设定一个 cur 引用从 root 出发
        //  只要 cur 不为空，就把 cur 入栈 同时 cur 往左移动
        //  cur 为空（此时的栈顶元素就是当前的最左侧元素），出栈并访问栈顶元素
        //3.让 cur 指向刚才被访问的节点的右子树，循环执行 1 2 步骤

        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();//创建一个栈
        TreeNode cur = root;
        while(true) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();//取出栈顶元素
            System.out.print(top.val + " ");//输出栈顶元素
            cur = top.right;
        }
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        //用 List 写非递归的中序遍历
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();//创建一个栈
        TreeNode cur = root;
        while(true) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();//取出栈顶元素
            list.add(top.val);
            cur = top.right;
        }
        return list;
    }

    public void postorderTraversal(TreeNode root) {
        //1. 创建一个栈
        //2. 创建 cur 从 root 出发
        //   只要 cur 不为空，就把 cur 入栈 同时 cur 往左移动
        //   cur 为空，取栈顶元素，判断能不能访问
        //     a.栈顶元素右子树为 null 时可以访问
        //     b.栈顶元素右子树已被访问过 可以访问(创建 prev 变量判断)
        //栈顶元素可被访问，出栈; 否则还得在栈里
        //3.若栈顶元素不满足访问条件，则让 cur 从栈顶元素右子树出发，继续进行 1 2

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();//创建一个栈
        TreeNode cur = root;
        TreeNode prev = null;//初始情况下没有任何节点被访问过
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();//取出栈顶元素, 开始判断
            if(top.right == null || top.right == prev) {
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }
    public List<Integer> postorderTraversal1(TreeNode root) {
        ////用 List 写非递归的 后序 遍历
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();//创建一个栈
        TreeNode cur = root;
        TreeNode prev = null;//初始情况下没有任何节点被访问过
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();//取出栈顶元素, 开始判断
            if(top.right == null || top.right == prev) {
                list.add(top.val);
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
        return list;
    }
}
