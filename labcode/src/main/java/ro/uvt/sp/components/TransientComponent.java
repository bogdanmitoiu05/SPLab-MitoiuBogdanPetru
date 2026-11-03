package ro.uvt.sp.components;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransientComponent {
    public TransientComponent(){
        IO.println("TransientComponent::TransientComponent = " + this);
    }
    public void operation(){
        IO.println("Invoked TransientComponent::operation() on" + this);
    }
}
