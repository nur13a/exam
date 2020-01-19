package com.company;

import java.sql.*;

public class DBeaver {
    private final static String url = "jdbc:postgresql://localhost:5432/";
    private final static String user = "postgres";
    private final static String password = "123";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }

    public boolean addNews(News news) {
        String SQL = "insert into news (title,texts,time_of_publishing) values (?,?, now())";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getTexts());
            statement.executeUpdate();
            System.out.println("Successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void printNews() {
        String SQL = "select title,texts from news";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(rs.getString("TITLE" + ""));
                System.out.println(rs.getString("TEXTS" + ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String SQL = "delete from news where id=?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean changed(String title, String text, int id) {
        String SQL = "update news set title =? ,texts =? where id=?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, title);
            statement.setString(2, text);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
