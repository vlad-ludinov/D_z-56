import tree.RedBlackTree;


public class Main {
    
    public static void main(String[] args) {
        
        RedBlackTree tree = new RedBlackTree();

        tree.add(10);
        System.out.println(tree);
        tree.add(9);
        tree.add(3);
        System.out.println(tree);
        tree.add(20);
        tree.add(17);
        tree.add(21);
        tree.add(23);
        System.out.println(tree);
        tree.add(30);
        tree.add(16);
        tree.add(19);
        tree.add(18);
        tree.add(24);
        System.out.println(tree);


    }
}
