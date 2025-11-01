package examples.singleton;

public class MyOneAndOnly {
    private static MyOneAndOnly instance;

    public MyOneAndOnly() {}

    public static MyOneAndOnly getInstance() {
        if (instance == null) {
            instance = new MyOneAndOnly();
        }
        return instance;
    }
}
