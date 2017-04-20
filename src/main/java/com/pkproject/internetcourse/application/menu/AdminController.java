package com.pkproject.internetcourse.application.menu;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.admin.AdminMenuController;
import com.pkproject.internetcourse.application.controller.controllerinterfaces.Controller;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public class AdminController implements StrategyMenuController{
    @Override
    public Controller menuController(Account account) {
        return new AdminMenuController(account);
    }
}
