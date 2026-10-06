package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.Page;

public class AlignTrailing implements AlignmentStrategy{
    @Override
    public void render(Paragraph paragraph, Page pageContext) {
        long leadingInset = pageContext.getTotalColumns() - paragraph.getContent().length();
        StringBuilder stringBuilder = new StringBuilder();
        for(long i = 0; i < leadingInset; ++i)
            stringBuilder.append(' ');
        stringBuilder.append(paragraph.getContent());
        IO.println(String.format("Paragraph: %s|", stringBuilder));
    }
}
