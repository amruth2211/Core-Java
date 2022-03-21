package StreamsAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.lang.model.util.ElementScanner14;

class Book implements Comparable<Book> {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id; // important fields is only id
        // result = prime * result +(name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

}

public class Bookmarket {
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);

        ArrayList<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        System.out.println("Book list is "); // foreach method
        books.stream().forEach(System.out::println);

        System.out.println("Book set is "); // collect method
        Set<Book> bookSet = books.stream().collect(Collectors.toSet());
        bookSet.stream().forEach(System.out::println);

        List<Book> booklist = books.stream().sorted().toList(); // sorted method
        System.out.println("Sorted books: ");
        booklist.stream().forEach(System.out::println);

        System.out.println("Double the quantity");
        books.stream().map((book) -> { // map method
            book.quantity *= 2;
            return book;
        }).forEach(System.out::println);

        System.out.println("Quantity greater than 10");
        books.stream().filter(book -> book.quantity > 10).forEach(System.out::println); // filter method

        System.out.println("Reduce the quantity ");
        int quantity = books.stream().filter(book -> book.id < 200).map(book -> book.quantity).reduce(0,
                (totalqty, qty) -> totalqty + qty); // reduce method
        System.out.println("quantity sold of books having id < 200 is " + quantity);
    }
}
