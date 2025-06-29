package model;
import java.util.Date;

public class Laporan {
    private String jenisLaporan;
    private Date tanggalMulai;
    private Date tanggalSelesai;

    public Laporan() {}

    public Laporan(String jenisLaporan, Date tanggalMulai, Date tanggalSelesai) {
        this.jenisLaporan = jenisLaporan;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getJenisLaporan() {
        return jenisLaporan;
    }

    public void setJenisLaporan(String jenisLaporan) {
        this.jenisLaporan = jenisLaporan;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }
}
