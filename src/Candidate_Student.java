import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Candidate_Student
{
    String name;
    Double average;
    Calendar date=Calendar.getInstance();

    public Candidate_Student(String name, String date, Double average) throws ParseException
    {
        this.name=name;
        this.date.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        this.average=average;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public Calendar getDate() { return date; }
    public void setDate(GregorianCalendar date) { this.date=date; }
    public Double getAverage() { return average; }
    public void setAverage(Double average) { this.average=average; }
    public String ShowDate() { return new SimpleDateFormat("dd/MM/yyyy").format(date.getTime()); }

    public String toString()
    { return "Name of the student: "+name+"\nDate of birth: "+this.ShowDate()+"\nThe average of his/her grades: "+average+"\n"; }
}