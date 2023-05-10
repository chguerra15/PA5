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



}

