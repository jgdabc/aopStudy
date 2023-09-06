package jgdabc.proxy.proxy01;

public class BookServiceImpl implements  Service{
    @Override
    public void buy() {
        System.out.println("图书购买业务");
    }
}
