package com.pkproject.internetcourse.application.authorization;

import com.pkproject.internetcourse.application.account.Account;
import com.pkproject.internetcourse.application.datebase.Operation;

import java.sql.SQLException;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public class Authorization {
    private Operation operation;

    public Authorization() {
        this.operation = new Operation();
    }

    public void checkState(Account account) throws SQLException {
        operation.logging(account);
    }
}
