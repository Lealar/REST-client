package com.epam.rd.izh;

import com.epam.rd.izh.configuration.MyConfig;

import com.epam.rd.izh.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        communication.deleteUser(14);
        /*User user = new User(15, "Dmitriy","Kuplinov","KuplinovPlay",	"SOLS",	"customer");
        communication.saveUser(user);*/

    }
}
