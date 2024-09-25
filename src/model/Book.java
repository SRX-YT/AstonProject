package model;

public class Book implements Comparable<Book>{
    private String author;
    private String title;
    private int numPages;

    private Book(BookBuilder bookBuilder) {
        if (bookBuilder.author == null) {
            this.author = "Неизвестный автор";
        } else {
            this.author = bookBuilder.author;
        }

        if (bookBuilder.title == null) {
            this.title = "Неизвестное произведение";
        } else {
            this.title = bookBuilder.title;
        }

        this.numPages = bookBuilder.numPages;

        bookBuilder.resetBookBuilder();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPages() {
        return numPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;
        return author.equals(book.author) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result = author == null ? 0 : author.hashCode();
        return title == null ? result : title.hashCode() + result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", numPages=" + numPages +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return author.compareTo(o.getAuthor());
    }

    public static class BookBuilder {
        private String author;
        private String title;
        private int numPages;

        public BookBuilder() {
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setNumPages(int numPages) {
            this.numPages = numPages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

        public void resetBookBuilder() {
            this.author = null;
            this.title = null;
            this.numPages = 0;
        }
    }
}
