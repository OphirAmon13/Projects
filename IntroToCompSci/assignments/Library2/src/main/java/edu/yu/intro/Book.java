package edu.yu.intro;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private long isbn13;
    private String bookType;

    public Book(String title, String author, long isbn13, String bookType){
        if(title == null || title.trim().isEmpty()){
            throw new RuntimeException("Title cannot be null or empty.");
        }

        if(author == null || author.trim().isEmpty()){
            throw new RuntimeException("Author cannot be null or empty.");
        }

        if(isbn13 <= 0 || ("" + isbn13).length() != 13){
            throw new RuntimeException("ISBN must be a positive 13 digit number.");
        }

        if(bookType == null || bookType.trim().isEmpty()){
            throw new RuntimeException("Book type cannot be null or empty.");
        }

        if(!bookType.equals("hardcover") && !bookType.equals("paperback") && !bookType.equals("ebook")){
            throw new RuntimeException("Book type must be either hardcover, paperback, or ebook.");
        }

        this.title = title;
        this.author = author;
        this.isbn13 = isbn13;
        this.bookType = bookType;

    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public long getISBN13() {
        return isbn13;
    }

    public String getBookType() {
        return bookType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(getClass() != obj.getClass()){
            return false;
        }

        Book otherBook = (Book) obj;

        return isbn13 == otherBook.isbn13;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn13);
    }

    @Override
    public String toString() {
        return title + "-" + author + "-" + isbn13 + "-" + bookType;
    }

    public static void main(String[] args) {
        Book book = new Book("harry potter", "jkr", 1234567890123L, "ebook");
        System.out.println(book);
        Book book1 = new Book("parry hotter", "rkj", 1234567890124L, "hardcover");
        System.out.println(book1);
        System.out.println(book.equals(book1));
    }
}

