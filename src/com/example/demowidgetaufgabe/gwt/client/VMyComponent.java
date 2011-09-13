package com.example.demowidgetaufgabe.gwt.client;

import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

//import com.vaadin.contrib.gwtgraphics.client.DrawingArea;
//import com.vaadin.contrib.gwtgraphics.client.shape.Circle;

public class VMyComponent extends Composite implements Paintable {

    /** Set the CSS class name to allow styling. */
    public static final String CLASSNAME = "v-mycomponent";

    /** The client side widget identifier */
    protected String paintableId;

    /** Reference to the server connection object. */
    ApplicationConnection client;

    private AbsolutePanel panel = null;
    
    private Button myButton = new Button("Add");
    private Label label = new Label("init-text");
    
    /**
     * The constructor should first call super() to initialize the component and
     * then handle any initialization relevant to Vaadin.
     */
    public VMyComponent() {
		panel = new AbsolutePanel();
		
		initWidget(panel);
		
		panel.add(myButton);
		panel.add(label);
	
		setStyleName(CLASSNAME);
    }

    /**
     * Called whenever an update is received from the server 
     */
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        // This call should be made first. 
        // It handles sizes, captions, tooltips, etc. automatically.
        if (client.updateComponent(this, uidl, true)) {
            // If client.updateComponent returns true there has been no changes and we
            // do not need to update anything.
            return;
        }

        // Save reference to server connection object to be able to send
        // user interaction later
        this.client = client;

        // Save the client side identifier (paintable id) for the widget
        paintableId = uidl.getId();
        
        // TODO replace dummy code with actual component logic
//        getElement().setInnerHTML("It works!");
        myButton.setText("UIDL update");
        
        // Hier holt man den wert von "labeltext" welches auf dem server gesetzt wurde.
        label.setText(uidl.getStringVariable("labeltext"));

    }

}
