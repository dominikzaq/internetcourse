package com.pkproject.internetcourse.application.menu;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.controllerinterfaces.Controller;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public class Context {
    private StrategyMenuController strategy;

    public Context(StrategyMenuController strategy) {
        this.strategy = strategy;
    }

    public Controller menuController(Account account) {
        return strategy.menuController(account);
    }
}
