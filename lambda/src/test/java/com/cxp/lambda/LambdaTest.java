package com.cxp.lambda;

import org.junit.Test;

/**
 * @author CXP
 * @desc Lambda用法
 * @time 2017/1/12 16:13
 * @email q978515743@163.com
 */

/**
 * //示例1：不需要接受参数，直接返回10
 * ()->10
 * //示例2：接受两个int类型的参数，并返回这两个参数相加的和
 * (int x,int y)->x+y;
 * //示例2：接受x,y两个参数，该参数的类型由JVM根据上下文推断出来，并返回两个参数的和
 * (x,y)->x+y;
 * //示例3：接受一个字符串，并将该字符串打印到控制到，不反回结果
 * (String name)->System.out.println(name);
 * //示例4：接受一个推断类型的参数name，并将该字符串打印到控制台
 * name->System.out.println(name);
 * //示例5：接受两个String类型参数，并分别输出，不反回
 * (String name,String sex)->{System.out.println(name);System.out.println(sex)}
 * //示例6：接受一个参数x，并返回该该参数的两倍
 * x->2*x
 */
public class LambdaTest {

    /**
     * (parameters) -> expression  或者 (parameters) -> { statements; }
     * paramaters：类似方法中的形参列表，这里的参数是函数式接口里的参数。这里的参数类型可以明确的声明也可不声明而由JVM隐含的推断1。另外当只有一个推断类型时可以省略掉圆括号。示例：parameters->statements
     * ->：可理解为“被用于”的意思
     * 方法体：可以是表达式也可以代码块，是函数式接口里方法的实现。代码块可返回一个值或者什么都不反回，这里的代码块块等同于方法的方法体。如果是表达式，也可以返回一个值或者什么都不反回。
     */
    @Test
    public void demo1() {
        //常规用法
//        Converter<String ,Integer> converter=new Converter<String, Integer>() {
//            @Override
//            public Integer convert(String from) {
//                return Integer.valueOf(from);
//            }
//        };
//
//        Integer result = converter.convert("200");
//        System.out.println(result);

        //Lambda用法
        Converter<String, Integer> converter = (param) -> Integer.valueOf(param);
        Integer result = converter.convert("200");
        System.out.println(result);
    }

    /**
     * ObjectRef::methodName
     * 左边可以是类名或者实例名，中间是方法引用符号”::”，右边是相应的方法名。方法引用被分为三类：
     */
    @Test
    public void demo2() {
        //第一种方案：静态方法引用
//        demo2_1();
        //第二种方案：实例方法引用
//        demo2_2();
        //第三种方案：构造方法引用
        demo2_3();
    }

    //第一种方案：静态方法引用
    public void demo2_1() {
        //常规用法
//        Converter<String ,Integer> converter=new Converter<String, Integer>() {
//            @Override
//            public Integer convert(String from) {
//                return LambdaTest.String2Int(from);
//            }
//        };
//        Integer result = converter.convert("200");
//        System.out.println(result);

        //Lambda用法
        Converter<String, Integer> converter = LambdaTest::String2Int;
        Integer result = converter.convert("200");
        System.out.println(result);
    }

    //第二种方案：实例方法引用
    public void demo2_2() {
        //常规用法
//        Converter<String ,Integer> converter=new Converter<String, Integer>() {
//            @Override
//            public Integer convert(String from) {
//                return new Helper().String2Int(from);
//            }
//        };
//        Integer result = converter.convert("200");
//        System.out.println(result);

        //Lambda用法
        Converter<String, Integer> converter = new Helper()::String2Int;
        Integer result = converter.convert("200");
        System.out.println(result);
    }

    //第三种方案：构造方法引用
    public void demo2_3() {
        //常规用法
//        Factory factory = new Factory() {
//            @Override
//            public User create(String name, int age) {
//                Teacher teacher=new Teacher(name, age);
//                teacher.say();
//                return teacher;
//            }
//        };
//        factory.create("老王", 30);
//
//        factory = new Factory() {
//            @Override
//            public User create(String name, int age) {
//                Student student=new Student(name,age);
//                student.say();
//                return student;
//            }
//        };
//        factory.create("小明", 15);

        //Lambda用法
        Factory<Teacher> teacherFactory = Teacher::new;
        Teacher teacher = teacherFactory.create("老王", 30);
        teacher.say();
        Factory<Student> studentFactory = Student::new;
        Student student = studentFactory.create("小明", 15);
        student.say();
    }

    //demo2使用
    static int String2Int(String from) {
        return Integer.valueOf(from);
    }

    //demo2使用
    static class Helper {
        public int String2Int(String from) {
            return Integer.valueOf(from);
        }
    }
}
