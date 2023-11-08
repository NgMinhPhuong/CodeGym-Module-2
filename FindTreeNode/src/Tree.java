import org.w3c.dom.Node;

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
        System.out.print(root.e + " ");
        display(root.right);
    }

    boolean remove(E e){
        TreeNode<E> run = root;
        TreeNode<E> parent = null;
        if(run == null) return false;
        if(e.compareTo(run.e) == 0) {
            root = null; return true;
        }
        while(run != null){
            if(e.compareTo(run.e) < 0){
                parent = run;
                run = run.left;
            } else if(e.compareTo(run.e) > 0){
                parent = run;
                run = run.right;
            } else{
                if(parent.left == run) parent.left = null;
                else if(parent.right == run) parent.right = null;
                return true;
            }
        }
        return false;
    }
    boolean contains(E e, TreeNode<E> root){
        if(root == null) return false;
        if(e.compareTo(root.e) < 0){
            return contains(e, root.left);
        }else if(e.compareTo(root.e) > 0){
            return contains(e, root.right);
        }else {
            return true;
        }


    }
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int [] a = {3,1,4,0,2,6};
        for(int x : a)
            tree.insert(x);
        System.out.println();
        tree.display(tree.root);
        System.out.println(tree.contains(7, tree.root));

    }
}
