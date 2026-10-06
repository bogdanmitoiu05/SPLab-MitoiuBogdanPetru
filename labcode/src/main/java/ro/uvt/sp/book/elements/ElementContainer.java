package ro.uvt.sp.book.elements;

import java.util.ArrayList;
import java.util.List;

public class ElementContainer implements Element {
    @Override
    public final void print() {
        beforePrint();
        for(var element: elementList){
            element.print();
        }
        afterPrint();
    }
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
