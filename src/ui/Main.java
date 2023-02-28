package ui;

import model.BinarySearchTree;

public class Main {

    private static BinarySearchTree bst;

    public static void main(String[] args) {
        //Por cada nodo usas el doble de memoria
        bst = new BinarySearchTree();

        bst.addNode(40);
        bst.addNode(10);
        bst.addNode(60);
        bst.addNode(1);
        bst.addNode(20);
        bst.addNode(50);
        bst.addNode(90);
        bst.addNode(80);
        bst.addNode(100);
        bst.addNode(95);
        bst.addNode(110);
        bst.addNode(70);
        bst.addNode(75);
        bst.addNode(51);
        bst.addNode(55);
        bst.addNode(85);

        String graf = bst.printGraf();

        System.out.println(graf);

        bst.deleteNode(90);
        bst.deleteNode(70);
        bst.deleteNode(1);
        
        String newGraf = bst.printGraf();

        System.out.println(newGraf);

        //System.out.println(bst.minimum().getValue());

        //System.out.println(bst.searchNode(2).getValue());

        //Node prev = bst.searchNodeByParent(3);

        //System.out.println("Prev: " + prev.getValue() + " Right: " + prev.getRight().getValue());


    }
}
