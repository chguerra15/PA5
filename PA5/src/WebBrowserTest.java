import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WebBrowserTest {

    @Test
    public void testOpenNewPage() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        assertEquals("facebook.com", browser.getCurrentPage());
        assertEquals(2, browser.getHistory().size()); // includes default page and facebook.com
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
    public void testNextPage() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.openNewPage("instagram.com");
        browser.previousPage();
        browser.nextPage();
        assertEquals("instagram.com", browser.getCurrentPage());
    }


    @Test
    public void testNewTab() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        browser.newTab();
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(2, browser.getHistory().size()); // includes default page and facebook.com
    }

    @Test
    public void testFindLink() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        assertTrue(browser.findLink("google.com"));
        assertEquals("google.com", browser.getCurrentPage());
        assertEquals(3, browser.getHistory().size()); // includes default page, facebook.com, and google.com
    }

    @Test
    public void testFindLinkNotFound() {
        WebBrowser browser = new WebBrowser();
        browser.openNewPage("facebook.com");
        assertFalse(browser.findLink("yahoo.com"));
        assertEquals("facebook.com", browser.getCurrentPage());
        assertEquals(2, browser.getHistory().size()); // includes default page and facebook.com
    }

}

