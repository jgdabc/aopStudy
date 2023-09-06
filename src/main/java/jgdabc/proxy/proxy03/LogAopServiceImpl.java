package jgdabc.proxy.proxy03;

public class LogAopServiceImpl implements Aop{
    @Override
    public void before() {
        System.out.println("日志开启");
    }

}
