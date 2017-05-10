import java.io.*;
/**
* file: runDFA.java
* author: Juan S. Vasquez
* course: CMPT 440
* assignment: Final Project
* due date: May 9, 2017
*  
* A Java application to demonstrate the DegHelp class by 
* using it to filter the standard input stream.
*/ 
public class runDFA {
  public static void main(String[] args)
    throws IOException {
        
      DegHelp d = new DegHelp(); //The DFA    
      BufferedReader in =  //Standard input      
          new BufferedReader(new InputStreamReader(System.in));
          
      //Read and echo lines until EOF
      System.out.println("Hello! Please enter your major below.");
      String s = in.readLine();
      while (s != null) {
        //Read inputted line until matched with a major
        if (s.equals("Computer Science") || s.equals("computer science") || s.equals("compsci")) {
          //Search for a matching concentration
          System.out.println("Welcome! Please enter your concentration below.");
          String s1 = in.readLine();
          while (s1 != null) {
            if (s1.equals("Software Development") || s1.equals("software development") || s1.equals("softdev")) {
              //Search for a matching class code.
              System.out.println("Welcome! Please enter a class code.");
              String s2 = in.readLine();
              while (s2 != null) {
                //Report class information
                d.classInfo(s2);
                System.out.println("Please enter the desired sequence leading to this class.");
                String s3 = in.readLine();
                while (s3 != null) {
                  //Read inputted class sequence and run it through the DFA process
                  if (d.process(s3, s2)) {
                    System.out.println("That is a viable plan."); 
                    break; //Returns user to enter a class code
                  } 
                  else {
                    System.out.println("That will not work. Re-examine your plan.");
                    break; //Returns user to enter a class code
                  }
                }
                System.out.println("Please enter a new class code.");
                s2 = in.readLine();
              }
            } 
            else {
                System.out.println("Sorry, we do not support that concentration. Please enter a different one or come back later.");
            }
            s1 = in.readLine();
          }
        } 
        else {
            System.out.println("Sorry, we do not support that major. Please enter a different one or come back later.");
        }
        s = in.readLine();
      }
    }
} 