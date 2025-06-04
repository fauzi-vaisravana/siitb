/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kelompok 2
 */
import java.util.Date;

public class Penjualan {
    private int idPenjualan;
    private String kodePelanggan;
    private String kodeBarang;
    private int jumlah;
    private double hargaSatuan;
    private double totalHarga;
    private Date tanggal;

    public Penjualan() {}

    public Penjualan(int idPenjualan, String kodePelanggan, String kodeBarang, int jumlah, double hargaSatuan, double totalHarga, Date tanggal) {
        this.idPenjualan = idPenjualan;
        this.kodePelanggan = kodePelanggan;
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    public Penjualan(String KodePelanggan, String kodeBarang, int jumlah, double harga, double total) {
        this.kodePelanggan = KodePelanggan;
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
        this.hargaSatuan = harga;
        this.totalHarga = total;
    }

    public int getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
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

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
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

