import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Student_Group implements Comparable<Student_Group>
{
    String name;
    String input;
    String output;
    Set<Student>set_students=new HashSet<>();

    public Student_Group(String input, String output) throws IOException
    {
        BufferedReader buffered_reader=new BufferedReader(new FileReader(input));
        this.name=buffered_reader.readLine();
        this.input=input;
        this.output=output;

        try
        {
            Scanner scanner=new Scanner(new File(input));

            for(int i=0; i<1; i++) { if(scanner.hasNextLine()) scanner.nextLine(); }

            while(scanner.hasNext())
            {
                String name=scanner.next();
                Double average=scanner.nextDouble();
                String number=scanner.next();
                String date=scanner.next();

                Student student=new Student(name, average, number, date);
                this.set_students.add(student);
            }
            scanner.close();

            StringBuilder string_builder=new StringBuilder();
            for (Student student:set_students) { string_builder.append(student.toString()); }

            FileWriter file_writer=new FileWriter(output);
            file_writer.write(string_builder.toString());
            file_writer.close();
        }

        catch (FileNotFoundException | ParseException e)
        {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public String getInput() { return input; }
    public void setInput(String input) { this.input=input; }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output=output; }
    public Set<Student>getSet_students() { return set_students; }
    public void setSet_students(Set<Student>set_students) { this.set_students=set_students; }

    List<Student>SortedByDate()
    {
        List<Student>list=new ArrayList<>(this.getSet_students());
        list.sort(new Date_Comparator());
        return list;
    }

    void ShowList() { for(Student student:this.SortedByDate()) { System.out.print(student.toString()); } }

    public String toString()
    {
        StringBuilder builder=new StringBuilder();
        for(Student student:this.set_students) { builder.append(student.toString()); }
        return builder.toString();
    }

    @Override public int compareTo(Student_Group group)
    {
        Double o_average=0.0, average=0.0;

        for(Student student:this.set_students) { average+=student.getAverage(); }
        for(Student student:group.getSet_students()) { o_average+=student.getAverage(); }

        average=average/this.getSet_students().size();
        o_average=o_average/this.getSet_students().size();

        return average.compareTo(o_average);
    }

    public void ShowCompareTo(Student_Group group)
    {
        switch(this.compareTo(group))
        {
            case 0:
                System.out.println("Both groups have equal value of the combined average grades.");
                break;
            case 1:
                System.out.println("The first group has bigger value of the combined average grades.");
                break;
            case -1:
                System.out.println("The second group has bigger value of the combined average grades.");
                break;
        }
    }
}