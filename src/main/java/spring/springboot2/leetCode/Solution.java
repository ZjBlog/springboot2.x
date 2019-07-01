package spring.springboot2.leetCode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ZJ
 * @date : 19-6-28 下午1:46
 */
public class Solution {

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        preorder(root, list);
        return list;
    }

    public static void preorder(TreeNode root, List list) {
        if (root != null) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            /**
             * 栈先进后出 所以 先把右 放进去 然后 在左  出来时  zuo - you
             */
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }


        return list;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }


        return list;
    }


    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }//和传统先序遍历不一样，先将左结点入栈
            if (node.right != null) {
                stack.push(node.right);
            }//后将右结点入栈
            res.add(0, node.val);                        //逆序添加结点值
        }
        return res;
    }

    public static void preorder1(TreeNode root, List list) {
        if (root != null) {
            preorder1(root.left, list);
            list.add(root.val);
            preorder1(root.right, list);
        }
    }


    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorder2(root, list);
        return list;
    }

    public static void preorder2(TreeNode root, List list) {
        if (root != null) {
            preorder2(root.left, list);
            preorder2(root.right, list);
            list.add(root.val);
        }
    }

    public static void main1(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        t1.left = t2;
        treeNode.right = t1;

        System.out.println(postorderTraversal2(treeNode));

    }
}
