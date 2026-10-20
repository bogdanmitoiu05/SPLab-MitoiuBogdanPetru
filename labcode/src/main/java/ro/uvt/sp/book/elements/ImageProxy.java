package ro.uvt.sp.book.elements;

public class ImageProxy extends Picture{
    private Image realImage = null;
    protected String imageData;
    public ImageProxy(String imageData) {
        this.imageData = imageData;
    }

    public Image loadImage(){
        if(realImage == null){
            realImage = new Image(imageData);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }
}
