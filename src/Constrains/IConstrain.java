package Constrains;

import Problem.Node;

public interface IConstrain {

    public abstract boolean isFulFilled();
    public Node getSecondNode();
    public Node getFirstNode();
}
