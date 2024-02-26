package a1_2001040230;

import common.Genre;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int publicationYear;
    private int numCopiesAvailable;

    public Book(String title, String author, Genre genre, int publicationYear, int numCopiesAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.numCopiesAvailable = numCopiesAvailable;
    }

    public String getIsbn() {
        if (this.isbn == null) {
            String isbn = "-" + publicationYear;
            int indexGenre = genre.ordinal() + 1;
            if (indexGenre < 10) {
                isbn = "0" + indexGenre + isbn;
            } else {
                isbn = indexGenre + isbn;
            }
            String[] splitAuthorName = author.split(" ");
            String abbreviateAuthorName = "";
            if (splitAuthorName.length != 0) {
                if (splitAuthorName.length < 2) {
                    abbreviateAuthorName += splitAuthorName[0].charAt(0);
                } else {
                    abbreviateAuthorName = abbreviateAuthorName + splitAuthorName[0].charAt(0) + splitAuthorName[1].charAt(0);
                }
                isbn = abbreviateAuthorName + "-" + isbn;
            }
            setIsbn(isbn);
        }
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumCopiesAvailable() {
        return numCopiesAvailable;
    }

    public void setNumCopiesAvailable(int numCopiesAvailable) {
        this.numCopiesAvailable = numCopiesAvailable;
    }

    public void checkoutBook() {
        numCopiesAvailable -= 1;
    }

    public void returnBook() {
        numCopiesAvailable += 1;
    }
}
