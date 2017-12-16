package website.automate.manager.api.client.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AbstractEntityTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Project project0 = new Project();
      project0.setId("X");
      String string0 = project0.getId();
      assertEquals("X", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Job job0 = new Job();
      job0.setId("");
      String string0 = job0.getId();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Box box0 = new Box();
      box0.setId("ENUM$VALUES");
      Box box1 = new Box();
      assertFalse(box1.equals((Object)box0));
      
      box1.setId("ENUM$VALUES");
      boolean boolean0 = box0.equals(box1);
      assertTrue(box1.equals((Object)box0));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Scenario scenario0 = new Scenario();
      Scenario scenario1 = new Scenario();
      assertTrue(scenario1.equals((Object)scenario0));
      
      scenario1.setId("");
      boolean boolean0 = scenario0.equals(scenario1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Scenario scenario0 = new Scenario();
      Scenario scenario1 = new Scenario();
      boolean boolean0 = scenario0.equals(scenario1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Job job0 = new Job();
      Scenario scenario0 = new Scenario();
      boolean boolean0 = job0.equals(scenario0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Scenario scenario0 = new Scenario();
      boolean boolean0 = scenario0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Job job0 = new Job();
      String string0 = job0.getId();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Box box0 = new Box();
      box0.setId("");
      Box box1 = new Box();
      boolean boolean0 = box0.equals(box1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Box box0 = new Box();
      box0.hashCode();
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Scenario scenario0 = new Scenario();
      boolean boolean0 = scenario0.equals(scenario0);
      assertTrue(boolean0);
  }
}
