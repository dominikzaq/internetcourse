package com.pkproject.internetcourse.application.menu;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.controller.controllerinterfaces.Controller;
import com.pkproject.internetcourse.application.controller.trainee.TraineeMenuController;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public class TraineeController implements StrategyMenuController {
    @Override
    public Controller menuController(Account account) {
        return new TraineeMenuController(account);
    }
}
