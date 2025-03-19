package model;

import java.util.Date;

public class Transaksi {
    private String kodeTransaksi;
    private String kodePelanggan;
    private String kodeBarang;
    private int jumlah;
    private double totalHarga;
    private Date tanggal;

    public Transaksi() {}

    public Transaksi(String kodeTransaksi, String kodePelanggan, String kodeBarang, int jumlah, double totalHarga, Date tanggal) {
        this.kodeTransaksi = kodeTransaksi;
        this.kodePelanggan = kodePelanggan;
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
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

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
