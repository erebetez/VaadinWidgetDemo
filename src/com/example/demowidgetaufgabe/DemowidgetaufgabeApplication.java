package com.example.demowidgetaufgabe;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class DemowidgetaufgabeApplication extends Application implements Property.ValueChangeListener
{
    private Window window;
    private Slider slider = null;
    private Label label = new Label("Hallo. Ändere grösse des Balls.");
    
    private Ball myBall = new Ball();

    @Override
    public void init()
    {
        window = new Window("Widget Test");
        VerticalLayout layout = new VerticalLayout();
        setMainWindow(window);

        window.addComponent(layout);
        
        layout.addComponent(myBall);
        layout.addComponent(getSlider());
        layout.addComponent(label);
        layout.addComponent(new MyComponent());
    }
    
    
    private Slider getSlider(){
    	if( slider == null){
    		slider = new Slider("Radius", 0, 200);	
    		slider.addListener( this );
    		slider.setImmediate(true);
    		slider.setWidth("200px");
    	}
    	return slider;
    }


	public void valueChange(ValueChangeEvent event) {
		
		Double d = new Double(slider.getValue().toString());
		myBall.setRadius(d.intValue());
		
	}
    
}
