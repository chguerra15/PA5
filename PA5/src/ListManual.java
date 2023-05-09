


import java.util.*;

public class ListManual {

    /**
     * Answers for Part 1
     * @author Christian Guerra
     * @since  May 4th, 2023
     */

// No style for this file. How poetic :D

    public static ArrayList<String>  listManipulations() {

        ArrayList<String> answers = new ArrayList<>(11);
        answers.add("h = h.next;");
        answers.add("h = r;");
        answers.add(" r = h;");
        answers.add("t = h.next;");
        answers.add("h = t.elem;");
        answers.add("h = (h.next.next).elem");
        answers.add("h.next.next.next = h");
        answers.add("h.next = h.next.next");
        answers.add("while (r != null && r.elem != 'M') {r = r.next;}");
        answers.add("h = new Node('A', new Node('B', new Node('C', new Node('D', null))));");
        answers.add("h.next.next.next = new Node('D', null);");
        return answers;
    }

}