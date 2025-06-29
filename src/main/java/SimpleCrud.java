import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author;
    }
}

public class SimpleCrud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int idCounter = 1;

        while (true) {
            System.out.println("\nBook Application");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                System.out.print("Enter author: ");
                String author = sc.nextLine();
                books.add(new Book(idCounter++, title, author));
                System.out.println("Book added!");

            } else if (choice == 2) {
                System.out.println("Books:");
                for (Book b : books) {
                    System.out.println(b);
                }

            } else if (choice == 3) {
                System.out.print("Enter book ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id) {
                        System.out.print("New title: ");
                        b.title = sc.nextLine();
                        System.out.print("New author: ");
                        b.author = sc.nextLine();
                        System.out.println("Book updated!");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Book not found.");

            } else if (choice == 4) {
                System.out.print("Enter book ID to delete: ");
                int id = sc.nextInt();
                boolean removed = books.removeIf(b -> b.id == id);
                if (removed) {
                    System.out.println("Book deleted.");
                } else {
                    System.out.println("Book not found.");
                }

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

