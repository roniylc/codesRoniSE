package org.hbrs.se1.ws24.exercises.uebung4.eigeneLoesung;

import java.util.List;

public class Client {

    public static void main(String[] args) throws ContainerException, PersistenceException{
        Container container = Container.getInstance();
        container.eingabe();
    }

}
