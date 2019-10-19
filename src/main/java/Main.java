import db.entities.DependenciesEntity;
import db.services.DependencyService;
import db.services.ServiceFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String ...args){
        DependencyService dependencyService = ServiceFactory.getDependencyService();

        final int scriptId = 1;

        List<Integer> dependencies = dependencyService.getByScriptId(scriptId)
                .stream().map(DependenciesEntity::getDependencyId).collect(Collectors.toList());

        Thread t = new Thread(new ScriptLoadThread(scriptId, dependencies, dependencyService));
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }
}
