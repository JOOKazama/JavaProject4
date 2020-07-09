import java.text.ParseException;

public class Student extends Candidate_Student implements Comparable<Student>
{
    String number;

    public Student(String name, Double average, String number, String date) throws ParseException
    {
        super(name, date, average);
        this.number=number;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number=number; }

    public String toString() { return super.toString()+"Faculty number: "+number+"\n\n"; }

    @Override public int compareTo(Student o) { return this.getNumber().compareTo(o.getNumber()); }
}