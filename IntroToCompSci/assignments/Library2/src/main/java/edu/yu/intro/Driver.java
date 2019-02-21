package edu.yu.intro;

public class Driver {
    public static void run(){
        Library library = new Library("Gottesman Library", "500 W 185th St", "917-563-1665");
        Patrons.Singleton.clear();

        System.out.println(library.nBooks());
        System.out.println(Patrons.Singleton.nPatrons());

        Book book1 = new Book("Harry Potter", "JKR", 1234567891234L, "paperback");
        Book book2 = new Book("Spin", "Robert Wilson", 1234567890123L, "ebook");
        Book book3 = new Book("Percy Jackson", "Rick Riordan", 1234567891230L, "hardcover");
        library.add(book1);
        library.add(book2);
        library.add(book3);

        Patron patron1 = new Patron("Ophir", "Amon", "Rubin Hall");
        Patron patron2 = new Patron("John", "Smith", "Muss Hall");
        Patrons.Singleton.add(patron1);
        Patrons.Singleton.add(patron2);

        System.out.println(library.nBooks());
        System.out.println(Patrons.Singleton.nPatrons());
    }

    public static void main(String[] args) {
        Driver.run();
    }
}
