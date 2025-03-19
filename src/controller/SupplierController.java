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
import koneksi.koneksidatabase;
import model.Supplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SupplierController {

    // CREATE: Tambah supplier baru
    public boolean tambahSupplier(Supplier supplier) {
        String sql = "INSERT INTO supplier (kode_supplier, nama_supplier, alamat, no_telp) VALUES (?, ?, ?, ?)";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, supplier.getKodeSupplier());
            pst.setString(2, supplier.getNamaSupplier());
            pst.setString(3, supplier.getAlamat());
            pst.setString(4, supplier.getNoTelp());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menambah Supplier: " + e.getMessage());
            return false;
        }
    }

    // READ: Ambil semua data supplier
    public List<Supplier> getAllSupplier() {
        List<Supplier> listSupplier = new ArrayList<>();
        String sql = "SELECT * FROM supplier";

        try (Connection conn = koneksidatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Supplier supplier = new Supplier(
                    rs.getString("kode_supplier"),
                    rs.getString("nama_supplier"),
                    rs.getString("alamat"),
                    rs.getString("no_telp")
                );
                listSupplier.add(supplier);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengambil Data Supplier: " + e.getMessage());
        }

        return listSupplier;
    }

    // UPDATE: Edit data supplier
    public boolean editSupplier(Supplier supplier) {
        String sql = "UPDATE supplier SET nama_supplier = ?, alamat = ?, no_telp = ? WHERE kode_supplier = ?";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, supplier.getNamaSupplier());
            pst.setString(2, supplier.getAlamat());
            pst.setString(3, supplier.getNoTelp());
            pst.setString(4, supplier.getKodeSupplier());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengedit Supplier: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Hapus supplier berdasarkan kode_supplier
    public boolean hapusSupplier(String kodeSupplier) {
        String sql = "DELETE FROM supplier WHERE kode_supplier = ?";

        try (Connection conn = koneksidatabase.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, kodeSupplier);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus Supplier: " + e.getMessage());
            return false;
        }
    }
}