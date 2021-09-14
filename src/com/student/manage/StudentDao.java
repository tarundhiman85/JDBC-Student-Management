package com.student.manage;

import java.sql.*;

public class StudentDao {
    public static boolean insertStudentToDB(Student st)  {
        //jdbc ka code
        boolean f=false;
        try {
            Connection con = CP.createC();
            //yha hm query fire krenge dynamic
            String q = "insert into student(sname,sphone,scity) values(?,?,?)";
            //PreparedStatement object represent precompiled statement create pstmt object
            PreparedStatement pstmt = con.prepareStatement(q);
            //set the values of parameter
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            //execute your data will go to database
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        //jdbc ka code
        boolean f=false;
        try {
            Connection con = CP.createC();
            //yha hm query fire krenge dynamic
            String q = "delete from student where sid=?";
            //PreparedStatement object represent precompiled statement create pstmt object
            PreparedStatement pstmt = con.prepareStatement(q);
            //set the values of parameter
            pstmt.setInt(1, userId);

            //execute your data will go to database
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudents() throws SQLException, ClassNotFoundException {
        //jdbc ka code
            Connection con = CP.createC();
            //yha hm query fire krenge dynamic
            String q = "select * from student";
            Statement stmt= con.createStatement();
            //send simple query
            ResultSet set=stmt.executeQuery(q);
            while(set.next()){
                //passing 1st column
                int id=set.getInt(1);
                String name=set.getString(2);
                String phone=set.getString(3);
                String city=set.getString("scity");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Phone: "+phone);
                System.out.println("City: "+city);
                System.out.println("++++++++++++++++");
            }
    }

    public static boolean updateName(int sid, String name)
    {
        boolean f1=false;
        try{
            Connection con = CP.createC();
            String q = "Update student set sname = ? where sid = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setInt(2, sid);
            pstmt.executeUpdate();
            f1=true;
          }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        return f1;
    }
}
