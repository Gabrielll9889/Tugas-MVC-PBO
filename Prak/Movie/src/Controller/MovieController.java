package Controller;

import Database.DatabaseConnection;
import Model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieController {
    public void addMovie(String title, double plotScore, double characterScore, double actingScore) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO movies (title, plot_score, character_score, acting_score) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, title);
                stmt.setDouble(2, plotScore);
                stmt.setDouble(3, characterScore);
                stmt.setDouble(4, actingScore);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM movies";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String title = rs.getString("title");
                    double plotScore = rs.getDouble("plot_score");
                    double characterScore = rs.getDouble("character_score");
                    double actingScore = rs.getDouble("acting_score");
                    Movie movie = new Movie(title, plotScore, characterScore, actingScore);
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public Movie getMovie(String title) {
        Movie movie = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM movies WHERE title = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, title);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        double plotScore = rs.getDouble("plot_score");
                        double characterScore = rs.getDouble("character_score");
                        double actingScore = rs.getDouble("acting_score");
                        movie = new Movie(title, plotScore, characterScore, actingScore);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public boolean updateMovie(String title, double plotScore, double characterScore, double actingScore) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE movies SET plot_score = ?, character_score = ?, acting_score = ? WHERE title = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, plotScore);
                stmt.setDouble(2, characterScore);
                stmt.setDouble(3, actingScore);
                stmt.setString(4, title);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMovie(String title) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM movies WHERE title = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, title);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
