package model;

public abstract class MenuItem {
    private String id;
    private String nama;
    private double hargaBase;
    private int stok;

    public MenuItem(String id, String nama,
                    double hargaBase, int stok) {
        this.id = id;
        this.nama = nama;
        this.hargaBase = hargaBase;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHargaBase() {
        return hargaBase;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        stok -= jumlah;
    }

    public abstract double hitungHargaTotal();

    public abstract String getOrderDetail();

    public double hitungHargaTotal(int jumlah) {
        return hitungHargaTotal() * jumlah;
    }

    public double hitungHargaTotal(
            int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);

        if ("HEMAT10".equalsIgnoreCase(kodePromo)) {
            total *= 0.90;
        }

        return total;
    }

    public double hitungHargaTotal(
            int jumlah, EnumUkuran ukuran) {
        double total = hitungHargaTotal(jumlah);

        switch (ukuran) {
            case SMALL:
                return total;
            case MEDIUM:
                return total * 1.2;
            case LARGE:
                return total * 1.5;
            default:
                return total;
        }
    }
}
