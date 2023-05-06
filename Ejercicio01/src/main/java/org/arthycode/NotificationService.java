package org.arthycode;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public void imprimeSaludo() {
        System.out.println("Hola desde la clase NotificationService");
    }
}
