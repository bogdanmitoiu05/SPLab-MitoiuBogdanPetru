package ro.uvt.sp.book.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class ImageProxy extends Picture{
    @Transient
    private Image realImage = null;
    protected String imageURI;
    public ImageProxy(String imageURI) {
        this.imageURI = imageURI;
    }

    public ImageProxy() {

    }

    public Image loadImage(){
        if(realImage == null){
            realImage = new Image(imageURI);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }
}
