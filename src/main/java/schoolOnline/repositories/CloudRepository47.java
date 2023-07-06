package schoolOnline.repositories;

import schoolOnline.entities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class CloudRepository47 extends CloudRepositoryAbstract {
    public static List<Lecture> getLectureList() {
        try {
            final String sql = "SELECT * FROM lecture";
            try (Connection conn = createCon();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)
            ) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Lecture> lectureList = new ArrayList<>();
                while (resultSet.next()) {
                    Lecture lecture = new Lecture(resultSet.getInt("course_id"),
                            resultSet.getInt("lecture_id"),
                            resultSet.getInt("lector_id"),
                            resultSet.getString("lecture_date"));
                    lecture.setLectureName(resultSet.getString("lecture_name"));
                    lectureList.add(lecture);
                }
                return lectureList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }
    public static List<Lecture> getLectureList(String sort) {
        final List<Lecture> lectureList = new ArrayList<>();
        try {
            final String sql = sort;
            try (Connection conn = createCon();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)
            ) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Lecture lecture = new Lecture(resultSet.getInt("course_id"),
                            resultSet.getInt("lecture_id"),
                            resultSet.getInt("lector_id"),
                            resultSet.getString("lecture_date"));
                    lecture.setLectureName(resultSet.getString("lecture_name"));
                    lecture.setAddMatQuantity(resultSet.getInt("add_mat_quantity"));
                    lecture.setHomeworkQuantity(resultSet.getInt("hw_quantity"));
                    lectureList.add(lecture);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        return lectureList;
    }

    public static List<Course> getCourseList() {
        try {
            final String sql = "SELECT * FROM course";
            try (Connection conn = createCon();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)
            ) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Course> courseList = new ArrayList<>();
                while (resultSet.next()) {
                    Course course = new Course(resultSet.getInt("course_id"),
                            resultSet.getString("course_name"),
                            resultSet.getInt("student_quantity"));
                    courseList.add(course);
                }
                return courseList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Lector> getLectorList() {
        try {
            final String sql = "SELECT * FROM lector";
            try (Connection conn = createCon();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)
            ) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Lector> courseList = new ArrayList<>();
                while (resultSet.next()) {
                    Lector lector = new Lector(Role.LECTOR,
                            resultSet.getInt("course_id"),
                            resultSet.getInt("lector_id"),
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname"));
                    courseList.add(lector);
                }
                return courseList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Lector> getLectorList(String sort) {
        final List<Lector> lectorList = new ArrayList<>();
        try {
            try (Connection conn = createCon();
                 PreparedStatement preparedStatement = conn.prepareStatement(sort)
            ) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Lector lector = new Lector(Role.LECTOR,
                            resultSet.getInt("course_id"),
                            resultSet.getInt("lector_id"),
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname"));
                    lectorList.add(lector);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        return lectorList;
    }

    public static List<Student> getStudentList() {
        final List<Student> studentList = new ArrayList<>();
        final String sql = "SELECT * FROM lector";
        try (Connection conn = createCon();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)
        ){
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setAge(resultSet.getInt("age"));
                student.setStudentId(resultSet.getInt("student_id"));
                student.setCourseQuantity(resultSet.getInt("course_quantity"));
                studentList.add(student);
            }
        }catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        return studentList;
    }

    public static List<Student> getStudentList(String sort) {
        final List<Student> studentList = new ArrayList<>();
        final String sql = sort;
        try (Connection conn = createCon();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)
        ){
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setAge(resultSet.getInt("age"));
                student.setStudentId(resultSet.getInt("student_id"));
                student.setCourseQuantity(resultSet.getInt("course_quantity"));
                studentList.add(student);
            }
        }catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        return studentList;
    }

    public static LinkedHashMap<String, Integer> getAddMatInf(String sort) {
        LinkedHashMap<String, Integer> addMatInf = new LinkedHashMap<>();
        String result = "";
        final String sql = sort;
        try (Connection conn = createCon();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)
        ){
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                addMatInf.put(resultSet.getString("mat_type"),
                        resultSet.getInt("count"));
            }
        }catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        return addMatInf;
    }

}
