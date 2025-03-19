package model;

public class Supplier {
    private String kodeSupplier;
    private String namaSupplier;
    private String alamat;
    private String noTelp;

    public Supplier() {}

    public Supplier(String kodeSupplier, String namaSupplier, String alamat, String noTelp) {
        this.kodeSupplier = kodeSupplier;
        this.namaSupplier = namaSupplier;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public String getKodeSupplier() {
        return kodeSupplier;
    }

    public void setKodeSupplier(String kodeSupplier) {
        this.kodeSupplier = kodeSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
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
