import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandOrderHeuristic implements IOrderHeuristic {
    @Override
    public int nextIndex (ArrayList< Integer > indexList) {
        Random r = new Random();
        int nextIndexIndex = r.nextInt(indexList.size());
        return indexList.get(nextIndexIndex);
    }

}