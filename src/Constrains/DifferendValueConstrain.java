package Constrains;

import Problem.Node;


public class DifferendValueConstrain implements IConstrain {

    private Node firstNode;
    private Node secondNode;

    public DifferendValueConstrain(Node firstNode, Node secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }

    @Override
    public boolean isFulFilled() {
        //System.out.print("fulfilled(Constrains.DifferendValueConstrain)"+firstNode.getValue()+"; "+secondNode.getValue() +"  ");
        if(firstNode.getValue()==-1 ||secondNode.getValue()==-1){
            //System.out.println("true");
            return true;
        }

        if(firstNode.getValue()==secondNode.getValue()){
            //System.out.println("false");
            return false;
        }
        //System.out.println("true");
        return true;
    }
    public Node getSecondNode() {
        return secondNode;
    }
    public Node getFirstNode() {
        return firstNode;
    }
}
