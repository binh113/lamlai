package com.example.binh_c10.model.dao;

import com.example.binh_c10.model.connection.JdbcConnection;
import com.example.binh_c10.model.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentDao {
    private List<Student> students = null;

    public List<Student> getAll() {
        students = new LinkedList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM student;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDob(resultSet.getString("date_of_birth"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setClassRoom(resultSet.getString("class_room"));
                ;
                students.add(student);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student get(int id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM student WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDob(resultSet.getString("date_of_birth"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));
                student.setClassRoom(resultSet.getString("class_room"));

                return student;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Student();
    }

    public void insert(Student student) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "INSERT INTO staff(id,name, address,email,phone,start_date,salary,position,status) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDob());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setString(7, student.getClassRoom());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Added customer successfully.");
            } else {
                System.out.println("Failed to insert customer.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> searchByName(String name) {
        students = new ArrayList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM student WHERE name like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDob(resultSet.getString("date_of_birth"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));
                student.setClassRoom(resultSet.getString("class_room"));

                students.add(student);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }


    public void update(Student student) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "UPDATE student SET name = ?,date_of_birth=?, address = ?,phone=?,email=?,class_room=?, WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getDob());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhone());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setString(6,student.getClassRoom());
            preparedStatement.setInt(7, student.getId());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Edited customer successfully.");
            } else {
                System.out.println("Failed to edit customer.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "DELETE FROM student WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Removed customer successfully.");
            } else {
                System.out.println("Failed to remove customer.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
