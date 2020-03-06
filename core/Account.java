package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Account implements Authenticate {
    private Confirmation confirm;
    private String name, npm, password, status;
    private boolean isValid;

    /**
     * Inisialisasi npm dan password untuk digunakan login
     * 
     * @param npm      npm mahasiswa atau dosen
     * @param password password akun absen online
     */
    public Account(String npm, String password) {
        this.npm = npm;
        this.password = password;
        this.isValid = false;
    }

    /**
     * Aksi yang dilakukan saat tombol konfirmasi ditekan
     * 
     */
    public void confirmationPressed() {
        if (this.confirm != null)
            this.confirm.pressed();
        else
            System.out.println("\nLogin first...");
    }

    /**
     * Untuk melakukan login
     * 
     */
    public void login() {
        try {
            if (this.isValid)
                System.out.println("\nYou've been logged in..");
            else if (this.validation()) {
                System.out.println("\nLogin successful..");
                this.isValid = true;
                this.confirm = new AbsentOnline();
            } else
                System.out.println("\nYour npm or password incorrect... ");
        } catch (Exception e) {
            System.out.println("\nDatabase is unknown...");
        }
    }

    /**
     * Validasi untuk mengecek apakah akun yang ingin login terdaftar di database
     */
    private boolean validation() throws Exception {
        File file = new File("db/account.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] identity = line.split(":");
            if (identity[0].equals(this.npm) && identity[1].equals(this.password)) {
                this.name = identity[2];
                this.status = identity[3];
                return true;
            }
        }
        return false;
    }

    /**
     * Untuk melakukan logout
     */
    public void logout() {
        if (this.isValid) {
            this.confirm = null;
            System.out.println("\nLogout successful...");
        } else
            System.out.println("\nYou're not logged in...");
        this.isValid = false;
    }

    /**
     * Menampilkan identitas pengguna yang telah login
     */
    public void getIdentity() {
        if (this.isValid) {
            System.out.println("\nName\t: " + this.name);
            System.out.println("Npm\t\t: " + this.npm);
            if (this.confirm.isConfirm())
                System.out.println("Absent\t: Already");
            else
                System.out.println("Absent\t: Not yet");
            System.out.println("Status\t: " + this.status);
        } else
            System.out.println("\nLogin first...");
    }
}