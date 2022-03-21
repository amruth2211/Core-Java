package Collections;

import java.util.ArrayList;

class Book {
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
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

}

public class CollectionDuplicateObjects {
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        ArrayList<Book> library = new ArrayList<>();
        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        ArrayList<Book> duplicate = new ArrayList<>();
        for (int i = 0; i < library.size() - 1; i++) {
            for (int j = i + 1; j < library.size(); j++) {
                if (library.get(j).equals(library.get(i))) {
                    duplicate.add(library.get(j));
                }
            }
        }
        library.removeAll(duplicate);
        System.out.println("No of duplicate books: " + duplicate.size());
        duplicate.forEach(System.out::println);
        int max_quantity = 0;
        for (int i = 0; i < library.size() - 1; i++) {
            if (library.get(i).quantity > library.get(i + 1).quantity) {
                max_quantity = i;
            }
        }
        System.out.println("Non-duplicate books with the highest quantity " +
                library.get(max_quantity));

        // ArrayList<Boolean> is_duplicate = new ArrayList<>(library.size());
        // for (int i = 0; i < library.size() - 1; i++) {
        // for (int j = i + 1; j < library.size(); j++) {
        // if (library.get(j).equals(library.get(i))) {
        // is_duplicate.set(i, true);
        // is_duplicate.set(j, true);
        // }
        // }
        // }
        // for (int i = 0; i < library.size(); i++) {
        // if (is_duplicate.get(i)) {
        // System.out.println(library.get(i));
        // }

        // }

    }
}
