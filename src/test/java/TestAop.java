import jgdabc.springaop.entity.Student;
import jgdabc.springaop.service.Service;
import jgdabc.springaop.service.Impl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void TestAopBefore() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Service service = (Service) ac.getBean("Impl");
        service.service();
    }

    @Test
    public void TestAopAfterReturning() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Service service = (Service) ac.getBean("Impl");
        Student student = service.serviceStudent();
        System.out.println(student);
    }

    @Test
    public void testAroundAop() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Service service = (Service) ac.getBean("Impl");
        service.serviceAroundAop("张三");
    }

    @Test
    public void testAfter() {
        {
            ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
            Service service = (Service) ac.getBean("Impl");
            System.out.println(service);
            System.out.println(service.getClass());//取出的是代理对象
            service.afterService();
//            开启cglib的代理后可以使用
//             Impl service01 = (Impl) ac.getBean("Impl");//一般不怎么用
//            service01.afterService();
        }

    }
}
