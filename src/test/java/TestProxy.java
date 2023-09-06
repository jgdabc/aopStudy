import jgdabc.proxy.proxy01.Agent;
import jgdabc.proxy.proxy01.BookServiceImpl;
import jgdabc.proxy.proxy01.ProductServiceImpl;
import jgdabc.proxy.proxy02.Agent01;
import jgdabc.proxy.proxy02.TranslationAop;
import jgdabc.proxy.proxy03.Agent02;
import jgdabc.proxy.proxy03.Service;
import jgdabc.proxy.proxy03.TranslationAopImpl;
import org.junit.Test;

public class TestProxy {
    @Test
    public void testProxy01(){
//        Agent01 这个类相当于代理员，Service是接口，BookServiceImpl 和 ProductServiceImpl 是两个实现功能，我们想要去干什么事情
//        是去做图书业务还是产品业务都去找代理Agent帮助去做了，这是静态代理
        Agent agent = new Agent(new BookServiceImpl());
        agent.buy();
        Agent agent1 = new Agent(new ProductServiceImpl());
        agent1.buy();

    }
    @Test
    public void testProxy02()
    {
        Agent01 agent01 = new Agent01(new TranslationAop(),new jgdabc.proxy.proxy02.BookServiceImpl());
        agent01.buy();
    }
    @Test
    public void testProxy03()
    {
        Service service = (Service) Agent02.objectGetAgent(new jgdabc.proxy.proxy03.BookServiceImpl(), new TranslationAopImpl());
        System.out.println(service.getClass());
        service.buy();


    }
}
