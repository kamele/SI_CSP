import java.util.ArrayList;

public interface IHeuristic {

    public int nextIndex(ArrayList<Integer> indexList);
    //public int nextValue(int[] domain);
    public int[] sortedDomein(int[] domein);
}
