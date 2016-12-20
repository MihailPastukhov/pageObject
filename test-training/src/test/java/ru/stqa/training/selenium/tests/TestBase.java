package ru.stqa.training.selenium.tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.training.selenium.app.Application;

/**
 * Created by Michael on 26.11.2016.
 */
public class TestBase {

    public Application app = new Application();

    @Before
    public void start() {
        app.init();
    }


    @After
    public void stop(){
        app.exit();
    }


    public Application getApp() {
        return app;
    }
}
