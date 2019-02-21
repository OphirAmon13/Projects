package edu.yu.intro;

public class BookFilter {
    private Builder builder;

    private BookFilter(Builder builder){
        this.builder = builder;
    }

    public boolean filter(Book book){
        if(builder.getAuthor() != null){
            if(!builder.getAuthor().equals(book.getAuthor())){
                return false;
            }
        }

        if(builder.getTitle() != null){
            if(!builder.getTitle().equals(book.getTitle())){
                return false;
            }
        }

        if(builder.getBookType() != null){
            if(!builder.getBookType().equals(book.getBookType())){
                return false;
            }
        }

        if(builder.getIsbn13() != 0){
            if(builder.getIsbn13() != book.getISBN13()){
                return false;
            }
        }

        return true;
    }

    public static class Builder{
        private String author;
        private String title;
        private long isbn13;
        private String bookType;

        public Builder(){
            author = null;
            bookType = null;
            title = null;
            isbn13 = 0;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public long getIsbn13() {
            return isbn13;
        }

        public String getBookType() {
            return bookType;
        }

        public Builder setAuthor(String author){
            if(author == null || author.trim().isEmpty()){
                throw new IllegalArgumentException("Author cannot be null or empty.");
            }

            this.author = author;
            return this;
        }

        public Builder setTitle(String title){
            if(title == null || title.trim().isEmpty()){
                throw new IllegalArgumentException("Title cannot be null or empty.");
            }

            this.title = title;
            return this;
        }

        public Builder setISBN13(long isbn13){
            if(isbn13 <= 0 || ("" + isbn13).length() != 13){
                throw new IllegalArgumentException("ISBN must be a positive 13 digit number.");
            }

            this.isbn13 = isbn13;
            return this;
        }

        public Builder setBookType(String bookType){
            if(bookType == null || bookType.trim().isEmpty()){
                throw new IllegalArgumentException("Book type cannot be null or empty.");
            }

            if(!bookType.equals("hardcover") && !bookType.equals("paperback") && !bookType.equals("ebook")){
                throw new IllegalArgumentException("Book type must be either hardcover, paperback, or ebook.");
            }

            this.bookType = bookType;
            return this;
        }

        public BookFilter build(){
            return new BookFilter(this);
        }
    }
}
