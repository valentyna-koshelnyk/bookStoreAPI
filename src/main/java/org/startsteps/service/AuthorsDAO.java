package org.startsteps.service;

import org.startsteps.model.Authors;
import org.startsteps.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDAO implements AuthorsService{
    private static final String ADD_AUTHOR = "INSERT INTO authors (authorName, origin, birthDate) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM authors";
    private static final String SELECT_BY_AUHTORNAME = "SELECT * FROM authors WHERE authorName = ?";
    private static final String FILTER_BY_ORIGIN = "SELECT * FROM authors WHERE origin = ?";
    private static final String FILTER_BY_BIRTHDATE_RANGE = "SELECT * FROM authors WHERE birthDate BETWEEN ? AND ?";
    private static final String DELETE_BY_NAME = "DELETE * FROM authors WHERE authorName = ?";
    private static final String UPDATE_AUTHOR = "UPDATE authors SET authorName = ?" +
            ", origin = ?, birthDate =?";


    @Override
    public void addAuthor(Authors author) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(ADD_AUTHOR);
            ps.setString(1, author.getAuthorName());
            ps.setString(2, author.getOrigin());
            ps.setDate(3, author.getBirthDate());
        } catch (SQLException e) {
            System.out.println("404: Bad Request. Check the query");;
        }
    }

    @Override
    public List<Authors> getAllAuthors() {
        List<Authors> authors = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_AUTHORS);
            while (rs.next()){
                Authors author = new Authors(
                        rs.getInt("authorId"),
                        rs.getString("authorName"),
                        rs.getString("origin"),
                        rs.getDate("birthDate"));
                authors.add(author);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }

    @Override
    public Authors getAuthorByName(String authorName) {
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement(SELECT_BY_AUHTORNAME);
            ps.setString(1, authorName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return new Authors(
                        rs.getInt("authorId"),
                        rs.getString("authorName"),
                        rs.getString("origin"),
                        rs.getDate("birthDate"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Authors> getAuthorsByYearRange(int yearStart, int yearEnd) {
        List<Authors> authors = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement(FILTER_BY_BIRTHDATE_RANGE);
            ps.setInt(1, yearStart);
            ps.setInt(2,yearEnd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Authors author = new Authors(
                        rs.getInt("authorId"),
                        rs.getString("authorName"),
                        rs.getString("origin"),
                        rs.getDate("birthDate"));
                authors.add(author);

            }
        } catch (SQLException ex) {
            System.out.println("Unexpected error. Double check your query.");;
        }
        return authors;
    }
        @Override
    public void deleteAuthor(String authorName) {
            try (Connection connection = DBConnection.getConnection()) {
                PreparedStatement ps = connection.prepareStatement(DELETE_BY_NAME);
                ps.setString(1, authorName);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Invalid request. Please try again with another query.");;
            }
        }

        @Override
    public void updateAuthor(Authors authors) {
            try (Connection connection = DBConnection.getConnection()) {
                PreparedStatement ps = connection.prepareStatement(UPDATE_AUTHOR);
                ps.setString(1, authors.getAuthorName());
                ps.setString(2, authors.getOrigin());
                ps.setDate(3, authors.getBirthDate());;
                ps.executeUpdate();
    } catch (SQLException e) {
                System.out.println("Something went wrong. Please check your query");;
            }
        }
        @Override
    public List<Authors> getAuthorsByOrigin(String originCountry){
        List<Authors> authors = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(FILTER_BY_ORIGIN);
            ps.setString(1, originCountry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Authors author = new Authors(
                        rs.getInt("authorId"),
                        rs.getString("authorName"),
                        rs.getString("origin"),
                        rs.getDate("birthDate"));
                authors.add(author);
            }
        } catch (SQLException ex) {
            System.out.println("Unexpected error. Double check your query.");;
        }
            return authors;
        }
}
