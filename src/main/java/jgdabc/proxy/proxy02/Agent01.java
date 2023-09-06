package jgdabc.proxy.proxy02;

public class Agent01 implements Service{
    Aop aop;
    Service excutiveService;
    public Agent01(Aop aop, Service  service)
    {
        this.aop  =  aop;
        this.excutiveService =  service;
    }
    @Override
    public void buy() {

        aop.beforeAop();
        try {
            excutiveService.buy();
            aop.AfterAop();
        } catch (Exception e) {
            aop.ExceptionAop();
            throw new RuntimeException(e);

        }


    }
}
