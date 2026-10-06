package ro.uvt.sp;

import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.elements.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1", 100);
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2", 100);
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3", 100);
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4",100);
        cap1.add(p4);
        System.out.println("Printing without Alignment");
        System.out.println();
        cap1.print();
        p1.setAlignmentStrategy(new AlignCenter());
        p2.setAlignmentStrategy(new AlignTrailing());
        p3.setAlignmentStrategy(new AlignLeading());

        System.out.println();
        System.out.println("Printing with Alignment");
        System.out.println();
        cap1.print();
    }
}
