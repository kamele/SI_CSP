import Problem.Node;

import java.util.ArrayList;

public interface IMethod {


    public ArrayList<int[]> solvePoblem(Node[] AllNodes, IOrderHeuristic orderHeuristic, IValueHeuristic valueHeuristic, String fileName);
}
