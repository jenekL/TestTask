import db.entities.DependenciesEntity;
import db.services.DependencyService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptLoadThread implements Runnable {
    private final List<Integer> dependencies;
    private final int scriptId;
    private final DependencyService dependencyService;
    private List<Thread> threads = new LinkedList<>();

    public ScriptLoadThread(int scriptId, List<Integer> dependencies, DependencyService dependencyService) {
        this.dependencies = dependencies;
        this.scriptId = scriptId;
        this.dependencyService = dependencyService;
    }

    public void run() {
        for (Integer ind : dependencies) {
            List<Integer> depends = dependencyService.getByScriptId(ind)
                    .stream().map(DependenciesEntity::getDependencyId).collect(Collectors.toList());

            if (depends.size() > 0) {
                Thread t = new Thread(new ScriptLoadThread(ind, depends, dependencyService));
                threads.add(t);
                t.start();

//                try {
//                    t.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            } else {
                System.out.println("script " + ind + " started with no dependencies");
            }
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("script " + scriptId + " started with dependencies " + dependencies.toString());

    }
}
