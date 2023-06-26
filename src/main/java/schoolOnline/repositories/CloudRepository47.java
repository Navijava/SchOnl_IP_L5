package schoolOnline.repositories;

import schoolOnline.entities.Course;
import schoolOnline.entities.Lector;
import schoolOnline.entities.Lecture;
import schoolOnline.entities.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
    }}
