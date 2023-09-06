package jgdabc.proxy.proxy02;

public class TranslationAop implements Aop{
    @Override
    public void beforeAop() {
        System.out.println("事务开启");
    }

    @Override
    public void AfterAop() {
        System.out.println("事务提交");
    }

    @Override
    public void ExceptionAop() {
        System.out.println("事务回滚");
    }
}
