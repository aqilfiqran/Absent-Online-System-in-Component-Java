import core.*;

/**
 * Implementasi Absen Online
 * 
 * @author Aqil Fiqran Dzi'Ul Haq
 * @version 1.0
 * @since 6-Maret-2020
 */
public class Main {
    /**
     * pengetesan jalan sistem absen online
     * 
     * @param args parameter standar untuk command line
     */
    public static void main(String args[]) {
        Account a = new Account("1708107010026", "aqil2000");
        a.login();
        a.logout();
        a.getIdentity();
        a.confirmationPressed();
        a.getIdentity();
    }
}