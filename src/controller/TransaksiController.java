/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Kelompok 2
 */

import model.Pembelian;
import model.Penjualan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.koneksidatabase;

public class TransaksiController {
    private Connection conn;

    public TransaksiController() {
        conn = koneksidatabase.getConnection();
    }

    // 🔹 Tambah Pembelian
    public boolean tambahPembelian(Pembelian pembelian) {
        String query = "INSERT INTO pembelian (kode_supplier, kode_barang, jumlah, harga_satuan, total_harga, tanggal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pembelian.getKodeSupplier());
            stmt.setString(2, pembelian.getKodeBarang());
            stmt.setInt(3, pembelian.getJumlah());
            stmt.setDouble(4, pembelian.getHargaSatuan());
            stmt.setDouble(5, pembelian.getTotalHarga());
            stmt.setTimestamp(6, new Timestamp(pembelian.getTanggal().getTime()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 Tambah Penjualan
    public boolean tambahPenjualan(Penjualan penjualan) {
        String query = "INSERT INTO penjualan (kode_pelanggan, kode_barang, jumlah, harga_satuan, total_harga, tanggal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, penjualan.getKodePelanggan());
            stmt.setString(2, penjualan.getKodeBarang());
            stmt.setInt(3, penjualan.getJumlah());
            stmt.setDouble(4, penjualan.getHargaSatuan());
            stmt.setDouble(5, penjualan.getTotalHarga());
            stmt.setTimestamp(6, new Timestamp(penjualan.getTanggal().getTime()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 Lihat Semua Pembelian
    public List<Pembelian> getAllPembelian() {
        List<Pembelian> pembelianList = new ArrayList<>();
        String query = "SELECT * FROM pembelian";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Pembelian pembelian = new Pembelian(
                    rs.getInt("id_pembelian"),
                    rs.getString("kode_supplier"),
                    rs.getString("kode_barang"),
                    rs.getInt("jumlah"),
                    rs.getDouble("harga_satuan"),
                    rs.getDouble("total_harga"),
                    rs.getTimestamp("tanggal")
                );
                pembelianList.add(pembelian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pembelianList;
    }

    // 🔹 Lihat Semua Penjualan
    public List<Penjualan> getAllPenjualan() {
        List<Penjualan> penjualanList = new ArrayList<>();
        String query = "SELECT * FROM penjualan";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Penjualan penjualan = new Penjualan(
                    rs.getInt("id_penjualan"),
                    rs.getString("kode_pelanggan"),
                    rs.getString("kode_barang"),
                    rs.getInt("jumlah"),
                    rs.getDouble("harga_satuan"),
                    rs.getDouble("total_harga"),
                    rs.getTimestamp("tanggal")
                );
                penjualanList.add(penjualan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penjualanList;
    }

    // 🔹 Hapus Pembelian
    public boolean hapusPembelian(int idPembelian) {
        String query = "DELETE FROM pembelian WHERE id_pembelian = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPembelian);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 Hapus Penjualan
    public boolean hapusPenjualan(int idPenjualan) {
        String query = "DELETE FROM detail_penjualan WHERE id_penjualan = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPenjualan);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

