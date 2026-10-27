package ro.uvt.sp.book.elements;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class ElementContainer extends Element {
    @Override
    public final void print() {
        beforePrint();
        for(var element: elementList){
            element.print();
        }
        afterPrint();
    }
    @OneToMany
    @JoinColumn(name = "element_id")
    protected List<Element> elementList;

    protected void beforePrint(){}

    protected ElementContainer(){
        elementList = new ArrayList<>();
    }
    protected void afterPrint(){}
    public final void add(Element e){
        elementList.add(e);
    }
    public final void remove(Element e){
        elementList.remove(e);
    }

    public final Element get(int idx){
        return elementList.get(idx);
    }
}
