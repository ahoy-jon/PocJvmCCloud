package com.github.unjon.controlapp;

import com.github.unjon.webserver.EmbeddedJettyScalaWithVaadin;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * Created by IntelliJ IDEA.
 * User: Jon
 * Date: 2/5/12
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Application extends com.vaadin.Application {


    @Override
    public void init() {
        Window main = new Window("Hello window");
        setMainWindow(main);
        main.addComponent(new Label("Upload d'un nouveau service"));

        main.addComponent(new ImmediateUpload());

        Button b = new Button("Eteindre Cozy");


        main.addComponent(b);
        b.addListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                EmbeddedJettyScalaWithVaadin.stop();
            }
        });
    }
}
