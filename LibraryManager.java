package a1_2001040230;

import java.util.*;

public class LibraryManager {

    private final int INDEX_NOT_FOUND = -1;

    private final List<Book> books;
    private final List<LibraryTransaction> transactions;

    public LibraryManager() {
        books = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<LibraryTransaction> getTransactions() {
        return transactions;
    }

    List<LibraryTransaction> getCheckedOutBooks(Patron patron) {
        List<LibraryTransaction> checkedOutBooks = new ArrayList<>();
        for (LibraryTransaction transaction : transactions) {
            if (transaction.getPatron().getId() == patron.getId() &&
                    transaction.getReturnDate() == null) {
                checkedOutBooks.add(transaction);
            }
        }
        return checkedOutBooks;
    }

    public void checkoutBook(Patron patron, Book book, Date checkoutDate, Date dueDate) {
        int indexBook = findIndexBook(book);

        if (indexBook == INDEX_NOT_FOUND || books.get(indexBook).getNumCopiesAvailable() < 0) {
            System.out.println("Checkout book failed!");
            return;
        }

        // Add Transaction
        transactions.add(
                new LibraryTransaction(patron, book, checkoutDate, dueDate)
        );

        // Update Book
        books.get(indexBook).checkoutBook();

        System.out.println("Checkout book successfully!");
    }

    public void returnBook(LibraryTransaction transaction, Date returnDate) {
        int indexTransaction = findIndexTransaction(transaction);

        if (indexTransaction == INDEX_NOT_FOUND) {
            return;
        }

        int indexBook = findIndexBook(transaction.getBook());

        // Update Transaction
        transactions.get(indexTransaction).setReturnDate(returnDate);

        // Update Book
        books.get(indexBook).returnBook();

        System.out.println(transactions.get(indexTransaction).getDescription());

        System.out.println("Return book successfully!");
    }

    public int findIndexBook(Book book) {
        int indexBook = INDEX_NOT_FOUND;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(book.getIsbn())) {
                indexBook = i;
                break;
            }
        }
        return indexBook;
    }

    public int findIndexTransaction(LibraryTransaction transaction) {
        int indexTransaction = INDEX_NOT_FOUND;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getPatron().getId() == transaction.getPatron().getId()
                    && transactions.get(i).getBook().getIsbn().equals(transaction.getBook().getIsbn())) {
                indexTransaction = i;
            }
        }
        return indexTransaction;
    }

    public List<LibraryTransaction> getOverdueBooks() {
        List<LibraryTransaction> overdueBooks = new ArrayList<>();
        for (LibraryTransaction transaction : transactions) {
            if (transaction.isOverdue()) {
                overdueBooks.add(transaction);
            }
        }
        return overdueBooks;
    }

    public void sort() {
        transactions.sort((txn1, txn2) -> {
            if (txn1.getPatron().getId() > txn2.getPatron().getId()) {
                return 1;
            } else if (txn1.getPatron().getId() == txn2.getPatron().getId()) {
                return 0;
            }
            return -1;
        });
    }
}
