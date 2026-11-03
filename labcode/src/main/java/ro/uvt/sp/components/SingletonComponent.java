package ro.uvt.sp.components;

import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {
    public SingletonComponent(){
        IO.println("SingletonComponnent::SingletonComponent = "+ this);
    }
    public void operation(){
        IO.println("Invoked SingletonComponent::operation() on "+ this);
    }
}
