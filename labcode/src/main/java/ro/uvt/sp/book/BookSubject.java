package ro.uvt.sp.book;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BookSubject {

    private List<BookObserver> observers;

    private BookSubject(){
        observers = new ArrayList<>();
    }

    public BookSubject bookSubject(){
        return new BookSubject();
    }
    public void registerObserver(BookObserver observer){
        observers.add(observer);
    }

    public void unregisterObserver(BookObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(Book b){
        for(BookObserver o : observers){
            o.update(b);
        }
    }
}
