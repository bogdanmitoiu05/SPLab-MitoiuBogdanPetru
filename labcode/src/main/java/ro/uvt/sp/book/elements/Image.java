package ro.uvt.sp.book.elements;

import java.util.Objects;

public class Image implements Element{
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        IO.println(String.format("Image %s", url));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }

}
