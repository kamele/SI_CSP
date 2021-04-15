package Constrains;

import Constrains.IConstrain;
import Problem.Node;

public class NeighborConstrain  implements IConstrain {
    private Node firstNode;
    private Node secondNode;

    public NeighborConstrain(Node firstNode, Node secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }

    @Override
    public boolean isFulFilled() {
        //System.out.print("fulfilled(Constrains.NeighborConstrain)"+firstNode.getValue()+"; "+secondNode.getValue() +"  ");
        if(firstNode.getValue()==-1 || secondNode.getValue()==-1 ) {  //sprawdzenie czy przypisane //-1
            //System.out.println("true");
            return true;
        }
        if(Math.abs(firstNode.getValue()-secondNode.getValue())==1){ //sprawdzenie czy second jest sasiadem first
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
