package website.automate.manager.api.client.support;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConstantsTest {

    @Test
    public void apiUrlIsCorrect() {
        Constants.setBaseUrl(null);
        assertEquals(Constants.getApiBaseUrl(), "https://automate.website/api");
    }
    
    @Test
    public void appUrlIsCorrect() {
        Constants.setBaseUrl(null);
        assertEquals(Constants.getAppBaseUrl(), "https://automate.website/app");
    }
}
