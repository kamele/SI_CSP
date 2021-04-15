import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandValueHeuristic implements IValueHeuristic{

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
