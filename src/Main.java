import controller.AppController;
import presentation.AppMenu;
import service.AppService;

public class Main {
    public static void main(String[] args) {
        AppMenu appMenu = new AppMenu();
        AppService appService = new AppService(appMenu);
        AppController appController = new AppController(appMenu, appService);
        appController.run();
    }
}
