package com.cxp.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by CXP on 2016/12/30
 * desc :
 * q978515743@163.com
 */

/**
 * @Before           该方法在每次测试方法调用前都会调用
 * @Test             说明了该方法需要测试
 * @BeforeClass      该方法在所有测试方法之前调用，只会被调用一次
 * @After            该方法在每次测试方法调用后都会调用
 * @AfterClass       该方法在所有测试方法之后调用，只会被调用一次
 * @Ignore           忽略该方法
 */

/**
 * @Before: 标识在运行测试方法之前运行的代码。可以支持同一个Class中有多个@Before，但是这些方法的执行顺序是随机的。该注解替代了JUnit 3中的setUp()方法。
 * @After: 标识在运行测试方法结束之后运行的代码。可以在其中做一些释放资源的操作。该注解替代了JUnit 3中的tearDown()方法。
 * @Test: 标识一个测试方法。一个测试类中可以有多个测试方法，每个测试方法需要用一个@Test注解来标识。
 * @Rule: 简单来说，是为各个测试方法提供一些支持。具体来说，比如我需要测试一个Activity，那么我可以在@Rule注解下面采用一个ActivityTestRule，该类提供了对相应Activity的功能测试的支持。该类可以在@Before和@Test标识的方法执行之前确保将Activity运行起来，并且在所有@Test和@After方法执行结束之后将Activity杀死。在整个测试期间，每个测试方法都可以直接对相应Activity进行修改和访问。
 * @BeforeClass: 为测试类标识一个static方法，在测试之前只执行一次。
 * @AfterClass: 为测试类标识一个static方法，在所有测试方法结束之后只执行一次。
 * @Test(timeout=<milliseconds>): 为测试方法设定超时时间。
 */
public class JUnitTest {

    //该方法在所有测试方法之前调用，只会被调用一次
    @BeforeClass
    public static void prepareDataForTest() {
        System.out.println("-----------prepareDataForTest--------------");
    }

    //该方法在每次测试方法调用前都会调用
    @Before
    public void init() {
        System.out.println("-----------init--------------");
    }

    //说明了该方法需要测试
    @Test
    public void test1() {
        System.out.println("-----------test1--------------");
    }

    @Test
    public void test2() {
        System.out.println("-----------test2--------------");
    }

    //忽略该方法
    @Ignore
    public void test3() {
        System.out.println("-----------test3--------------");
    }

    //该方法在每次测试方法调用后都会调用
    @After
    public void clearDataForTest() {
        System.out.println("-----------clearDataForTest--------------");
    }

    //该方法在所有测试方法之后调用，只会被调用一次
    @AfterClass
    public static void finish(){
        System.out.println("------finish------");
    }

}
