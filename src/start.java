import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class start {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Welcome to Student Management App");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to DELETE Student");
            System.out.println("Press 3 to DISPLAY Student");
            System.out.println("Press 4 to UPDATE Student Name");
            System.out.println("Press 5 to EXIT App");
            int c=Integer.parseInt(br.readLine());
            if(c==1){
                //add
                System.out.println("Enter User name:");
                String name=br.readLine();
                System.out.println("Enter Phone name:");
                String phone=br.readLine();
                System.out.println("Enter User City:");
                String city=br.readLine();

                //create student object i dont have id then only name p..
                Student st=new Student(name,phone,city);
                //passing string to StudentDao
                boolean ans=StudentDao.insertStudentToDB(st);
                if(ans){
                    System.out.println("Student is added Successfully");
                }
                else {
                    System.out.println("Something went Wrong");
                }
                System.out.println(st);
            }
            else if(c==2){
                //delete
                System.out.println("Enter Student ID to Delete:");
                int userId=Integer.parseInt(br.readLine());
                boolean f=StudentDao.deleteStudent(userId);
                if(f){
                    System.out.println("Student is Deleted Successfully");
                }
                else {
                    System.out.println("Something Went wrong");
                }
            }
            else if(c==3){
                //display
                StudentDao.showAllStudents();
            }
            else if(c==4)
            {
                System.out.println("Enter ID:");
                int sid= Integer.parseInt(br.readLine());
                System.out.println("Enter New Name:");
                String name=br.readLine();
                boolean f1=StudentDao.updateName(sid,name);
                if(f1){
                    System.out.println("Student is Updated Successfully");
                }
                else {
                    System.out.println("Something Went wrong");
                }
            }
            else if(c==5){
                break;
            }
        }
        System.out.println("Thank u for using my app");
    }
}
