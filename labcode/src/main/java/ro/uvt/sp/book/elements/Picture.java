package ro.uvt.sp.book.elements;

public abstract class Picture implements Element{
    protected String imageData;
    public Picture(String imageData){
        this.imageData = imageData;
    }
}
