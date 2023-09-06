package jgdabc.proxy.proxy03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agent02  {
    public static Object objectGetAgent(Service execution, Aop aop) {
        return Proxy.newProxyInstance(
                //获取到类加载器
                execution.getClass().getClassLoader(),//加载代理类的字节码，获取对应类加载器
//                获取到所有的业务接口
                execution.getClass().getInterfaces(),//为代理接口需要实现的接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop.before();
                        Object obj = method.invoke(execution, args);
                        aop.after();
                        return obj;//返回目标方法的返回值
                    }
                }

        );
    }

}

