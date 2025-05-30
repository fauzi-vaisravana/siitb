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

public class Mitra {
    private int idPembelian;
    private String kodeSupplier;
    private String namaMitra;
    private String kodeBarang;
    private int jumlah;
    private double hargaSatuan;
    private double totalHarga;
    private Date tanggal;

    // Konstruktor kosong
    public Mitra() {}

    // Konstruktor lengkap
    public Mitra(int idPembelian, String kodeSupplier, String namaMitra, String kodeBarang,
                 int jumlah, double hargaSatuan, double totalHarga, Date tanggal) {
        this.idPembelian = idPembelian;
        this.kodeSupplier = kodeSupplier;
        this.namaMitra = namaMitra;
        this.kodeBarang = kodeBarang;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    public int getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }

    public String getKodeSupplier() {
        return kodeSupplier;
    }

    public void setKodeSupplier(String kodeSupplier) {
        this.kodeSupplier = kodeSupplier;
    }

    public String getNamaMitra() {
        return namaMitra;
    }

    public void setNamaMitra(String namaMitra) {
        this.namaMitra = namaMitra;
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
