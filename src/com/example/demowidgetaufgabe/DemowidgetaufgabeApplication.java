package com.example.demowidgetaufgabe;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Slider;
import com.vaadin.ui.Slider.ValueOutOfBoundsException;
import com.vaadin.ui.TextArea;
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
    
    private Ball myBall = new Ball();
    
    private final String appWidth = "400px";

    @Override
    public void init()
    {
        window = new Window("Widget Test");
        VerticalLayout layout = new VerticalLayout();
        setMainWindow(window);

        window.addComponent(layout);
        
        StringBuffer tip = new StringBuffer();
        tip.append("Das ist ein selbsterstelltes Clientseitiges Widget. \n");
        tip.append("Es verwendet die gwt-graphics klassen. \n");
        tip.append("Ändere grösse des Balls mit dem Slider. \n");
        tip.append("Mit der Maus kann der Ball verschoben werden.");
        
        TextArea area = new TextArea();
        area.setWidth(appWidth);
        area.setValue(tip);
        area.setReadOnly(true);
        
        layout.addComponent(area);
        layout.addComponent(myBall);
        layout.addComponent(getSlider());
        
        
        // als extra kommt hier noch unser kleines Beispiel Widget rein.
        layout.addComponent(new MyComponent());
    }
    
    
    private Slider getSlider(){
    	if( slider == null){
    		slider = new Slider("Radius", 0, 200);
    		try {
				slider.setValue(50);
			} catch (ValueOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		slider.addListener( this );
    		slider.setImmediate(true);
    		slider.setWidth(appWidth);
    	}
    	return slider;
    }


	public void valueChange(ValueChangeEvent event) {
		
		Double d = new Double(slider.getValue().toString());
		myBall.setRadius(d.intValue());
		
	}
    
}
