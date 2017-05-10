/**
  * file: DegHelp.java
  * author: Juan S. Vasquez
  * course: CMPT 440
  * assignment: Final Project
  * due date: May 9, 2017
  * 
 * This file contains the definition of a deterministic finite automaton to
 * create the DegreeHelper DFA.
 */

/**
 * DegHelp
 *
 * Defines a table-driven DFA to create the DegreeHelper DFA.
 * All methods are static.
 */
public final class DegHelp {
  /* DFA states */
  private static final int q0 = 0; //Start
  private static final int q1 = 1; //MATH130L
  private static final int q2 = 2; //MATH241L
  private static final int q3 = 3; //MATH205L
  private static final int q4 = 4; //CMPT435L
  private static final int q5 = 5; //CMPT120L
  private static final int q6 = 6; //CMPT220L
  private static final int q7 = 7; //CMPT221L
  private static final int q8 = 8; //CMPT333N
  private static final int q9 = 9; //BUS100N
  private static final int q10 = 10; //CMPT230L (a)
  private static final int q11 = 11; //CMPT330L (b)
  private static final int q12 = 12; //CMPT306N (c)
  private static final int q13 = 13; //CMPT307N (d)
  private static final int q14 = 14; //CMPT308L (e)
  private static final int q15 = 15; //CMPT331L (f)
  private static final int q16 = 16; //CMPT442N (g)
  private static final int q17 = 17; //CMPT440L (h)
  private static final int q18 = 18; //CMPT432L (i)
  private static final int q19 = 19; //CMPT424L (j)
  private static final int ERR = 20;

  /* Table to encode delta function */
  private static final int[][] delta = {
    {ERR,q1,q2,q3,ERR,q5,ERR,ERR,q8,q9,q10,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q0
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q1
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q2
    {ERR,ERR,ERR,ERR,ERR,q5,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q3
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q4
    {ERR,ERR,ERR,ERR,ERR,ERR,q6,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q5
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,q7,ERR,ERR,ERR,ERR,ERR,ERR,q14,ERR,q16,ERR,ERR,ERR}, // q6
    {ERR,ERR,ERR,ERR,q4,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,q15,ERR,ERR,ERR,ERR}, // q7
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q8
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q9
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,q11,q12,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q10
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q11
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,q13,ERR,ERR,ERR,ERR,ERR,ERR}, // q12
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q13
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q14
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q15
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,q17,q18,q19}, // q16
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q17
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}, // q18
    {ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR}  // q19
  };   

  /**
   * Processes an input string with the transition table to see if it ends in an
   * accepting state.
   *
   * @param input the string to be checked.
   * @return true if the string was accepted, otherwise false
   */
  public static boolean process(String path, String goal) {
  /* The current state for the DFA (starts at the initial state)*/
      int currentState = q0;
      char endGoal = goal.charAt(0);
      int endState = encodeChar(endGoal);

      for (int i = 0; i < path.length(); i++) {
          char c = path.charAt(i);
          try {
              currentState = delta[currentState][encodeChar(c)];
          } catch(ArrayIndexOutOfBoundsException ae) {
      /* User supplied an invalid character, so the string is not accepted. */
              return false;
          }
      }
      return currentState == endState;
  }

  /**
   * Processes an input string in order to check class information.
   *
   * @param input the string to be checked.
   * @return output with class information.
   */
  public static void classInfo(String code){
    String newLine = System.lineSeparator();  //Will retrieve line separator dependent on OS
    switch (code) {
      case "1": 
      System.out.println("Class: Intro to Statistics" + newLine + "Code: MATH130L" + newLine + "Credits: 3");
      break;
      case "2": 
      System.out.println("Class: Calculus I" + newLine + "Code: MATH241L" + newLine + "Credits: 4");
      break;
      case "3": 
      System.out.println("Class: Discrete Mathematics" + newLine + "Code: MATH205L" + newLine + "Credits: 4");
      break;
      case "4": 
      System.out.println("Class: Algorithm Analysis and Design" + newLine + "Code: CMPT435L" + newLine + "Credits: 3");
      break;
      case "5": 
      System.out.println("Class: Intro to Programming" + newLine + "Code: CMPT120L" + newLine + "Credits: 4");
      break;
      case "6": 
      System.out.println("Class: Software Development I" + newLine + "Code: CMPT220L" + newLine + "Credits: 4");
      break;
      case "7": 
      System.out.println("Class: Software Development II" + newLine + "Code: CMPT221L" + newLine + "Credits: 4");
      break;
      case "8": 
      System.out.println("Class: Language Design" + newLine + "Code: CMPT333N" + newLine + "Credits: 4");
      break;
      case "9": 
      System.out.println("Class: Intro to Business and Management" + newLine + "Code: BUS100N" + newLine + "Credits: 3");
      break;
      case "a": 
      System.out.println("Class: Software Systems and Analysis" + newLine + "Code: CMPT230L" + newLine + "Credits: 4");
      break;
      case "b": 
      System.out.println("Class: System Design" + newLine + "Code: CMPT330L" + newLine + "Credits: 4");
      break;
      case "c": 
      System.out.println("Class: Data Communications" + newLine + "Code: CMPT306N" + newLine + "Credits: 4");
      break;
      case "d": 
      System.out.println("Class: Internetworking" + newLine + "Code: CMPT307N" + newLine + "Credits: 4");
      break;
      case "e": 
      System.out.println("Class: Database Management" + newLine + "Code: CMPT308L" + newLine + "Credits: 4");
      break;
      case "f": 
      System.out.println("Class: Theory of Programming Languages" + newLine + "Code: CMPT331L" + newLine + "Credits: 3");
      break;
      case "g": 
      System.out.println("Class: Computer Organization and Architecture" + newLine + "Code: CMPT422N" + newLine + "Credits: 4");
      break;
      case "h": 
      System.out.println("Class: Formal Languages and Computability" + newLine + "Code: CMPT440L" + newLine + "Credits: 3");
      break;
      case "i": 
      System.out.println("Class: Design of Compilers" + newLine + "Code: CMPT432L" + newLine + "Credits: 4");
      break;
      case "j": 
      System.out.println("Class: Operating Systems" + newLine + "Code: CMPT424L" + newLine + "Credits: 4");
      break;
      default : 
      System.out.println("That's not a valid class code!");
      break;
    }
  }

  /**
   * Converts a symbol into an int representation (for use with the transition
   * table).
   *
   * @param c The incoming symbol to be encoded
   * @return int representation of symbol
   */
  private static int encodeChar(char c){
    switch(c){
      case '0': return 0;
      case '1': return 1;
      case '2': return 2;
      case '3': return 3;
      case '4': return 4;
      case '5': return 5;
      case '6': return 6;
      case '7': return 7;
      case '8': return 8;
      case '9': return 9;
      case 'a': return 10;
      case 'b': return 11;
      case 'c': return 12;
      case 'd': return 13;
      case 'e': return 14;
      case 'f': return 15;
      case 'g': return 16;
      case 'h': return 17;
      case 'i': return 18;
      case 'j': return 19;
      default : return -1; //Will always cause ArrayIndexOutOfBoundsException
    }
  }
}