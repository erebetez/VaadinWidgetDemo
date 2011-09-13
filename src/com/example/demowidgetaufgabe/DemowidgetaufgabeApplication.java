package com.example.demowidgetaufgabe;

import com.vaadin.Application;
import com.vaadin.ui.Window;


/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class DemowidgetaufgabeApplication extends Application
{
    private Window window;

    @Override
    public void init()
    {
        window = new Window("Widget Test");
        setMainWindow(window);

        // Mein eigenes Widget verwenden
        window.addComponent(new MyComponent());
    }

}
