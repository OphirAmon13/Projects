package edu.yu.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Book> holdings;

    public Library(String name, String address, String phoneNumber){
        if(name == null || name.trim().isEmpty()){
            throw new RuntimeException("Name cannot be null or empty.");
        }
        if(address == null || address.trim().isEmpty()){
            throw new RuntimeException("Address cannot be null or empty.");
        }
        if(phoneNumber == null || phoneNumber.trim().isEmpty()){
            throw new RuntimeException("Phone number cannot be null or empty.");
        }

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.holdings = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void add(Book b){
        if(b == null){
            throw new RuntimeException("Book cannot be null");
        }
           
        holdings.add(b);
    }

    public boolean isTitleInHoldings(String title){
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        for(int i = 0; i < holdings.size(); i++){
            Book book = holdings.get(i);
            if(book.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public boolean isISBNInHoldings(long isbn13){
        if(isbn13 <= 0 || ("" + isbn13).length() != 13){
            throw new IllegalArgumentException("ISBN must be a positive 13 digit number.");
        }
        Book temp = new Book("temp", "temp", isbn13, "ebook");
        if(holdings.contains(temp)){
            return true;
        }
        return false;
    }

    public Book getBook(long isbn13){
        if(isbn13 <= 0 || ("" + isbn13).length() != 13){
            throw new IllegalArgumentException("ISBN must be a positive 13 digit number.");
        }
        if(isISBNInHoldings(isbn13)){
            Book temp = new Book("temp", "temp", isbn13, "ebook");
            int index = holdings.indexOf(temp);
            return holdings.get(index);
        }
        else{
            return null;
        }
    }

    public int nBooks(){
        return holdings.size();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(getClass() != obj.getClass()){
            return false;
        }

        Library otherLibrary = (Library) obj;

        return name.equals(otherLibrary.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        Book hp = new Book("Harry Potter", "JKR", 1234567890123L, "paperback");
        Book md = new Book("Moby Dick", "Herman", 1234567890124L, "hardcover");
        Book pj = new Book("Percy Jackson", "Rick", 1234567890125L, "ebook");
        Book rp1 = new Book("Ready Player one", "Ernest", 1234567890126L, "paperback");
        Book chumash = new Book("Chumash", "GOD", 9999999999999L, "ebook");

        Library library = new Library("New York Public Library", "476 5th Ave", "917-275-6975");


        System.out.println("testing add");
        library.add(hp);
        library.add(md);
        library.add(pj);
        System.out.println(library.nBooks());
        library.add(hp);
        System.out.println(library.nBooks());

        System.out.println("testing istitleinholdings");
        System.out.println(library.isTitleInHoldings("Harry Potter"));
        System.out.println(library.isTitleInHoldings("Bone"));

        System.out.println("testing isisbninholdings");
        System.out.println(library.isISBNInHoldings(1234567890123L));
        System.out.println(library.isISBNInHoldings(1234567890126L));

        System.out.println("Testing getbook");
        System.out.println(library.getBook(1234567890123L));
        System.out.println(library.getBook(1234567890126L));
    }

}


