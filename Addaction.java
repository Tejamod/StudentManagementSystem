import Connectivity.DB;

import java.sql.*;

public class Addaction {

    public boolean add(StudentProfile sp) {
        boolean check = false;

        try {
            Connection con = DB.getCon();
            String query = "insert into profile (name,domain,address) values (?,?,?)";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, sp.getName());
            p.setString(2, sp.getDomain());
            p.setString(3, sp.getAddress());
            p.executeUpdate();
            check = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return check;
    }

    public void display() {

        try {
            Connection con = DB.getCon();
            String query = "select * from profile";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        "ID : " + rs.getInt(1) + " | " +
                                "Name : " + rs.getString(2) + " | " +
                                "Domain : " + rs.getString(3) + " | " +
                                "Address : " + rs.getString(4) + " |"
                );
                System.out.println("-------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean DisplaybyID(int id) {
        boolean check = false;
        try {
            Connection con = DB.getCon();
            String query = "select * from profile where ID = " + id;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(
                        "ID : " + rs.getInt(1) + " | " +
                                "Name : " + rs.getString(2) + " | " +
                                "Domain : " + rs.getString(3) + " | " +
                                "Address : " + rs.getString(4) + " |"
                );
                System.out.println("-------------------------------------");
                check = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    public boolean delete(int i1) {
        boolean check1 = false;
        try {
            Connection con = DB.getCon();
            String query = "delete from profile where ID = " + i1;
            PreparedStatement p = con.prepareStatement(query);
           int rowsAffected = p.executeUpdate();
           if (rowsAffected>0) {
               check1 = true;
           }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return check1;
    }

    public boolean update(int i2, int id1, String dom) {
        boolean check = false;


            try {
                if (i2 == 1 ) {
                    Connection con = DB.getCon();
                    String query = "update profile set domain = ? where ID = ?";
                    PreparedStatement p = con.prepareStatement(query);
                    p.setString(1, dom);
                    p.setInt(2, id1);
                    int rowsAffected = p.executeUpdate();
                    if (rowsAffected > 0) {
                        check = true;
                    }
                }
                if (i2 == 2 ) {
                    Connection con = DB.getCon();
                    String query = "update profile set address = ? where ID = ?";
                    PreparedStatement p = con.prepareStatement(query);
                    p.setString(1, dom);
                    p.setInt(2, id1);
                    int rowsAffected = p.executeUpdate();
                    if (rowsAffected > 0) {
                        check = true;
                    }

                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        return check;
        }


    }
