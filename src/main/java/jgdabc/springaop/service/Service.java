package jgdabc.springaop.service;

import jgdabc.springaop.entity.Student;


public interface Service {
    public void service();
    public Student serviceStudent();
    public Student serviceAroundAop(String args);
    public void afterService();

}
