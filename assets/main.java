// Import util packages
import java.util.*;

// Import io packages 
import java.io.*;

// Create a class and method
public class Main {
  public static void main(String[] args) {

    // Create a while loop so that once the user wants to exit the program, the loop breaks, and if the user does not want to exit the program, the program restarts
    while(true){
    
    // Clear the screen
    System.out.print("\033[H\033[2J");
    System.out.flush();

    // Create scanner object
    Scanner inp = new Scanner(System.in);

    // Create print statements
    System.out.println("Select Your Class Size!\n");
    System.out.println("A 6x5 Classroom or a 3X10 classroom?\n Enter '6x5' or '3x10' please!\n");

    // Create variables to be used in the print statements 
    String Class1 = "6x5";
    String Class2 = "3x10";

    // Create a double array variable with the limit of 1 so that it can be used to recognize the "x" in the string 
    Double input[] = new Double[1];

    // Allow the user to choose what classSize they would like
    String selectClassSize = inp.next();

    // Creat an indexofx to find the "x" in the selectClassSize variable
    int indexOfx = selectClassSize.indexOf('x');
    
    // Create a counter variable to count/find the "x"
    int xcount = 0;

    // Create a boolean variable that has the requirements in it, and finds the first index and the last index
    // Subtract 2 from the length because "x" will be located in the middle of a 3 word string
    boolean containsx = indexOfx == 0 || indexOfx == (selectClassSize.length() - 2);

    // Validate x at beginning or end 
    if (containsx) {

      // Use the double array and counter to find the "x" in the string 
      input[xcount] = Double.parseDouble(selectClassSize.replace("x", ""));
      
      // Create print statements 
      System.out.println("\nOk, so you have selected " + Class1);
      System.out.println("Your classroom size looks like this:\n");

      // Initialize variables to use in the for loop, start with the 6x5 classSize
      int rows = 6;
      int columns = 5;

      // Create a multi-dimensional array to include both the rows and columns
      int classSize[][] = new int [rows][columns];
      
      // Create a for loop to print a visual representation of the 6x5 classSize
      for(int i = 0; i < classSize[0].length; i++){
        for(int j = 0; j < classSize.length; j++){
            System.out.print("X");
      }
      System.out.println();
    }
      xcount++;

    // Otherwise, do the same thing for 3x10 classSize
    } else {
      System.out.println("\nOk, so you have selected " + Class2);
      System.out.println("Your classroom size looks like this:\n");

      // Initialize variables to use in the for loop, but this time for the 3x10 classSize
      int rows2 = 3;
      int columns2 = 10;
      int classSize2[][] = new int [rows2][columns2];
        for(int x = 0; x < classSize2[0].length; x++){
          for(int y = 0; y < classSize2.length; y++){
              System.out.print("X");
      }
      System.out.println();
      }
    }

    // Create a print statement
    System.out.println("\nNow Enter The Number Of Students!");

    // Create a scanner variable to allow the user to enter the number of students in the class 
    int numOfStudents = inp.nextInt();

    // Create a print statement 
    System.out.println("\nEnter the first names of the " + numOfStudents + " students!\n");

    // Initialize String array variables to be used in the for loop and inside the try-catch block 
    String[] names = new String[numOfStudents];
    String[] seats = new String[numOfStudents];

     try {

      // Initialize the new objects
      FileWriter fw = new FileWriter("StudentNames");
      BufferedWriter bw = new BufferedWriter(fw);
      
      // Create int variables to output the seat location 
      int row = 0;
      int column = 1; 
      
      // Use a for loop to allow the user to enter names, and the program to assign seats automatically, save both the information in a new textfile called "StudentNames"
      for (int x = 0; x < numOfStudents; x++) {
          names[x] = inp.next();

          // if "x" is validated to be found, basically call this boolean from before that checks the possiblity of "x"
          if(containsx) {

              // For the 6x5 classSize, if row is greater than 6 or equal to 6, start a new row and count the number of columns, accordingly 
              if(row >= 6) {
                  column++;

                  // Set row to 0
                  row = 0;
              }
          }

          // Otherwise, for the 3x10 classSize, if the row if greater or equal to 3, then start a new row and count the number of columns, accordingly
          else {
              if(row >= 3) {
                  column++;

                  // Set row to 0
                  row = 0;
              }
          }

          // Assign a array, and use Integer.toString to return the String with a specified Integer parameter (column) and (rows)
          seats[x] = "("+Integer.toString(column)+")" + "("+Integer.toString(++row)+")";

          // Write it onto the textfile called "StudentNames"
          bw.write(names[x]+" Seat Location: "+seats[x]);
          bw.newLine();
      }
      
      bw.close();
      fw.close();

      // Catch any errors
    } catch (Exception e) {
      System.out.println("An Error Occured!");
    }

    // Create another try-catch block to read the file 
     try {

      // Initialize the new objects
      FileReader fr = new FileReader("StudentNames");
      BufferedReader br = new BufferedReader(fr);

      String line = br.readLine();

      // Create a print statement 
      System.out.println("\nThe Names And Seat Location Of The Student Are As Follows:\n");
      
      // Start a while loop to output the data from the file
      while (line != null) {
          System.out.println(line);
          line = br.readLine();
        }

      br.close();
      fr.close();

      // Catch any errors
    } catch (Exception e1) {
      System.out.println("An Error Occured!");
    }

    // Create a print statement 
    System.out.println("\nDo You Want To Assign Seats By Alphabetical Order? (y/n)\n");

    // Allow the user to type "y" or "n" to see the names sorted in alphabetical order
    String letter = inp.next();

      // start a if statement for the input "y" and sort the names using Arrays.sort();
      if (letter.equals("y")){
        Arrays.sort(names); // Use Arrays.sort() function

        // Use a for loop to print the names in alphabetical order
        for (int x = 0; x < numOfStudents; x++){
        System.out.println(names[x]+" Seat Location: "+seats[x]);
        }
        
        // Create a print statement
        System.out.println("\nExit The Program? (y/n)\n");
        
        // Allow the user to type out "y" or "n" to exit the program
        String enter3 = inp.next();

        // Use an if statement to break the program 
        if (enter3.equals("y")){
          System.out.println("\nHave A Nice Day!\n");
          break;
      }else{
        continue; // Restarts the program 
      }

        // if the user types "n" as they do not want to see the names in an alphabetical order, then the user can exit the program
        }else{
        System.out.println("\nExit The Program? (y/n)\n");
        String enter2 = inp.next();
        if (enter2.equals("y")){
          System.out.println("\nHave A Nice Day!\n");
          break;
        }else{
          continue; // Restarts the program 
        }
      }
    }
  }
}
