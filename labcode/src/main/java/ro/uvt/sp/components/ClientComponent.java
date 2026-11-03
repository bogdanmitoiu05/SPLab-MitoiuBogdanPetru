package ro.uvt.sp.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientComponent {
    private final TransientComponent tc;
    private final SingletonComponent sc;

    @Autowired
    public ClientComponent(TransientComponent tc, SingletonComponent sc){
        this.tc = tc;
        this.sc = sc;
        IO.println("ClientComponent::ClientComponent = " + this);
        IO.println("\to SingletonComponent = " + sc);
        IO.println("\to TransientComponent = " + tc);
    }

    public void operation(){
        IO.println("Invoked ClientCOmponent::operation() on" + this);
        IO.println("\to SingletonComponent = " + sc);
        IO.println("\to TransientComponent = " + tc);
    }
}
