/**
 * 二叉搜索树Java实现类
 * @param <E> 泛型
 */
public class BST<E extends Comparable<E>> {

    /**
     * 节点内部类
     */
    public class Node {

        /**
         * 数据
         */
        private E e;
        /**
         * 左孩子和右孩子
         */
        private Node left, right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;
    /**
     * 二叉树的大小
     */
    private int size;

    public BST(E e) {
        this.root = new Node(e);
        this.size = 0;
    }

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 二分搜索树新增操作（递归操作）
     * @param e 新加入的data值
     */
    public void add(E e) {
        root = add(e, root);
    }
    private Node add(E e, Node node) {
        /**
         * 如果node==null只有两种情况：
         * 1.BST根节点为null，这是第一次新增数据
         * 2.找到了e应该放入的孩子节点
        */
        if(node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = this.add(e, node.left);
        } else if(e.compareTo(node.e) > 0) {
            node.right = this.add(e, node.right);
        }
        return node;
    }

    /**
     * 二叉搜索树新增（循环操作）
     * @param e
     */
//    public void add(E e) {
//        Node node = root;
//        while (true) {
//            if(e == null) {
//                node = new Node(e);
//                return;
//            }
//            if(e.compareTo(node.e) == 0) {
//                return;
//            }
//            if(e.compareTo(node.e) < 0) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//    }

    /**
     * 二叉搜索树搜索递归操作
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.compareTo(node.e) == 0) {
            return true;
        }
        if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二叉搜索树搜索循环操作
     * @param e
     * @return
     */
//    public boolean contains(E e) {
//        Node node = root;
//        while (true) {
//            if(node == null) {
//                return false;
//            }
//            if(e.equals(node.e)) {
//                return true;
//            }
//            if(e.compareTo(node.e) < 0) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
}
