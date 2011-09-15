package com.example.demowidgetaufgabe;

import com.example.demowidgetaufgabe.gwt.client.VBall;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.ClientWidget;

/**
 * Server side component for the VBall widget.
 */
@ClientWidget(VBall.class)
public class Ball extends AbstractComponent {

	private int radius = 20;
	
    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);

        target.addVariable(this, "radius", getRadius());
        
        // TODO Paint any component specific content by setting attributes
        // These attributes can be read in updateFromUIDL in the widget.
    }
    
    public void setRadius(int radius){    	
    	this.radius = radius;
    	this.requestRepaint();
    }
    
    public int getRadius(){
    	return this.radius;
    }
    

}
