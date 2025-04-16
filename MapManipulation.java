import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Collections;
class StudentManager {
    private Map<Integer, String> students;

    public StudentManager() {
        this.students = new HashMap<>();
    }

    public void addStudent(int id, String name) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("Student ID must be greater than 0!");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new NullPointerException("Student name cannot be null or empty!");
            }
            students.put(id, name);
            System.out.println("Student added: ID = " + id + ", Name = " + name);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(NullPointerException e){

        }finally {
            System.out.println("Attempt to add student completed.\n");
        }
    }

    public TreeMap<Integer, String> sortStudents() {
        TreeMap<Integer, String> sorted = new TreeMap<>(students);
        System.out.println("Sorted Students:");
        for (Map.Entry<Integer, String> entry : sorted.entrySet()) {
            System.out.println("ID = " + entry.getKey() + ", Name = " + entry.getValue());
        }
        return sorted;
    }

    public void searchStudent(int id) {
        try {
            if (students.containsKey(id)) {
                System.out.println("Student found: ID = " + id + ", Name = " + students.get(id));
            } else {
                System.out.println("Student not found with ID: " + id);
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Student map is null.");
        }
    }

    public void removeStudent(int id) {
        try {
            if (students.containsKey(id)) {
                students.remove(id);
                System.out.println("Student with ID " + id + " removed.");
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Attempt to remove student completed.\n");
        }
    }

    public void findStudentWithHighestId() {
        try {
            int maxId = Collections.max(students.keySet());
            System.out.println("Highest ID student: ID = " + maxId + ", Name = " + students.get(maxId));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void findStudentWithLowestId() {
        try {
            int minId = Collections.min(students.keySet());
            System.out.println("Lowest ID student: ID = " + minId + ", Name = " + students.get(minId));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class MapManipulation {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

        
        sm.addStudent(1, "Alice");
        sm.addStudent(2, "Bob");

        
        sm.addStudent(-1, "Negative ID");
        sm.addStudent(3, null);
        sm.addStudent(4, "");

       
        sm.addStudent(2, "Updated Bob");

       
        sm.searchStudent(1); 
        sm.searchStudent(10);  

        
        sm.removeStudent(10);
        sm.removeStudent(1);
        sm.searchStudent(1);   

        sm.sortStudents();

        sm.findStudentWithHighestId();
        sm.findStudentWithLowestId();
    }
}