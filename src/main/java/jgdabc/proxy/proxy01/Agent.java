package jgdabc.proxy.proxy01;
//静态代理
public class Agent implements  Service{
    Service executiveService;
    public  Agent(Service service){
        this.executiveService  =  service;
    }
    @Override
    public void buy() {
        executiveService.buy();
    }
}
