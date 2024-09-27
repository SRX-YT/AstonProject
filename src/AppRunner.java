import controller.AppController;
import presentation.AppMenu;
import service.AppService;

/**
 * Итоговый класс для запуска приложения.
 */

public class AppRunner {
    public static void main(String[] args) {
        AppMenu appMenu = new AppMenu();
        AppService appService = new AppService(appMenu);
        AppController appController = new AppController(appMenu, appService);
        appController.run();
    }
}