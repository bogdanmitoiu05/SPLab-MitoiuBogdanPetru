package ro.uvt.sp.book;

import java.util.Objects;

public class Page {
    long totalColumns;

    public Page(long totalColumns) {
        this.totalColumns = totalColumns;
    }

    public long getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(long totalColumns) {
        this.totalColumns = totalColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return totalColumns == page.totalColumns;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(totalColumns);
    }
}
