package ResponsiPrakPBO;

import javax.swing.*;
import java.sql.*;
import java.lang.String;
import java.sql.SQLException;

public class Connector {
    String DBurl      = "jdbc:mysql://localhost/trans_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal, " + ex.getMessage());
        }
    }

    public String[][] ItemList() {
        try {
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][7];

            String query = "SELECT * FROM transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("id_trans");
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir");
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertItem(String id, String nama, String kasir, String qty, String ppqty, String disc) {
        int jmlData = 0;
        double fqty = Float.parseFloat(qty);
        double fppqty = Float.parseFloat(ppqty);
        double fdisc = Float.parseFloat(disc);
        double total = (fppqty * fqty) - ((fppqty * fqty) * (fdisc / 100));
        try {
            String query = "SELECT * FROM transactions WHERE id_trans='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO transactions VALUES ('" + id + "', '" + nama + "', '" + kasir + "', '" + fqty + "', '" + fppqty + "', '" + fdisc + "', '" + total + "')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Sudah Ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateItem(String id, String nama, String kasir, String qty, String ppqty, String disc) {
        int jmlData = 0;
        double fqty = Float.parseFloat(qty);
        double fppqty = Float.parseFloat(ppqty);
        double fdisc = Float.parseFloat(disc);
        double total = (fppqty * fqty) - ((fppqty * fqty) * (fdisc / 100));
        try {
            String query = "SELECT * FROM transactions WHERE id_trans='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 1) {
                query = "UPDATE transactions SET nama_barang='" + nama + "', nama_kasir='" + kasir + "', qty='" + fqty + "', price_per_qty='" + fppqty + "', discount='" + fdisc + "', price_total='" + total + "' WHERE id_trans='" + id + "'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteItem(String id) {
        int jmlData = 0;
        try {
            String query = "SELECT * FROM transactions WHERE id_trans='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 1) {
                query = "DELETE FROM transactions WHERE id_trans='" + id + "'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil dihapus");
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }


}