import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandHeuristic implements IHeuristic {
    @Override
    public int nextIndex (ArrayList< Integer > indexList) {
        Random r = new Random();
        int nextIndexIndex = r.nextInt(indexList.size());
        return indexList.get(nextIndexIndex);
    }
/*
    @Override
    public int nextValue(int[] domain) {
        return 0;
    }
*/
    @Override
    public int[] sortedDomein ( int[] domein){
        ArrayList<Integer> valuesToSort = new ArrayList<>();
        for(int i = 0; i< domein.length;i++){
            valuesToSort.add(domein[i]);
        }
        int[] newDomein = new int[domein.length];
        Random r = new Random();
        for(int i = 0; i< domein.length;i++){
            int nextValueIndex = r.nextInt(valuesToSort.size());
            newDomein[i]=valuesToSort.get(nextValueIndex);
            valuesToSort.remove(nextValueIndex);
        }
        return newDomein;
        //return domein;
    }
}