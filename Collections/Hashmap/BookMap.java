package Collections.Hashmap;

import java.util.HashMap;
import java.util.Map;

class Book {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    // parameterised constructor
    Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

    // override hashCode()
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    // override equals()
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
}

class BookMap {
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        HashMap<Integer, Book> map = new HashMap<Integer, Book>();
        map.put(b1.id, b1);
        map.put(b2.id, b2);
        map.put(b3.id, b3);
        map.put(b4.id, b4);
        for (Map.Entry<Integer, Book> m : map.entrySet()) {
            // m.put(m.getKey(),(m.get(m.getKey()).quantity)*2);
            System.out.println(m.getKey() + " " + m.getValue());
        }
        for (Integer k : map.keySet()) {
            Integer amount = map.get(k).quantity * 2;
            map.get(k).quantity = amount;
        }
        System.out.println("After doubling: ");
        for (Map.Entry<Integer, Book> m : map.entrySet()) {
            // m.put(m.getKey(),(m.get(m.getKey()).quantity)*2);
            System.out.println(m.getKey() + " " + m.getValue());
        }
        map.merge(233, map.get(233), (oldValue, newValue) -> {
            newValue.publisher += "USA";
            return newValue;
        });
        System.out.println("After merging");
        System.out.println(map.get(233));
    }
}
