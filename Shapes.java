import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Shapes extends Application {

	// Overriding the Application start method
	@Override
	public void start(Stage stage)
	{
		
		// Create labels for instructions
		Label howManySides = new Label("Enter the number of sides (3 - 6) for your shape and click Generate:");		
		Label changeSides = new Label("Increase or decrease the number of sides by 1:");

		
		// Ensuring that if the window is adjusted the label text will go onto the next line
		howManySides.setWrapText(true);
		changeSides.setWrapText(true);
		
		
		// Create and change font for labels
		Font font1 = Font.font("Arial",15);
		howManySides.setFont(font1);
		changeSides.setFont(font1);

				
		// Create text field for entering number of sides of shape
		TextField numberOfSides = new TextField();
		numberOfSides.setMinWidth(85);
		numberOfSides.setMaxWidth(85);
		
		
		// Create buttons, setting their minimum width and the font
		Button generateButton = new Button("Generate");
		generateButton.setMinWidth(85);
		generateButton.setFont(font1);
		
		Button increaseButton = new Button("Increase");
		increaseButton.setMinWidth(85);
		increaseButton.setFont(font1);
		
		Button decreaseButton = new Button("Decrease");
		decreaseButton.setMinWidth(85);
		decreaseButton.setFont(font1);
		
		
		// Creating a grid to hold all user interface components
		GridPane userInterface = new GridPane();
		
		
		// Setting the gap between rows, columns and around the border
		userInterface.setVgap(10);
		userInterface.setHgap(10);
		userInterface.setPadding(new Insets(10));
		
		
		// Adding labels, text field and buttons for component 1 to the grid
		userInterface.add(howManySides,0,0);
		userInterface.add(numberOfSides,1,0);
		userInterface.add(generateButton,2,0);
		
		
		// Adding labels, text field and buttons for component 2 to the grid
		userInterface.add(changeSides,0,1);
		userInterface.add(increaseButton,1,1);
		userInterface.add(decreaseButton,2,1);
		
		
		// Creating a box to store the grid of options and for shapes and prompts to be added to
		VBox root = new VBox(40);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(20));
		root.getChildren().add(userInterface);
		
				
		// Create a label to display a prompt if an invalid input is given
		Label invalidInput = new Label();
		
		
		// Creating and setting the font for the prompt messages
		Font font2 = Font.font("Arial",FontWeight.BLACK,17);
		invalidInput.setFont(font2);
				
		
		// Instructions for drawing triangle (3 sides) and fill colour
		Polygon triangle = new Polygon(
				125,0,
				250,200,
				0,200,
				125,0);
		
		triangle.setFill(Color.BLUE);
	
		
		// Instructions for drawing square (4 sides) and fill colour
		Polygon square = new Polygon(
				0,0,
				200,0,
				200,200,
				0,200);
	
		square.setFill(Color.GREY);
		
		
		// Instructions for drawing pentagon (5 sides) and fill colour
		Polygon pentagon = new Polygon(
				80,120,
				120,240,
				280,240,
				320,120,
				200,40);
		
		pentagon.setFill(Color.BLUE);
		
		
		// Instructions for drawing hexagon (6 sides) and fill colour
		Polygon hexagon = new Polygon(
				0,0,
				130,0,
				205,100,
				135,200,
				0,200,
				-75,100);

		hexagon.setFill(Color.GREY);
	
		
		// Configuring the Generate button
		generateButton.setOnAction(e ->
		{
			
			// Emptying the grid so function can be reused
			root.getChildren().clear();
						
			// Creating a string object from the user input in the text field
			String input = numberOfSides.getText();
											
			// Switch statement to identify the shape to produce (or not) based on input, add to the grid and reset text field
			switch(input)
			{
				case "3":	root.getChildren().addAll(userInterface,triangle);
							numberOfSides.setText("");
							break;
				case "4":	root.getChildren().addAll(userInterface,square);
							numberOfSides.setText("");
							break;
				case "5": 	root.getChildren().addAll(userInterface,pentagon);
							numberOfSides.setText("");
							break;
				case "6": 	root.getChildren().addAll(userInterface,hexagon);
							numberOfSides.setText("");
							break;
				// Covers any input outside of 3-6 and prompts user on correct input
				default:	numberOfSides.setText("");
							invalidInput.setText("Please enter a number from 3 - 6.");
							root.getChildren().addAll(userInterface,invalidInput);
							
			}	
		
		});
		
					
		// Configuring the Increase button
		increaseButton.setOnAction(e ->
		{	
			// Finding out what the current shape is, clearing the grid and add the shape with one more side
			if(root.getChildren().contains(triangle))
			{
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,square);
			}
			else if(root.getChildren().contains(square))
			{
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,pentagon);
			}
			else if(root.getChildren().contains(pentagon))
			{
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,hexagon);
			}
			else if(root.getChildren().contains(hexagon))
			{
				// Cannot increase hexagon by one so prompt generated
				invalidInput.setText("Cannot increase to 7 sides!");
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,hexagon,invalidInput);
			}
			// Covers situation where no shape has been generated
			else
			{
				invalidInput.setText("Please generate a valid shape first.");
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,invalidInput);
			}
		});
		
		
		// Configuring the Decrease button
		decreaseButton.setOnAction(e ->
		{
			// Finding out what the current shape is, clearing the grid and add the shape with one less side
			if(root.getChildren().contains(hexagon))
			{
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,pentagon);
			}
			else if(root.getChildren().contains(pentagon))
			{
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,square);
			}
			else if(root.getChildren().contains(square))
			{
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,triangle);
			}
			
			else if(root.getChildren().contains(triangle))
			{
				// Cannot decrease triangle by one so prompt generated
				invalidInput.setText("Cannot decrease to 2 sides!");
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,triangle,invalidInput);
			}
			// Covers situation where no shape has been generated
			else
			{
				invalidInput.setText("Please generate a valid shape first.");
				root.getChildren().clear();
				root.getChildren().addAll(userInterface,invalidInput);
			}
		});
		
		
		// Create the scene to hold the root node
		Scene scene = new Scene(root,500,525);
		
		
		// Adding the scene to the stage and setting the title
		stage.setScene(scene);
		stage.setTitle("Shape Creator");
		stage.show();
		
	}
	
	public static void main(String[] args) {	
		
		// Launching the application
		launch(args);

	}

}
