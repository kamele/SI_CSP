import java.util.ArrayList;

public class NeighborHeuristic implements IHeuristic {
    @Override
    public int nextIndex(ArrayList<Integer> indexList) {
        return indexList.get(0);
    }
/*
    @Override
    public int nextValue(int[] domain) {
        return 0;
    }
*/
    @Override
    public int[] sortedDomein(int[] domein){
        return domein;
    }
}
