package ro.uvt.sp.book.elements;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Image extends Picture implements Element{
    public Image(String imageData) {
        super(imageData);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.imageData = imageData;
    }

    @Override
    public void print() {
        IO.println(String.format("Image %s", imageData));
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(imageData, image.imageData);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imageData);
    }

}
