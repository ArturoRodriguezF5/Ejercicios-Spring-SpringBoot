package org.arthycode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /* Ejercicio 1 ------------------------
         * 1: Le pedimos a Spring el bean llamado saludo
         * 2: Mandamos a llamar el método imprimirSaludo
         * */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Saludo saludo = (Saludo) context.getBean("saludo");

        saludo.imprimeSaludo();
        /* Ejercicio 2 ------------------------
         * 1: Le pedimos a Spring el bean llamado saludo
         * 2: Mandamos a llamar el método imprimirSaludo
         * */
          ApplicationContext context2 = new ClassPathXmlApplicationContext("beans2.xml");
          UserService user = context2.getBean(UserService.class);
          user.notificationService.imprimeSaludo();
    }
}
