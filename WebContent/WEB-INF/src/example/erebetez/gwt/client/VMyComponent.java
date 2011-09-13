package example.erebetez.gwt.client;

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

//    private Canvas myCanvas;
//    private Context2d context;
//    private Ball ball;

    
//    private DrawingArea canvas = null;
    
    /**
     * The constructor should first call super() to initialize the component and
     * then handle any initialization relevant to Vaadin.
     */
    public VMyComponent() {
		panel = new AbsolutePanel();
		
		initWidget(panel);
		
//		myCanvas.createIfSupported();
//	    if (myCanvas == null) {
//	    	panel.add(new Label("Nicht gut! Canvas nicht unterstützt."));
//	        return;
//	    }
//
//		myCanvas.setWidth("200px");
//		myCanvas.setHeight("200px");
//		
//		panel.add(myCanvas);
		panel.add(myButton);
		panel.add(label);
	
		setStyleName(CLASSNAME);

//		DOM.setStyleAttribute(canvas.getElement(), "border", "1px solid black");
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
        label.setText(uidl.getStringVariable("labeltext"));

// 		context = myCanvas.getContext2d();   
// 	    context.setFillStyle("cc33aa");
// 	    context.beginPath();
// 	    context.arc(100, 100, 30, 0, Math.PI * 2.0, true);
// 	    context.closePath();
// 	    context.fill();
// 		
// 		
// 		ball = new Ball(50, 200, 20, 30, "cccccc");
//		
// 		ball.draw(context);
 		   
    }

}
