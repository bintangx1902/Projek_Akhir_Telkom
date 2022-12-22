package method;

import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.*;

public class koneksi {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql, que = null;

    public koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servis", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Database gagal, Kesalahan pada : \n" + e);
        }
    }
    public List cariLogin(String username, String password) {
        List logLogin = new ArrayList();
        int result;
        sql = "select username, password, staff_stts from tbl_staff where username = '"+ username +"' and password = '"+ password +"'";

        try {
            rs = st.executeQuery(sql);
            while (rs.next()){
                control user_data = new control();
                user_data.setusername(rs.getString("username"));
                user_data.setpassword(rs.getString("password"));
                user_data.setstaff_stts(rs.getString("staff_stts"));
                logLogin.add(user_data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n" + e);
        }
        return logLogin;
    }

    public List cariId(String username) {
        List listLogin = new ArrayList();
        sql = "select username from tbl_staff where no_id = '"+ username +"'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control user_acc = new control();
                user_acc.setusername(rs.getString("username"));
                listLogin.add(user_acc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pencarian ID pada : \n" + e );
        }
        return listLogin;
    }

    public int tambah_user(control e) {
        sql = "insert into tbl_staff (username, password, staff_stts) values ('"+e.getusername()+"', '"+e.getpassword()+"', '"+e.getstaff_stts()+"')";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, a);
        }
        return hasil;
    }


    public int delete_user(control e) {
        sql = "delete from tbl_staff where tbl_staff.no_id = '"+ e.getno_id() +"'";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, a);
        }
        return hasil;
    }

    public List tampil_admin() {
        List logUser = new ArrayList();
        sql = "select no_id, username, password, staff_stts from tbl_staff order by no_id asc";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dp = new control();
                dp.setno_id(rs.getInt("no_id"));
                dp.setusername(rs.getString("username"));
                dp.setpassword(rs.getString("password"));
                dp.setstaff_stts(rs.getString("staff_stts"));
                logUser.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Terjadi Kesalahan tampil pada : \n" + e);
        }
        return logUser;
    }

    public List cariLaptop(String brand) {
        List listLaptop = new ArrayList();
        int res = 0;
        sql = "select brand from tbl_konten where brand = '"+ brand +"'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control ltp = new control();
                ltp.setbrand(rs.getString("brand"));
                listLaptop.add(ltp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada pencarian laptop : \n" + e);
        }
        return listLaptop;
    }

    public int tambah_laptop(control e) {
        sql = "insert into tbl_konten values ('"+ e.getbrand() +"');";
        int res = 0;
        try {
            res = st.executeUpdate(sql);
        } catch (Exception a) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, a);
        }
        return res;
    }

    public List cariKerusakan(String kerusakan) {
        List listKerusakan = new ArrayList();
        int res = 0;
        sql = "select kerusakan from item_dmg where kerusakan = '"+ kerusakan +"'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dmg = new control();
                dmg.setkerusakan(rs.getString("kerusakan"));
                listKerusakan.add(dmg);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan pencarian pada : \n" + e);
        }
        return listKerusakan;
    }

    public int tambahKerusakan(control a) {
        sql = "insert into item_dmg values ('"+ a.getkerusakan() +"')";
        int res = 0;
        try {
            res = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    } 

    public int tambah_servis(control e) {
        sql = "insert into tbl_servis (nama_client, no_telp, email_client, brand, kerusakan, status) values ('"+ e.getnama_client() +"', '"+ e.getno_telp() +"', '"+ e.getemail_client() +"', '"+ e.getbrand() +"', '"+ e.getkerusakan() +"', '"+ e.getstatus() +"');";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    public int tambah_servis1(control e) {
        sql = "insert into tbl_servis (nama_client, no_telp, email_client, status) values ('"+ e.getnama_client() +"', '"+ e.getno_telp() +"', '"+ e.getemail_client() +"', '"+ e.getstatus() +"');";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    public List cariFromResi(String no_resi) {
        List listResi = new ArrayList();
        int noresi = Integer.parseInt(no_resi);
        sql = "select * from tbl_servis where no_resi = '"+ noresi +"'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control resi = new control();
                resi.setno_resi(rs.getInt("no_resi"));
                resi.setnama_client(rs.getString("nama_client"));
                resi.setno_telp(rs.getString("no_telp"));
                resi.setemail_client(rs.getString("email_client"));
                resi.setbrand(rs.getString("brand"));
                resi.setkerusakan(rs.getString("kerusakan"));
                resi.settgl_masuk(rs.getString("tgl_masuk"));
                resi.setstatus(rs.getString("status"));
                listResi.add(resi);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan pencarian pada : \n" + e);
        }
        return listResi;
    }

    public int upd_loc(control a) {
        int hasil = 0;
        sql = "Update tbl_servis set laptop_loc = 'On Customer - Owner Hand', penerima = '"+ a.getpenerima() +"', notel_penerima = '"+ a.getnotel() +"' where no_resi = '"+a.getno_resi()+"';";
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return hasil;
    }

    public int upd_st(control a) {
        int res = 0;
        sql = "update tbl_servis set status = '"+ a.getstatus() +"', price = '"+ a.getprice() +"' where no_resi = '"+ a.getno_resi()+"'; ";
        try {
            res = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }

    public List tampil_laptop() {
        List listLaptop = new ArrayList();
        sql = "select no_resi, brand, nama_client, email_client, status, laptop_loc from tbl_servis where status = 'DONE' and laptop_loc = 'Service Place' ";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dp = new control();
                dp.setno_resi(rs.getInt("no_resi"));
                dp.setbrand(rs.getString("brand"));
                dp.setnama_client(rs.getString("nama_client"));
                dp.setemail_client(rs.getString("email_client"));
                dp.setstatus(rs.getString("status"));
                dp.setlaptop_loc(rs.getString("laptop_loc"));
                listLaptop.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listLaptop;
    }

    public List tampil_dmg() {
        List listDamage = new ArrayList();
        sql = "select * from item_dmg; ";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dp = new control();
                dp.setkerusakan(rs.getString("kerusakan"));
                listDamage.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan Tampil pada : \n" + e);
        }
        return listDamage;
    }

    public List tampil_brnd() {
        List listBrand = new ArrayList();
        sql = "select * from tbl_konten";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dp = new control();
                dp.setbrand(rs.getString("brand"));
                listBrand.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan Tampil pada : \n" + e);
        }
        return listBrand;
    }

    public int buatpesan(control a) {
        sql = "Insert into tbl_msg (msgnya, tipe) values ('"+ a.getmsgnya() +"', '"+ a.gettipe() +"');";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    public List tampil_pesan() {
        List listPesan = new ArrayList();
        sql = "select * from tbl_msg where rd_stts = 'Sent'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dp = new control();
                dp.setmsg_id(rs.getInt("msg_id"));
                dp.settipe(rs.getString("tipe"));
                dp.setmsgnya(rs.getString("msgnya"));
                listPesan.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan Tampil pada : \n" + e);
        }
        return listPesan;
    }

    public int upd_rd(control a) {
        int hasil = 0;
        sql = "Update tbl_msg set rd_stts = 'Read' where msg_id = '"+ a.getmsg_id() +"';";
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return hasil;
    }

    public List tampil_item() {
        List listItem = new ArrayList();
        sql = "select no_resi, nama_client, brand, kerusakan from tbl_servis where status = 'INCOMPLETE'; ";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                control dp = new control();
                dp.setno_resi(rs.getInt("no_resi"));
                dp.setnama_client(rs.getString("nama_client"));
                dp.setbrand(rs.getString("brand"));
                dp.setkerusakan(rs.getString("kerusakan"));
                listItem.add(dp);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Terjadi Kesalahan tampil pada : \n" + e);
        }
        return listItem;
    }

    public int upd_item(control a) {
        int hasil = 0;
        sql = "Update tbl_servis set brand = '"+ a.getbrand() +"', kerusakan = '"+ a.getkerusakan() +"', status = 'PENDING' where no_resi = '"+ a.getno_resi() +"';";
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return hasil;
    }

    public int upd_user(control a) {
        int hasil = 0;
        sql = "Update tbl_staff set username = '"+ a.getusername() +"', password = '"+ a.getpassword() +"', staff_stts = '"+ a.getstaff_stts() +"' where no_id = '"+ a.getno_id() +"';";
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return hasil;
    }
}
