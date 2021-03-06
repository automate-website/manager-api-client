/*
 * This file was automatically generated by EvoSuite
 * Thu Nov 23 09:05:08 CET 2017
 */

package website.automate.manager.api.client.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProjectTest  {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Project project0 = new Project();
      project0.setTitle("7");
      String string0 = project0.getTitle();
      assertEquals("7", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Project project0 = new Project();
      project0.setScenarios((List<Scenario>) null);
      List<Scenario> list0 = project0.getScenarios();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Project project0 = new Project();
      ArrayList<Scenario> arrayList0 = new ArrayList<Scenario>();
      Scenario scenario0 = new Scenario();
      arrayList0.add(0, scenario0);
      project0.setScenarios(arrayList0);
      List<Scenario> list0 = project0.getScenarios();
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Project project0 = new Project();
      List<Scenario> list0 = project0.getScenarios();
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Project project0 = new Project();
      String string0 = project0.getTitle();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Project project0 = new Project();
      project0.setTitle("");
      String string0 = project0.getTitle();
      assertEquals("", string0);
  }
}
