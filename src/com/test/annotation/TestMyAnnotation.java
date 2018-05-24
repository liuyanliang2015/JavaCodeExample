package com.test.annotation;

@UserAnnotation(name="zhangsan", password = "123456")  
public class TestMyAnnotation {  
      
    public static void main(String[] args) {  
        //使用反射进行参数注解  
        UserAnnotation annotation=TestMyAnnotation.class.getAnnotation(UserAnnotation.class);  
        //测试注解  
        System.out.println(annotation.name()+"__"+annotation.password());  
    }  
}  