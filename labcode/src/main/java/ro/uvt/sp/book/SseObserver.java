package ro.uvt.sp.book;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver implements BookObserver{
    private final SseEmitter emitter;


    public SseObserver(SseEmitter emitter){
        this.emitter = emitter;
    }

    @Override
    public void update(Book b) {
        try {
            IO.println(String.format("%s %d",b.getTitle(), b.getId()));
            emitter.send(b, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
