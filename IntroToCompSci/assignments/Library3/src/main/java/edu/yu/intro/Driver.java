package edu.yu.intro;

import java.util.Collection;
import java.util.Set;

public class Driver {
    public static Library run(){
        Library library = new Library("Gottesman Library", "500 W 185th St", "917-563-1665");

        Book book1 = new Book("Harry Potter", "JKR", 1234567891234L, "paperback");
        Book book2 = new Book("Spin", "Robert Wilson", 1234567890123L, "ebook");
        Book book3 = new Book("Percy Jackson", "Rick Riordan", 1234567891230L, "hardcover");
        library.add(book1);
        library.add(book2);
        library.add(book3);

        Patron patron1 = new Patron("Ophir", "Amon", "Rubin Hall");
        Patron patron2 = new Patron("John", "Smith", "Muss Hall");
        library.add(patron1);
        library.add(patron2);

        return library;
    }

    public static void main(String[] args) {
        Library library = Driver.run();

        System.out.println(library.nBooks());
        System.out.println(library.nPatrons());

        Book book = new Book("Harry Potter 2", "JKR", 1234567899870L, "hardcover");
        library.add(book);

        BookFilter.Builder b = new BookFilter.Builder();
        BookFilter bf = b.setBookType("hardcover").setISBN13(1234567891230L).build();
        Collection<Book> matches = library.search(bf);
        System.out.println(matches);

        Patron p = new Patron("Avi", "Amon", "apt");
        library.add(p);
        library.borrow(p, book);
        library.borrow(p, (Book) matches.toArray()[0]);
        Collection<Book> loaned = library.onLoan(p);
        System.out.println(loaned);

        Set<Patron> amons = library.byLastNamePrefix("Amon");
        String uuid = "";
        for(Patron patron : amons){
            if(patron.getFirstName().equals("Ophir")){
                uuid = patron.getId();
            }
        }

        Patron ophir = library.get(uuid);
        library.borrow(ophir, book);
        System.out.println(library.onLoan(p));
        System.out.println(library.onLoan(ophir));
        System.out.println(library.nPatrons());

    }
}
