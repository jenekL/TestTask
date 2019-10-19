package db.services;

public class ServiceFactory {

    public static ScriptService getScriptService() {
        return new ScriptService();
    }

    public static DependencyService getDependencyService() {
        return new DependencyService();
    }
}
