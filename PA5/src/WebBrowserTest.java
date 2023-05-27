import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WebBrowserTest {

    @Test
    public void testOpenNewPage() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        assertEquals("facebook.com", browser.getCurrentPage());
        assertEquals(1, browser.getHistory().size());
        assertEquals("facebook.com", browser.getHistory().get(0));
    }

    @Test
    public void testPreviousPage() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.openNewPage("instagram.com");
        browser.previousPage();
        assertEquals("facebook.com", browser.getCurrentPage());
        browser.openNewPage("google.com");
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals("[facebook.com -> instagram.com -> facebook.com -> google.com]", browser.getHistory().toString());
    }

    @Test
    public void testGetCurrentPage() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.openNewPage("instagram.com");
        browser.previousPage();
        assertEquals("facebook.com", browser.getCurrentPage());
        browser.openNewPage("gmail.com");
        assertEquals("gmail.com", browser.getCurrentPage());
        browser.openNewPage("yahoo.com");
        assertEquals("yahoo.com", browser.getCurrentPage());
    }

    @Test
    public void testNextPage() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.openNewPage("instagram.com");
        browser.previousPage();
        browser.nextPage();
        assertEquals("instagram.com", browser.getCurrentPage());
        WebBrowser history = new WebBrowser();
        history.openNewPage("facebook.com");
        assertThrows(IllegalStateException.class, () -> history.nextPage());
    }

    @Test
    public void testgetHistory() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.openNewPage("instagram.com");
        browser.openNewPage("DSC30.com");
        assertEquals("[facebook.com -> instagram.com" +
                " -> DSC30.com]", browser.getHistory().toString());
    }


    @Test
    public void testNewTab() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.newTab();
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(1, browser.getHistory().size());

    }

    @Test
    public void testFindLink() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        assertTrue(browser.findLink("facebook.com"));
        assertEquals("facebook.com", browser.getCurrentPage());
        assertEquals(2, browser.getHistory().size());
    }

    @Test
    public void testFindLinkNotFound() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        assertFalse(browser.findLink("yahoo.com"));
        assertEquals("facebook.com", browser.getCurrentPage());
        assertEquals(1, browser.getHistory().size());
    }

    @Test
    void basicNavigation() {
        WebBrowser browser = new WebBrowser();

        // Initial state
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(0, browser.getHistory().size());

        // Open new page
        browser.openNewPage("example.com");
        assertEquals("example.com", browser.getCurrentPage());
        assertEquals(1, browser.getHistory().size()); // Includes "example.com"
        assertFalse(browser.getHistory().contains("google.com"));
        assertTrue(browser.getHistory().contains("example.com"));

        // Open another new page
        browser.openNewPage("stackoverflow.com");
        assertEquals("stackoverflow.com", browser.getCurrentPage());
        assertEquals(2, browser.getHistory().size()); // Includes "example.com" and "stackoverflow.com"
        assertFalse(browser.getHistory().contains("google.com"));
        assertTrue(browser.getHistory().contains("stackoverflow.com"));

        // Navigate to previous page
        browser.previousPage();
        assertEquals("example.com", browser.getCurrentPage());
        assertEquals(3, browser.getHistory().size()); // Includes "example.com" and "stackoverflow.com"
        assertFalse(browser.getHistory().contains("google.com"));
        assertTrue(browser.getHistory().contains("example.com"));

        // Navigate to next page
        browser.nextPage();
        assertEquals("stackoverflow.com", browser.getCurrentPage());
        assertEquals(4, browser.getHistory().size()); // Includes "example.com" and "stackoverflow.com"
        assertFalse(browser.getHistory().contains("google.com"));
        assertTrue(browser.getHistory().contains("stackoverflow.com"));

        // Open new tab
        browser.newTab();
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(4, browser.getHistory().size()); // History remains unchanged
        assertFalse(browser.getHistory().contains("google.com"));

        // Search and navigate to existing link
        assertTrue(browser.findLink("example.com"));
        assertEquals("example.com", browser.getCurrentPage());
        assertEquals(5, browser.getHistory().size()); // Includes "example.com" and "stackoverflow.com"
        assertFalse(browser.getHistory().contains("google.com"));
        assertTrue(browser.getHistory().contains("example.com"));

        // Search for non-existing link
        assertFalse(browser.findLink("nonexistent.com"));
        assertEquals("example.com", browser.getCurrentPage());
        assertEquals(5, browser.getHistory().size()); // History remains unchanged

        // Search and navigate to existing link in a new tab
        browser.newTab();
        assertTrue(browser.findLink("stackoverflow.com"));
        assertEquals("stackoverflow.com", browser.getCurrentPage());
        assertEquals(6, browser.getHistory().size()); // Includes "example.com" and "stackoverflow.com"
        assertFalse(browser.getHistory().contains("google.com"));
        assertTrue(browser.getHistory().contains("stackoverflow.com"));
    }

    @Test
    void navigationExceptions() {
        WebBrowser browser = new WebBrowser();

        // Trying to navigate to previous page without history
        assertThrows(IllegalStateException.class, browser::previousPage);

        // Trying to navigate to next page without history
        assertThrows(IllegalStateException.class, browser::nextPage);
    }

    @Test
    void pageNavigation() {
        WebBrowser browser = new WebBrowser();

        // Initial state
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(0, browser.getHistory().size());

        // Open new page
        browser.openNewPage("example.com");
        assertEquals("example.com", browser.getCurrentPage());
        assertEquals(1, browser.getHistory().size());
        assertTrue(browser.getHistory().contains("example.com"));
        // Navigate to previous page
        browser.previousPage();
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(2, browser.getHistory().size());
        assertTrue(browser.getHistory().contains("google.com"));
        browser.nextPage();
        assertEquals("example.com", browser.getCurrentPage());
        assertThrows(IllegalStateException.class, browser::nextPage);
    }



}

