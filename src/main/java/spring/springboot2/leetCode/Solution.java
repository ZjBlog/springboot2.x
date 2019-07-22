package spring.springboot2.leetCode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

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
    public static List<Integer> postorderTraversal(TreeNode root) {
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

        System.out.println(postorderTraversal(treeNode));

    }


    public  static  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null){
            return lists;
        }

        Queue<TreeNode> queue=new LinkedList();
        Queue<TreeNode> queue1=new LinkedList();
        queue.add(root);

        List<Integer> list=new ArrayList<>();
        TreeNode curr=null;
        while (!queue.isEmpty()){
            curr=queue.poll();
            list.add(curr.val);

            if(curr.left!=null){
                queue1.add(curr.left);
            }
            if(curr.right!=null){
                queue1.add(curr.right);
            }

            if(queue.isEmpty()){
                lists.add(list);
                queue.addAll(queue1);
                queue1.clear();
                list=new ArrayList<>();
            }

        }
        return lists;
    }



    public static  void levelOrder(TreeNode root, List<List<Integer>> list, int level){
        if(root != null){
            if(level > list.size() - 1){
                List<Integer> nodes = new ArrayList<>();
                list.add(nodes);
            }
            list.get(level).add(root.val);
            levelOrder(root.left, list, level + 1);
            levelOrder(root.right, list, level + 1);
        }
    }
    public static void main2(String[] args) {
        TreeNode treeNode = new TreeNode(3);

        TreeNode t1 = new TreeNode(9);

        TreeNode t2 = new TreeNode(20);


        TreeNode t3 = new TreeNode(15);

        TreeNode t4 = new TreeNode(7);

        t2.left=t3;
        t2.right=t4;
        treeNode.left=t1;
        treeNode.right=t2;

        List<List<Integer>> lists = levelOrder(treeNode);

        System.out.println(lists);



        List<List<Integer>> list = new ArrayList<>();
        levelOrder(treeNode, list, 0);

        System.out.println(list);
    }
}
