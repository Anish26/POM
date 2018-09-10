package Week4Day1;

import org.testng.annotations.Test;

public class DependsOn_HW {

	@Test(dependsOnMethods="week4Day1.DependsOn-HW.test4,Week4Day1.DependsOn_HW.test3")
	public void test1() {
		System.out.println("i am test1");
	}
	@Test//(dependsOnMethods="test4")
	public void test2() {
		System.out.println("i am test2");
	}
	@Test//(dependsOnMethods="test4")
	public void test3() {
		System.out.println("i am test3");
	}
	@Test//(dependsOnMethods="test1")
	public void test4() {
		System.out.println("i am test4");
	}
	}


