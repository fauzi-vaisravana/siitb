package model;

public class Pelanggan {
    private String kodePelanggan;
    private String namaPelanggan;
    private String alamat;
    private String noTelp;

    public Pelanggan() {}

    public Pelanggan(String kodePelanggan, String namaPelanggan, String alamat, String noTelp) {
        this.kodePelanggan = kodePelanggan;
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public String getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
