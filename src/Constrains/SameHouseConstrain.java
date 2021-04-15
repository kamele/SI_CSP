package Constrains;

import Constrains.IConstrain;
import Problem.Node;

public class SameHouseConstrain implements IConstrain {

    private Node firstNode;
    private Node secondNode;

    public SameHouseConstrain(Node firstNode, Node secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }

    @Override
    public boolean isFulFilled() {
        //System.out.print("fulfilled(Constrains.SameHouseConstrain) "+firstNode.getValue()+"; "+secondNode.getValue() +"  ");
        if(firstNode.getValue()==-1 ||secondNode.getValue()==-1){
            //System.out.println("true");
            return true;
        }
        if(firstNode.getValue()==secondNode.getValue()){
            //System.out.println("true");
            return true;
        }
        //System.out.println("false");
        return false;
    }
    public Node getSecondNode() {
        return secondNode;
    }
    public Node getFirstNode() {
        return firstNode;
    }
}
