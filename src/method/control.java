package method;

public class control {
    String username, password, staff_stts, brand, kerusakan;
    int no_id;
    
    // username
    public String getusername(){
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }

    // pass
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {  
        this.password = password;
    }


    // hakases
    public String getstaff_stts() {
        return staff_stts;
    }
    public void setstaff_stts(String staff_stts) {
        this.staff_stts = staff_stts;
    }

    // id
    public int getno_id() {
        return no_id;
    }
    public void setno_id(int no_id) {
        this.no_id = no_id;
    }

    // laptop brand
    public String getbrand() {
        return brand;
    }
    public void setbrand(String brand) {
        this.brand = brand;
    }

    // kerusakan
    public String getkerusakan() {
        return kerusakan;
    }
    public void setkerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }


    /**
     *  table servis 
     */

    String nama_client, no_telp, email_client, status, tgl_masuk, laptop_loc, penerima, price, notel;
    int no_resi;

    // no resi
    public int getno_resi() {
        return no_resi;
    }
    public void setno_resi(int no_resi) {
        this.no_resi = no_resi;
    }

    // nama
    public String getnama_client() {
        return nama_client;    
    }
    public void setnama_client(String nama_client) {
        this.nama_client = nama_client;
    }

    // no hp
    public String getno_telp() {
        return no_telp;
    }
    public void setno_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    // email
    public String getemail_client() {
        return email_client;
    }
    public void setemail_client(String email_client) {
        this.email_client = email_client;
    }

    // status
    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }

    // tgl masuk
    public String gettgl_masuk() {
        return tgl_masuk;
    }
    public void settgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }
    
    // laptop loc
    public String getlaptop_loc() {
        return laptop_loc;
    }
    public void setlaptop_loc(String laptop_loc) {
        this.laptop_loc = laptop_loc;
    }

    // penerima
    public String getpenerima() {
        return penerima;
    }
    public void setpenerima(String penerima) {
        this.penerima = penerima;
    }

    // notel penerima
    public String getnotel() {
        return notel;
    }
    public void setnotel(String notel) {
        this.notel = notel;
    }

    // harga
    public String getprice() {
        return price;
    }
    public void setprice(String price) {
        this.price = price;
    }

    /*
    * tbl pesan
    */

    String msgnya, tipe, rd;
    int msg_id;

    // msg nya
    public String getmsgnya() {
        return msgnya;
    }
    public void setmsgnya(String msgnya) {
        this.msgnya = msgnya;
    }

    // tipe
    public String gettipe() {
        return tipe;
    }
    public void settipe(String tipe) {
        this.tipe = tipe;
    }

    // msg id
    public int getmsg_id() {
        return msg_id;
    }
    public void setmsg_id(int msg_id) {
        this.msg_id = msg_id;
    }

    // rd
    public String getrd() {
        return rd;
    }
    public void setrd(String rd) {
        this.rd = rd;
    }
}
