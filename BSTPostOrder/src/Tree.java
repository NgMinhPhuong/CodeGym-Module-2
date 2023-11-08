public class Tree<E extends Comparable<E>> {
    private int size = 0;
    TreeNode<E> root;
    Tree(){}

    TreeNode<E> createNode(E e){
        return new TreeNode<>(e);
    }
    boolean insert(E e){
        if(root == null)
            root = createNode(e);
        else{
            TreeNode<E> parent = root;
            TreeNode<E> run = root;
            while(run != null)
            {
                if(e.compareTo(run.e) < 0){
                    parent = run;
                    run = run.left;
                } else if(e.compareTo(run.e) > 0){
                    parent = run;
                    run = run.right;
                } else{
                    return false;
                }
            }
            if(e.compareTo(parent.e) < 0){
                parent.left = createNode(e);
            } else {
                parent.right = createNode(e);
            }
        }
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }

    public void display(TreeNode<E> root){
        if(root == null){
            return;
        }
        display(root.left);
        System.out.println(root.e + " ");
        display(root.right);
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int [] a = {3,1,4,0,2,6};
        for(int x : a)
            tree.insert(x);
        tree.display(tree.root);
    }
}
