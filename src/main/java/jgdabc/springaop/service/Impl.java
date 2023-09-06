package jgdabc.springaop.service;

import jgdabc.springaop.entity.Student;
import org.springframework.stereotype.Component;

@Component("Impl")
public class Impl implements Service{
    @Override
    public void service() {
        System.out.println("方法执行");
    }

    @Override
    public Student serviceStudent() {
        Student student = new Student();
        student.setAge(100);
        student.setName("Make");
        System.out.println("原来的对象student"+student);
        return  student;
    }

    @Override
    public Student serviceAroundAop(String args) {
        System.out.println("ServiceAroundAop 执行----");
        return  new Student("asa",111);

    }

    @Override
    public void afterService() {
//        让方法报一个错，然后验证最终通知一定会执行
        //int  i = 1/0;
    }


}
