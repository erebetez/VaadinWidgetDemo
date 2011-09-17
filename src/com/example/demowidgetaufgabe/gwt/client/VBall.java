package com.example.demowidgetaufgabe.gwt.client;

import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;

import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.animation.Animate;
import org.vaadin.gwtgraphics.client.shape.Circle;


public class VBall extends Composite implements Paintable {

    /** Set the CSS class name to allow styling. */
    public static final String CLASSNAME = "v-mycomponent";

    /** The client side widget identifier */
    protected String paintableId;

    /** Reference to the server connection object. */
    ApplicationConnection client;

    private AbsolutePanel panel = null;
    
    private DrawingArea canvas = null;
    private Circle circle = null;
    
    private boolean follow = false;
    
    /**
     * The constructor should first call super() to initialize the component and
     * then handle any initialization relevant to Vaadin.
     */
    public VBall() {
		panel = new AbsolutePanel();
		initWidget(panel);
		
		canvas = new DrawingArea(400, 400);
		panel.add(canvas);
		
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			  public void onMouseMove(MouseMoveEvent event) {
				if (follow){ 
				    circle.setX(event.getX());
				    circle.setY(event.getY());
				}
			  }
		});
		
		canvas.addMouseDownHandler( new MouseDownHandler() {
			public void onMouseDown(MouseDownEvent event) {
				follow = true;				
			}
		});
		
		canvas.addMouseUpHandler( new MouseUpHandler(){
			public void onMouseUp(MouseUpEvent event) {
				follow = false;	
			}
		});

		circle = new Circle(200,200, 0);
		circle.setFillColor("red");
		
		canvas.add(circle);

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
        

        Double d = new Double(uidl.getStringVariable("radius"));
        
        new Animate(circle, "radius", circle.getRadius(), d.intValue(), 500).start();

    }
    
    private void calculateNewRadius(){
    	
    }
    
    

}
