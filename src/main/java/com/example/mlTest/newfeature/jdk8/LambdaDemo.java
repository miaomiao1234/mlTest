package com.example.mlTest.newfeature.jdk8;

/**
 * @author miaoliang
 * @since 5/9/21 8:04 PM
 *
 * Lambda 表达式，也可称为闭包
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 *
 * Lambda 表达式的重要特征
 *  1. 可选类型声明 （不需要声明参数类型，编译器可以统一识别参数值）
 *  2. 可选的参数圆括号 （一个参数无需定义圆括号，多个参数需要定义圆括号）
 *  3. 可选的大括号 （如果主体包含了一个语句，就不需要使用大括号）
 *  4. 可选的返回关键字 （如果主体只有一个表达式返回值，则编译器会自动返回值，大括号需要指明表达式反悔了一个数值）
 *  5. lambda 只能访问外层引用了 final 的局部变量，也就是说不能再 lambda 内部修改定义在域外的局部变量
 *
 *  优点：
 *      Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 */
public class LambdaDemo {
    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
//        int a = 1;   //lambda 不允许声明一个与局部变量相同的参数或者局部变量，放开此代码 lambda 表达式中的 参数 a 会报错
        // 不声明参数类型
        MathOperation addition = (a, b) -> {return a + b;};
        // 声明参数类型
        MathOperation subtraction = (int a, int b) -> {return a - b;};
        // 大括号需指明返回值
        MathOperation multiplication = (a, b) -> {return a * b;};
        // 主体只有一个表达式自动返回值
        MathOperation division = (a, b) -> a / b;
        // 只有一个参数可不用括号
        // 访问 lambda 外部的局部变量
        final String s = "Hello ";  // final可省略
        GreetingService greetingService = msg -> System.out.println(s + msg);
        int x = 1;
        MathOperation finalDemo = (a, b) -> a + b * x;
//        x = 2;  // x final 可以省略，但是之后不能更改 x 的值，实际上还是final

        System.out.println("10 + 5 = " + lambdaDemo.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaDemo.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaDemo.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaDemo.operate(10, 5, division));
        greetingService.sayHello("ml");

        new InnerClassTest(){
            @Override
            void demo() {
                System.out.println("匿名内部类测试。。。");
            }
        }.demo();

    }

    // 定义函数式接口，该接口中有且仅有一个抽象接口
    @FunctionalInterface
    interface MathOperation{
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface GreetingService{
        void sayHello(String msg);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
