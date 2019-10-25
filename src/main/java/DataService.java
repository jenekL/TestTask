import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataService {
    private List<List<Integer>> dependencies = new ArrayList<>(
            Arrays.asList(
                    Arrays.asList(2, 3),
                    Arrays.asList(4, 5),
                    Arrays.asList(6, 7),
                    Arrays.asList(8, 9),
                    Arrays.asList(10, 11),
                    Arrays.asList(12, 13),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList()
            )
    );

    public DataService() {

    }
    public DataService(List<List<Integer>> dependencies) {
        this.dependencies = dependencies;
    }

    public void setDependencies(List<List<Integer>> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Integer> getDependencies(int scriptId){
        if(scriptId > dependencies.size()){
           throw new IndexOutOfBoundsException("not existing dependency");
        }
        else {
            return dependencies.get(scriptId - 1);
        }
    }
}