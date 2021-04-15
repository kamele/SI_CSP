import java.util.ArrayList;

public class NeighborOrderHeuristic implements IOrderHeuristic {
    @Override
    public int nextIndex(ArrayList<Integer> indexList) {
        return indexList.get(0);
    }
}
