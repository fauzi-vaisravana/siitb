package model;

import java.sql.Timestamp;

public class Stok {
    private int idStok;
    private String kodeBarang;
    private int jumlah;
    private String tipe; // "masuk" atau "keluar"
    private Timestamp tanggal;

    // Constructor tanpa ID (untuk INSERT baru, jika ID auto-increment)
    public Stok(String kodeBarang, int jumlah, String tipe, Timestamp tanggal) {
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
        this.tipe = tipe;
        this.tanggal = tanggal;
    }

    // Constructor lengkap dengan ID (untuk UPDATE/READ)
    public Stok(int idStok, String kodeBarang, int jumlah, String tipe, Timestamp tanggal) {
        this.idStok = idStok;
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
        this.tipe = tipe;
        this.tanggal = tanggal;
    }

    public Stok(String barang, int jumlah, String tipe) {
        this.kodeBarang = barang;
        this.jumlah = jumlah;
        this.tipe = tipe;
    }

    // Getter dan Setter
    public int getIdStok() {
        return idStok;
    }

    public void setIdStok(int idStok) {
        this.idStok = idStok;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Timestamp getTanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
    }
}
