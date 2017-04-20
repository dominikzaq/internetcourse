package com.pkproject.internetcourse.application.menu;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.controllerinterfaces.Controller;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public interface StrategyMenuController {
    public Controller menuController(Account account);
}
