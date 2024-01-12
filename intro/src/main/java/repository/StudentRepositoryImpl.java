package repository;

import model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {


    private static List<Student> studentList;
    private static List<Student> studentList2;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, " Nguyen Van A", 1, new String[]{"Java", "C#"}));
        studentList.add(new Student(2, " Nguyen Van B", 0, new String[]{"C#"}));
        studentList.add(new Student(3, " Nguyen Van C", 2, new String[]{"Java"}));
    }

    static {
        studentList2 = new ArrayList<>();
        studentList2.add(new Student(1, " Nguyen Van A", 1, new String[]{"Java", "C#"}));
        studentList2.add(new Student(2, " Nguyen Van B", 0, new String[]{"C#"}));
        studentList2.add(new Student(3, " Nguyen Van C", 2, new String[]{"Java"}));
        studentList2.add(new Student(4, " Nguyen Van D", 2, new String[]{"Java"}));
    }

    @Override
    public List<Student> findAll()
    {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}
