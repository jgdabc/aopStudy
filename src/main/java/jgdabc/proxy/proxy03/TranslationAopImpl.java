package jgdabc.proxy.proxy03;

public class TranslationAopImpl implements Aop {
    @Override
    public void before() {
        System.out.println("事务开启");
    }

    @Override
    public void after() {
        System.out.println("事务提交");
    }

    @Override
    public void exception() {
//        Aop.super.exception();
        System.out.println("事务回滚");
    }
}
