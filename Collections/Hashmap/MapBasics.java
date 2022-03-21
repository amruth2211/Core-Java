package Collections.Hashmap;

import java.util.HashMap;
import java.util.Iterator;

class Books {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Books(int id, String name, String author, String publisher, int quantity) {
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
        Books other = (Books) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Books [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

}

public class MapBasics {
    public static void main(String[] args) {
        Books b1 = new Books(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Books b2 = new Books(233, "Operating System", "Galvin", "Wiley", 6);
        Books b3 = new Books(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Books b4 = new Books(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);

        HashMap<Integer, Books> Bookss = new HashMap<>();
        Bookss.put(b1.id, b1);
        Bookss.put(b2.id, b2);
        Bookss.put(b3.id, b3);
        Bookss.put(b4.id, b4);

        Iterator<Integer> i = Bookss.keySet().iterator();
        while (i.hasNext()) {
            Integer b = i.next();
            Books obj = Bookss.get(b);
            System.out.println(obj);
        }

        System.out.println("After Doubling ");
        Bookss.values().stream().forEach(ele -> ele.quantity *= 2);
        Bookss.values().stream().forEach(System.out::println);

        System.out.println("After merging ");
        Bookss.merge(233, Bookss.get(233), (oldValue, newValue) -> {
            oldValue.publisher += " USA";
            return oldValue;
        });
        Bookss.values().stream().forEach(System.out::println);
    }
}
