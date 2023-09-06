package jgdabc.proxy.proxy02;

public class LogAop implements Aop{


    @Override
    public void beforeAop() {

        System.out.println("前置日志前面执行'");
    }
}
