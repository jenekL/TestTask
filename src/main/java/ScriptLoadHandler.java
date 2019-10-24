import entities.VulnerabilityScript;

import java.util.List;
import java.util.logging.Logger;

public class ScriptLoadHandler {
    private static final Logger log = Logger.getLogger(ScriptLoadHandler.class.getName());
    private DataService dataService;

    public ScriptLoadHandler(DataService dataService) {
        this.dataService = dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public void startScript(int scriptId) {
        startScript(new VulnerabilityScript(
                scriptId,
                dataService.getDependencies(scriptId)
        ));
    }

    public void startScript(VulnerabilityScript vulnerabilityScript) {

        List<Integer> dependencies = vulnerabilityScript.getDependencies();
        for (int id : dependencies) {
            startScript(id);
        }
        log.info(vulnerabilityScript.getScriptId() + " started");
    }
}
