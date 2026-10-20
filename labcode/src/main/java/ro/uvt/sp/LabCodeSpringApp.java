package ro.uvt.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ro.uvt.sp.components.ClientComponent;
import ro.uvt.sp.components.SingletonComponent;
import ro.uvt.sp.components.TransientComponent;
import ro.uvt.sp.controllers.HelloController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class LabCodeSpringApp {
    static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LabCodeSpringApp.class, args);

        TransientComponent transientBaen = ctx.getBean(TransientComponent.class);
        transientBaen.operation();

        SingletonComponent singletonComponent = ctx.getBean(SingletonComponent.class);
        singletonComponent.operation();

        singletonComponent = ctx.getBean(SingletonComponent.class);
        singletonComponent.operation();
        HelloController helloController;
        ClientComponent c = ctx.getBean(ClientComponent.class);
        c.operation();
        helloController = new HelloController(c);
        IO.println(helloController.sayHi());
        c = (ClientComponent) ctx.getBean("clientComponent");
        c.operation();
        helloController = new HelloController(c);
        IO.println(helloController.sayHi());


    }
}
