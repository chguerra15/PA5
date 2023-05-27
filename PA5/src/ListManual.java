


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
        answers.add("h = h.next;");//0
        answers.add("h = r;");//1
        answers.add(" r = h;");//2
        answers.add("t = h.next;");//3
        answers.add("h.elem = t.elem;");//4
        answers.add("h.elem = h.next.next.elem;");//5
        answers.add("h.next.next.next = h;");//6
        answers.add("h.next = h.next.next;");//7
        answers.add("while (r != null && r.elem != 'M') {r = r.next;}");//8
        answers.add("h = Node('A');\n" + "h.next = Node('B');\n" + "h.next.next = Node('C');\n" +
                "h.next.next.next = Node('D');");//9
        answers.add("h.next.next.next = new Node('D', null);");//10
        return answers;
    }

    //answers.add("h = h.next;"); -- 0
    //        answers.add("h = r;");----1
    //        answers.add(" r = h;");----2
    //        answers.add("t = h.next;");---3
    //        answers.add("h = t.elem;");---4
    //        answers.add("h = (h.next.next).elem");---5
    //        answers.add("h.next.next.next = h");---6
    //        answers.add("h.next = h.next.next");---7
    //        answers.add("while (r != null && r.elem != 'M') {r = r.next;}");---8
    //        answers.add("h = new Node('A', new Node('B', new Node('C', new Node('D', null))));")
    //        ;----9
    //        answers.add("h.next.next.next = new Node('D', null);"); ----10

}