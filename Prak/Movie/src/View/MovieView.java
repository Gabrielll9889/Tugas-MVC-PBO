package View;

import Controller.MovieController;
import Model.Movie;

import java.util.Scanner;

public class MovieView {
    private MovieController controller;
    private Scanner scanner;

    public MovieView(MovieController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Update Movie");
            System.out.println("4. Delete Movie");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    viewAllMovies();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMovie() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter plot score (0-5): ");
        double plotScore = scanner.nextDouble();
        System.out.print("Enter character score (0-5): ");
        double characterScore = scanner.nextDouble();
        System.out.print("Enter acting score (0-5): ");
        double actingScore = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        controller.addMovie(title, plotScore, characterScore, actingScore);
        System.out.println("Movie added successfully.");
    }

    private void viewAllMovies() {
        for (Movie movie : controller.getAllMovies()) {
            System.out.println(movie);
        }
    }

    private void updateMovie() {
        System.out.print("Enter title of the movie to update: ");
        String title = scanner.nextLine();
        System.out.print("Enter new plot score (0-5): ");
        double plotScore = scanner.nextDouble();
        System.out.print("Enter new character score (0-5): ");
        double characterScore = scanner.nextDouble();
        System.out.print("Enter new acting score (0-5): ");
        double actingScore = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (controller.updateMovie(title, plotScore, characterScore, actingScore)) {
            System.out.println("Movie updated successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    private void deleteMovie() {
        System.out.print("Enter title of the movie to delete: ");
        String title = scanner.nextLine();
        if (controller.deleteMovie(title)) {
            System.out.println("Movie deleted successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }
}
