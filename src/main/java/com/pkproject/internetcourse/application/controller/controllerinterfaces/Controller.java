package com.pkproject.internetcourse.application.controller.controllerinterfaces;

import java.io.IOException;

/**
 * Created by dominikzaq on 14.01.2017.
 */
public interface Controller {
    public void changeController(Controller controller, String controllerAddress) throws IOException;
}
