package com.example.demowidgetaufgabe;

import com.example.demowidgetaufgabe.gwt.client.VMyComponent;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.ClientWidget;

/**
 * Server side component for the VMyComponent widget.
 */
@ClientWidget(VMyComponent.class)
public class MyComponent extends AbstractComponent {

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        
        // Um dem Widget auf der Clientsite etwas mitzuteilen,
        // kann eine variable definiert werden.
        // Hier wird eine Text unter dem Namen "labeltext" für das clientwidget
        // abgelegt.
        target.addVariable(this, "labeltext", "Das ist der neue Text. Dieser wurde mir von Server mittgeteilt.");
        
        // TODO Paint any component specific content by setting attributes
        // These attributes can be read in updateFromUIDL in the widget.
    }
}
