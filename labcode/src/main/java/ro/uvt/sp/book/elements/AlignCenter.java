package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.Page;

public class AlignCenter implements AlignmentStrategy{
    @Override
    public void render(Paragraph paragraph, Page pageContext) {
        long totalInset = pageContext.getTotalColumns() - paragraph.getContent().length();
        long leadingInset = totalInset/2-paragraph.getContent().length()/2;
        long trailingInset = totalInset-leadingInset;
        StringBuilder stringBuilder = new StringBuilder();
        for(long i = 0; i < leadingInset; ++i)
            stringBuilder.append(' ');
        stringBuilder.append(paragraph.getContent());
        for(long i = 0; i < trailingInset; ++i)
            stringBuilder.append(' ');
        IO.println(String.format("Paragraph: %s|", stringBuilder));
    }
}
