import java.util.Comparator;
import java.util.Map;

public class RandomValueComparator implements Comparator<Map.Entry<String,Integer>>{
    @Override
    public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
      return   t2.getValue().compareTo(t1.getValue());
    }
}
