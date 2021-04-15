package Problem;

import Constrains.IConstrain;
import java.util.ArrayList;

public class Node {

    private int value; //color or houseNr
    private int[] domain;//={1,2,3,4,5};

    private IConstrain[] constrains;

    public Node(int[] domain) {
        this.value = -1;
        this.domain = domain;

        constrains = new IConstrain[0];
    }
    public Node(int[] domain, IConstrain[] constrains) {
        this.value = -1;
        this.domain = domain;
        this.constrains = constrains;

    }

    public Node(Node oryginal){
        this.value=oryginal.getValue();
        this.domain=oryginal.domain.clone();
        this.constrains = oryginal.getConstrains();

    }

    public Node cloneNode(){
        Node clone = new Node(this.getDomain());
        clone.setValue(this.getValue());
        clone.setConstrains(this.getConstrains());
        return clone;
    }

    public boolean areConstrainsFulfill(){
        for(int i =0; i<constrains.length;i++){
            if(!constrains[i].isFulFilled()){
                return false;
            }
        }
        return true;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getDomain() {
        return domain;
    }

    public void setDomain(int[] domain) {
        this.domain = domain;
    }

    public IConstrain[] getConstrains() {
        return constrains;
    }

    public void setConstrains(IConstrain[] constrains) {
        this.constrains = constrains;
    }
}
