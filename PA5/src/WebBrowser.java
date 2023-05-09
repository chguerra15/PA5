/*
 * NAME: TODO Christian Guerra
 * PID: TODO A17660168
 */

/**
 * TODO
 *
 * @author Christian Guerra
 * @since May 8th 2023
 */

/**
 * Represents a web browser that allows the user to navigate web pages.
 */
public class WebBrowser {

    private String currentPage;
    private MyArrayList<String> history;
    private MyStack<String> prev;
    private MyStack<String> next;

    private static final String DEFAULT_PAGE = "google.com";

    public WebBrowser() {
        currentPage = DEFAULT_PAGE;
        history = new MyArrayList<String>(1);
        prev = new MyStack<String>();
        next = new MyStack<String>();
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void openNewPage(String newLink) {
        prev.push(currentPage);
        currentPage = newLink;
        history.add(currentPage);

    }

    public void previousPage() {
        if (prev.isEmpty()) {
            throw new IllegalStateException("No previous page found");
        }
        next.push(currentPage);
        currentPage = prev.pop();
        history.add(currentPage);
    }

    public void nextPage() {
        if (next.isEmpty()) {
            throw new IllegalStateException("No next page found");
        }
        prev.push(currentPage);
        currentPage = next.pop();
        history.add(currentPage);
    }

    public void newTab() {
        prev.push(currentPage);
        currentPage = DEFAULT_PAGE;
    }

    public MyArrayList<String> getHistory() {
        return history;
    }

    public boolean findLink(String link) {
        if (history.contains(link)) {
            openNewPage(link);
            return true;
        }
        return false;
    }
}

