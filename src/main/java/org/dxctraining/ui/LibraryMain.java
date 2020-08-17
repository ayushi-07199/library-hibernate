package org.dxctraining.ui;

import org.dxctraining.config.Configure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(Configure.class);
        context.refresh();
    }
}
