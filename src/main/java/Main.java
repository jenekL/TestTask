public class Main {

    public static void main(String ...args){
        ScriptLoadHandler scriptLoadHandler = new ScriptLoadHandler(new DataService());
        scriptLoadHandler.start(Integer.parseInt(args[0]));
    }
}
