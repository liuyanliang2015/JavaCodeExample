package com.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.CONSTRUCTOR;  
import static java.lang.annotation.ElementType.FIELD;  
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;  
import static java.lang.annotation.ElementType.METHOD;  
import static java.lang.annotation.ElementType.PACKAGE;  
import static java.lang.annotation.ElementType.PARAMETER;  
import static java.lang.annotation.ElementType.TYPE;  
/** 
 * @author Administrator 
 * 自定义用户注解 
 */
//@Documented
//注解是否将包含在JavaDoc中
  
//注解生命周期  ，什么时候使用该注解
//RetentionPolicy.SOURCE – 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。
//RetentionPolicy.CLASS – 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式。
//RetentionPolicy.RUNTIME– 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。

//注解的作用范围 设定作用构造器 字段 方法 包等  
//ElementType.TYPE:用于描述类、接口或enum声明
//ElementType.FIELD:用于描述实例变量
//ElementType.METHOD
//ElementType.PARAMETER
//ElementType.CONSTRUCTOR
//ElementType.LOCAL_VARIABLE
//ElementType.ANNOTATION_TYPE 另一个注释
//ElementType.PACKAGE 用于记录java文件的package信息
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})  
public @interface UserAnnotation {  
    //定义注解 的基本的  
    String name();  
    //定义属性值  
    String password();  
      
}  