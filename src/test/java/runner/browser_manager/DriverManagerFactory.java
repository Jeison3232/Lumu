package runner.browser_manager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager = null;
        switch (type) {
            case CHROME:
//                driverManager = new NavegatorDriverManager();
                break;
            case FIREFOX:
//                driverManager = new NavegatorDriverManager();
                break;
            case EDGE:
//                driverManager = new NavegatorDriverManager();
                break;
        }
        return driverManager;
    }
}


