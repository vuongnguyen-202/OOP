package a1_2001040230;


import common.Genre;
import common.PatronType;

import java.util.Calendar;
import java.util.Date;

public class LibraryManProg {
    private static Date[] checkoutDate = new Date[]{
            new Date(2023 - 1900, Calendar.MARCH, 25),
            new Date(2023 - 1900, Calendar.MAY, 8),
            new Date(2023 - 1900, Calendar.JUNE, 1),
            new Date(2023 - 1900, Calendar.JUNE, 25),
            new Date(2023 - 1900, Calendar.AUGUST, 10)
    };

    private static Date[] dueDate = new Date[]{
            new Date(2023 - 1900, Calendar.APRIL, 25),
            new Date(2023 - 1900, Calendar.MAY, 10),
            new Date(2023 - 1900, Calendar.JUNE, 25),
            new Date(2023 - 1900, Calendar.JULY, 25),
            new Date(2023 - 1900, Calendar.SEPTEMBER, 20)
    };

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        // Initialize at least 10 books in the library collection.
        Book book1 = new Book("Harry Potter and the Philosopher’s Stone", "J. K. Rowling", Genre.FICTION, 1997, 2);
        Book book2 = new Book("The Great Gatsby", "Francis Scott Fitzgerald", Genre.FICTION, 1925, 1);
        Book book3 = new Book("Ten Times Calmer", "Kirren Schnack", Genre.NON_FICTION, 2017, 2);
        Book book4 = new Book("The Big Sleep", "Raymond Chandler", Genre.MYSTERY, 1939, 1);
        Book book5 = new Book("Outlander", "Diana Gabaldon", Genre.ROMANCE, 1991, 2);
        Book book6 = new Book("Dune", "Frank Herbert", Genre.SCIENCE_FICTION, 1965, 1);
        Book book7 = new Book("The Fifth Season", "Nora Keita Jemisin", Genre.FANTASY, 2015, 2);
        Book book8 = new Book("Gone Girl", "Gillian Flynn", Genre.THRILLER, 2012, 0);
        Book book9 = new Book("Steve Jobs", "Walter Isaacson", Genre.BIOGRAPHY, 2011, 2);
        Book book10 = new Book("A People's History of the United States", "Howard Zinn", Genre.HISTORY, 1980, 1);
        Book book11 = new Book("Think and Grow Rich", "Napoleon Hill", Genre.SELF_HELP, 1937, 2);
        Book book12 = new Book("The Shining", "Stephen King", Genre.HORROR, 1977, 1);
        Book book13 = new Book("Into the Wild", "Jon Krakauer", Genre.ADVENTURE, 1996, 2);
        Book book14 = new Book("Leaves of Grass", "Walt Whitman", Genre.POETRY, 1855, 1);
        libraryManager.addBook(book1);
        libraryManager.addBook(book2);
        libraryManager.addBook(book3);
        libraryManager.addBook(book4);
        libraryManager.addBook(book5);
        libraryManager.addBook(book6);
        libraryManager.addBook(book7);
        libraryManager.addBook(book8);
        libraryManager.addBook(book9);
        libraryManager.addBook(book10);
        libraryManager.addBook(book11);
        libraryManager.addBook(book12);
        libraryManager.addBook(book13);
        libraryManager.addBook(book14);

        // Initialize at least 3 patrons involving both regular and premium patrons.
        Patron patron1 = new Patron("Alice", new Date(2000 - 1900, Calendar.AUGUST, 6), "alice@gmail.com", "332163", PatronType.REGULAR);
        Patron patron2 = new Patron("Bob", new Date(1995 - 1900, Calendar.DECEMBER, 2), "bobit123@gmail.com", "568239", PatronType.REGULAR);
        Patron patron3 = new Patron("Susan", new Date(1990 - 1900, Calendar.JUNE, 20), "susan@gmail.com", "164872", PatronType.PREMIUM);
        Patron patron4 = new Patron("Andy", new Date(1998 - 1900, Calendar.APRIL, 12), "andy123456@gmail.com", "587214", PatronType.PREMIUM);
        Patron patron5 = new Patron("Yan", new Date(1996 - 1900, Calendar.FEBRUARY, 25), "yan@gmail.com", "472153", PatronType.REGULAR);

        // Initialize and use to create 5 book transactions
        libraryManager.checkoutBook(patron1, book3, checkoutDate[1], dueDate[1]);
        libraryManager.checkoutBook(patron2, book4, checkoutDate[2], dueDate[3]);
        libraryManager.checkoutBook(patron3, book1, checkoutDate[0], dueDate[2]);
        libraryManager.checkoutBook(patron4, book7, checkoutDate[1], dueDate[3]);
        libraryManager.checkoutBook(patron5, book10, checkoutDate[2], dueDate[4]);
        libraryManager.checkoutBook(patron2, book8, checkoutDate[4], dueDate[4]);
        libraryManager.checkoutBook(patron4, book14, checkoutDate[2], dueDate[3]);
        libraryManager.checkoutBook(patron1, book12, checkoutDate[0], dueDate[4]);
        libraryManager.checkoutBook(patron1, book6, checkoutDate[2], dueDate[2]);
        libraryManager.checkoutBook(patron2, book3, checkoutDate[1], dueDate[2]);

        // Print currently checked-out books
        System.out.println(libraryManager.getCheckedOutBooks(patron1));
        System.out.println(libraryManager.getCheckedOutBooks(patron2));
        System.out.println(libraryManager.getCheckedOutBooks(patron3));
        System.out.println(libraryManager.getCheckedOutBooks(patron4));
        System.out.println(libraryManager.getCheckedOutBooks(patron5));

        // Print list of the overdue books that are not returned yet
        System.out.println(libraryManager.getOverdueBooks());


        // Patron returns the book
        libraryManager.returnBook(new LibraryTransaction(patron1, book3, null, null), dueDate[2]);


        // Print list of the overdue books that are not returned yet
        System.out.println(libraryManager.getOverdueBooks());


        // Patron returns the book
        libraryManager.returnBook(new LibraryTransaction(patron2, book8, null, null), dueDate[4]);
        libraryManager.returnBook(new LibraryTransaction(patron3, book1, null, null), dueDate[3]);

        // Sort transactions by patron ID
        libraryManager.sort();

        System.out.println(libraryManager.getTransactions());
    }
}
