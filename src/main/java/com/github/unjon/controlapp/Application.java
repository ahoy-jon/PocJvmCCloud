package com.github.unjon.controlapp;

import com.github.unjon.webserver.EmbeddedJettyScalaWithVaadin;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;


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
