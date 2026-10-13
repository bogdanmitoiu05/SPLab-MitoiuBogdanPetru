package ro.uvt.sp;

import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.elements.*;
import ro.uvt.sp.book.operations.StatisticsVisitor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        Book myBook = new Book("Carte");
        myBook.add(cap1);
        StatisticsVisitor stats = new StatisticsVisitor();
        myBook.accept(stats);
        stats.printStats();

    }
}
