import java.util.Comparator;

public class Date_Comparator implements Comparator<Student>
{ @Override public int compare(Student student, Student student1) { return student.getDate().compareTo(student1.getDate()); } }