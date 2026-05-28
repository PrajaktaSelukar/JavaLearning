package OOPS;

public class LibraryManagementSystem {
    static abstract class LibraryItem {
        private String title;
        private String itemId;
        private boolean isAvailable;

        public LibraryItem(String title, String itemId) {
            this.title = title;
            this.itemId = itemId;
            this.isAvailable = true;
        }
        public String getTitle() {
            return title;
        }
        public String getItemId() {
            return itemId;
        }
        public boolean getIsAvailable() {
            return isAvailable;
        }
        public void setIsAvailable(boolean isavailable) {
            isAvailable = isavailable;
        }
        abstract public String getType();
        public void getInfo() {
            System.out.println("[" + getClass().getSimpleName() + "] " +
                    "ID: " + getItemId() + " | " +
                    "Title: " + getTitle() +" | " +
                    "Available: " + (getIsAvailable() ? "Yes" : "No")
            );
        }
    }
    interface Borrowable {
        public void borrow(String borrowerName);
        public void returnItem();
    }
    static class Book extends LibraryItem implements Borrowable {
        private String author;
        private String borrowedBy;
        public Book(String title, String itemId, String author) {
            super(title, itemId);
            this.author = author;
        }

        @Override
        public void borrow(String borrowerName) {
            if(getIsAvailable()) {
                borrowedBy = borrowerName;
                setIsAvailable(false);
                System.out.println("[Book] Borrowed by: " + borrowedBy);
            } else {
                System.out.println("[Book] already Borrowed by: " + borrowedBy);
            }
        }

        @Override
        public void returnItem() {
            System.out.println("[Book] Returned by: " + borrowedBy);
            setIsAvailable(true);
            borrowedBy = null;
        }

        @Override
        public String getType() {
            return "Book";
        }
    }
    static class Magazine extends LibraryItem implements Borrowable {
        private int issue;
        public Magazine(String title, String itemId, int issue) {
            super(title, itemId);
            this.issue = issue;
        }
        @Override
        public String getType() {
            return "Magazine";
        }
        @Override
        public void borrow(String borrowerName) {
            if(getIsAvailable()) {
                setIsAvailable(false);
                System.out.println("[Magazine] '" + getTitle() + "' borrowed");
            } else {
                System.out.println("[Magazine] '" + getTitle() + "' already borrowed");
            }
        }

        @Override
        public void returnItem() {
            setIsAvailable(true);
            System.out.println("[Magazine] '" + getTitle() + "' returned");
        }
    }
    static class Library {
        private LibraryItem[] items;
        private int count = 0;
        public Library() {
            items = new LibraryItem[10];
        }
        public void addItem(LibraryItem item) {
            items[count] = item;
            count++;
        }
        public void showAll() {
            for (int i = 0; i < count; i++) {
                items[i].getInfo();
            }
        }
        public LibraryItem findById(String id) {
            for (int i = 0; i < count; i++) {
                if (items[i].getItemId().equals(id)) {
                    return items[i];
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        // Problem 6 — Full OOP System
        // Task — Build a Library Management System
        Library lib = new Library();
        lib.addItem(new Book("Clean Code", "B001", "Robert Martin"));
        lib.addItem(new Book("Effective Java", "B002", "Joshua Bloch"));
        lib.addItem(new Magazine("Tech Today", "M001", 42));

        lib.showAll();

        Book b = (Book) lib.findById("B001");
        b.borrow("Prajakta");
        b.borrow("Alice");    // should fail — already borrowed

        lib.showAll();        // B001 should show Available: No

        b.returnItem();
        lib.showAll();        // B001 should show Available: Yes again
    }
}
