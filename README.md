# Alogirthms-and-Data-Structures-Coursework

You are required to develop a single Java program with a graphical user interface (GUI) to render 2D objects based on user input, visualise some transitions between states and demonstrate how you’ve preserved states between transitions (for example, going from shape 1 to shape 2 should not leave elements of shape 1 in shape 2). You must use the same development environment as the one used in this module (Java 11 and JavaFX) to implement the logic and GUI components.

The single program must be created inside one and only one file titled exactly “Shapes.java” (without quotes) and have the following functionality:

1.	[Component 1] A graphical interactive component which has the following actions associated with it; the component can accept user input, where assuming the input is valid, a shape will be displayed on the main screen. It is assumed that the program will eventually support a large variety of shapes. The program should currently accept the following input: an integer between 3 and 6 inclusive. Depending on the input, the program should generate a shape with the number of sides corresponding to the input value. For example, an input of 4 should generate a shape with four sides.
1.1.	You need to ensure that the user input is validated, and feedback is given when invalid input is entered.
1.2.	The program should only allow the user to enter one valid input at a time.
1.3.	The main screen should only display one active shape at a time.
1.4.	The colour of the active shape should be grey if the number of sides is even, and blue if the number of sides is odd.

2.	[Component 2] A graphical interactive component which has the following actions associated with it; the component must accept user input, where assuming the input is valid, the currently displayed shape will be manipulated depending on the validated input. The program should currently accept the following inputs: decrease the number of sides of the current shape by 1, increase the number of sides of the current shape by 1.
2.1.	You need to ensure that the user input is validated, and feedback is given when invalid input is entered.
2.2.	The program should only allow the user to enter one valid input at a time.
2.3.	The active shape should always have at minimum, 3 sides, and at maximum, 6 sides in total.
2.4.	The colour of the active shape should be grey if the number of sides is even, and blue if the number of sides is odd.
2.5.	The currently displayed shape should only be filled with one colour at a time.

3.	Any potential error states should not crash the program or generate generic error messages. The program should clearly indicate to the user that an error has occurred, with specific information on why the error occurred and what valid action(s) are available.

![image](https://user-images.githubusercontent.com/103597110/164315654-98a383c4-cba5-4f8d-a632-937f4e2b915b.png)
