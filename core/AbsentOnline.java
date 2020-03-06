package core;

public class AbsentOnline implements Confirmation {
    private boolean isConfirm;

    /**
     * Inisialisasi awal absen online
     */
    public AbsentOnline() {
        this.isConfirm = false;
    }

    /**
     * Aksi yang dilakukan saat tombol ditekan
     */
    public void pressed() {
        if (!this.isConfirm) {
            this.isConfirm = true;
            System.out.println("\nAbsent successful...");
        } else
            System.out.println("\nYou've been absent");
    }

    /**
     * Memberitahu apakah telah melakukan konfirmasi absen atau belum
     * 
     * @return boolean
     */
    public boolean isConfirm() {
        return this.isConfirm;
    }
}