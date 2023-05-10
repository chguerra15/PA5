/*
 * NAME: Christian Guerra
 * PID:  A17660168
 */

/**
 * Class that simulates basic web browser
 *
 * @author Christian Guerra
 * @since May 8th 2023
 */

/**
 * Represents a web browser that allows the user to navigate web pages.
 */
public class WebBrowser {

    private String currentPage; // The URL of the currently open page
    private MyArrayList<String> history; // A list of URLs visited in the current session
    private MyStack<String> prev; // A stack of URLs for the previous pages visited
    private MyStack<String> next; // A stack of URLs for the next pages to visit

    private static final String DEFAULT_PAGE = "google.com";

    public WebBrowser() {
        currentPage = DEFAULT_PAGE;
        history = new MyArrayList<String>(1);
        prev = new MyStack<String>();
        next = new MyStack<String>();
    }

    /**
     * Returns the URL of the currently open page.
     * @return The URL of the currently open page
     */
    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * Opens a new page with the specified URL, pushing the current page onto the
     * previous pages stack.
     * @param newLink The URL of the new page to open
     */
    public void openNewPage(String newLink) {
        prev.push(currentPage);
        currentPage = newLink;
        next = new MyStack<String>();
        history.add(currentPage);
    }

    /**
     * Navigates to the previous page in the history, pushing the current page onto
     * the next pages stack.
     * @throws IllegalStateException if there is no previous page to navigate to
     */
    public void previousPage() {
        if (prev.isEmpty()) {
            throw new IllegalStateException();
        }
        next.push(currentPage);
        currentPage = prev.pop();
        history.add(currentPage);
    }

    /**
     * Navigates to the next page in the history, pushing the current page onto the
     * previous pages stack.
     * @throws IllegalStateException if there is no next page to navigate to
     */
    public void nextPage() {
        if (next.isEmpty()) {
            throw new IllegalStateException();
        }
        prev.push(currentPage);
        currentPage = next.pop();
        history.add(currentPage);
    }

    /**
     * Opens a new tab, resetting the previous and next page stacks and opening the
     * default page.
     */
    public void newTab() {
        prev = new MyStack<String>();
        next = new MyStack<String>();
        currentPage = DEFAULT_PAGE;
    }

    /**
     * Returns a list of URLs visited in the current session.
     * @return A list of URLs visited in the current session
     */
    public MyArrayList<String> getHistory() {
        return history;
    }

    /**
     * Searches the history for the specified URL and navigates to it if found.
     * @param link The URL to search for
     * @return true if the URL was found in the history and navigated to, false otherwise
     */
    public boolean findLink(String link) {
        if (history.contains(link)) {
            openNewPage(link);
            return true;
        }
        return false;
    }
}
