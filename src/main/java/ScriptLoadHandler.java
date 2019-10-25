import entities.VulnerabilityScript;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ScriptLoadHandler {
    private static final Logger log = Logger.getLogger(ScriptLoadHandler.class.getName());
    private List<VulnerabilityScript> loadedScripts = new ArrayList<>();
    private DataService dataService;

    public ScriptLoadHandler(DataService dataService) {
        this.dataService = dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public List<VulnerabilityScript> start(int scriptId) {
        loadedScripts.clear();
        startScript(scriptId);
        return loadedScripts;
    }

    public void startScript(int scriptId) {
        loadedScripts.add(startScript(new VulnerabilityScript(
                scriptId,
                dataService.getDependencies(scriptId)
        )));
    }

    public VulnerabilityScript startScript(VulnerabilityScript vulnerabilityScript) {


        List<Integer> dependencies = vulnerabilityScript.getDependencies();
        for (int id : dependencies) {
            startScript(id);
        }
        log.info(vulnerabilityScript.getScriptId() + " started");

        return vulnerabilityScript;
    }
}
