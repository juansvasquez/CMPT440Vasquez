package DFA_Implement.DFA

/**
 * Abstract for the man-wolf-goat-cabbage DFA
 *
 * @author Juan Vasquez
  */

public abstract class mwDFA {

    public void process(String in) {
            for (int i = 0; i < in.length(); i++) {
                char c = in.charAt(i);
                    state = delta[state, c]
            }
    }

    public abstract void int[][] delta();
}