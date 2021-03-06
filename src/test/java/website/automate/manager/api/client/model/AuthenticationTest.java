package website.automate.manager.api.client.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void hashCodeEquals() {
        Authentication left = Authentication.of("admin", "secret");
        Authentication right = Authentication.of("admin", "secret");

        assertEquals(left.hashCode(), right.hashCode());
    }

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        Authentication authentication0 = Authentication.of("P", "");
        String string0 = authentication0.getUsername();
        assertEquals("", authentication0.getPassword());
        assertEquals("P", string0);
    }

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        Authentication authentication0 = Authentication.of("", "");
        String string0 = authentication0.getUsername();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test2() throws Throwable {
        Authentication authentication0 = Authentication.of((String) null, "9");
        String string0 = authentication0.getPassword();
        assertEquals("9", string0);
    }

    @Test(timeout = 4000)
    public void test3() throws Throwable {
        Authentication authentication0 = Authentication.of((String) null, "");
        String string0 = authentication0.getPassword();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test4() throws Throwable {
        Authentication authentication0 = Authentication.of((String) null, (String) null);
        String string0 = authentication0.getPassword();
        assertNull(string0);
    }

    @Test(timeout = 4000)
    public void test5() throws Throwable {
        Authentication authentication0 = Authentication.of((String) null, (String) null);
        authentication0.setUsername("");
        assertEquals("", authentication0.getUsername());
    }

    @Test(timeout = 4000)
    public void test6() throws Throwable {
        Authentication authentication0 = Authentication.of("", "");
        authentication0.setPassword("");
        assertEquals("", authentication0.getPassword());
    }

    @Test(timeout = 4000)
    public void test7() throws Throwable {
        Authentication authentication0 = Authentication.of((String) null, (String) null);
        String string0 = authentication0.getUsername();
        assertNull(string0);
    }
}
