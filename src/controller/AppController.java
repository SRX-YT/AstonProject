package controller;

import presentation.AppMenu;
import service.AppService;
import util.AppUtils;

import java.io.IOException;

public class AppController {
    private final AppMenu appMenu;
    private final AppService appService;

    public AppController(AppMenu appMenu, AppService appService) {
        this.appMenu = appMenu;
        this.appService = appService;
    }

    public void run() {

        boolean exit = false;
        while (!exit) {

            int choice = appMenu.showMenu(AppMenu.MenuType.MAIN_MENU);

            switch (choice) {
                case 1:
                    try {
                        choice = appMenu.showMenu(AppMenu.MenuType.DATA_INPUT_MENU);
                        appService.getHandleDataInput(choice);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
//                   AppService.getHandleSorting();
                    break;
                case 3:
//                    AppService.getHandleBinarySearch();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Повторите.");
            }
        }
    }
}