
package controller;

import java.util.List;

interface Customizable {
    void customize(List<Integer> customizations);
    void customize(int[] customizations);
}

enum EnumUkuran {
    SMALL,
    MEDIUM,
    LARGE
}

abstract class MenuItem {

    private String id;
    private String nama;
    private double hargaBase;
    private int stok;

    MenuItem(String id, String nama, double hargaBase, int stok) {
        this.id = id;
        this.nama = nama;
        this.hargaBase = hargaBase;
        this.stok = stok;
    }

    String getId() {
        return id;
    }

    String getNama() {
        return nama;
    }

    double getHargaBase() {
        return hargaBase;
    }

    int getStok() {
        return stok;
    }

    void kurangiStok(int jumlah) {
        stok -= jumlah;
    }

    abstract double hitungHargaTotal();

    abstract String getOrderDetail();

    double hitungHargaTotal(int jumlah) {
        return hitungHargaTotal() * jumlah;
    }

    double hitungHargaTotal(int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);

        if ("HEMAT10".equalsIgnoreCase(kodePromo)) {
            total = total * 0.90;
        }

        return total;
    }

    double hitungHargaTotal(int jumlah, EnumUkuran ukuran) {
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

class Kopi extends MenuItem implements Customizable {

    private int rum;
    private int es;
    private int gula;
    private int karamel;

    Kopi(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override
    public void customize(int[] c) {
        if (c.length != 4 ||
            c[0] < 0 || c[0] > 1 ||
            c[1] < 0 || c[1] > 5 ||
            c[2] < 0 || c[2] > 5 ||
            c[3] < 0 || c[3] > 5) {
            throw new IllegalArgumentException(
                "Kustomisasi tidak valid.");
        }

        rum = c[0];
        es = c[1];
        gula = c[2];
        karamel = c[3];
    }

    @Override
    public void customize(List<Integer> c) {
        customize(new int[]{
            c.get(0), c.get(1), c.get(2), c.get(3)
        });
    }

    @Override
    double hitungHargaTotal() {
        return getHargaBase()
            + rum * 3000
            + karamel * 3000;
    }

    @Override
    String getOrderDetail() {
        return getNama()
            + " | Rum: " + rum
            + ", Es: " + es
            + ", Gula: " + gula
            + ", Karamel: " + karamel;
    }
}

class Teh extends MenuItem implements Customizable {

    private int boba;
    private int es;
    private int gula;
    private int karamel;

    Teh(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override
    public void customize(int[] c) {
        if (c.length != 4 ||
            c[0] < 0 || c[0] > 3 ||
            c[1] < 0 || c[1] > 5 ||
            c[2] < 0 || c[2] > 5 ||
            c[3] < 0 || c[3] > 5) {
            throw new IllegalArgumentException(
                "Kustomisasi tidak valid.");
        }

        boba = c[0];
        es = c[1];
        gula = c[2];
        karamel = c[3];
    }

    @Override
    public void customize(List<Integer> c) {
        customize(new int[]{
            c.get(0), c.get(1), c.get(2), c.get(3)
        });
    }

    @Override
    double hitungHargaTotal() {
        return getHargaBase()
            + boba * 1000
            + karamel * 3000;
    }

    @Override
    String getOrderDetail() {
        return getNama()
            + " | Boba: " + boba
            + ", Es: " + es
            + ", Gula: " + gula
            + ", Karamel: " + karamel;
    }
}

class Roti extends MenuItem implements Customizable {

    private int gula;
    private int meses;
    private int karamel;

    Roti(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override
    public void customize(int[] c) {
        if (c.length != 3 ||
            c[0] < 0 || c[0] > 5 ||
            c[1] < 0 || c[1] > 5 ||
            c[2] < 0 || c[2] > 5) {
            throw new IllegalArgumentException(
                "Kustomisasi tidak valid.");
        }

        gula = c[0];
        meses = c[1];
        karamel = c[2];
    }

    @Override
    public void customize(List<Integer> c) {
        customize(new int[]{
            c.get(0), c.get(1), c.get(2)
        });
    }

    @Override
    double hitungHargaTotal() {
        return getHargaBase()
            + meses * 500
            + karamel * 3000;
    }

    @Override
    String getOrderDetail() {
        return getNama()
            + " | Gula: " + gula
            + ", Meses: " + meses
            + ", Karamel: " + karamel;
    }
}

class MenuTidakDitemukan extends Exception {
    MenuTidakDitemukan(String pesan) {
        super(pesan);
    }
}

class StokTidakCukupException extends Exception {
    StokTidakCukupException(String pesan) {
        super(pesan);
    }
}


public class main {

    public static void main(String[] args) {

        MenuItem Kopi = new Kopi(
            "01", "Kopi Susu", 18000, 9);

        MenuItem Teh = new Teh(
            "02", "Teh Tarik", 15000, 10);

        MenuItem roti = new Roti(
            "03", "Roti Cokelat", 12000, 23);

        System.out.println(
            kopi.getId() + " | " + kopi.getNama()
            + " | Rp" + kopi.getHargaBase()
            + " | Stok: " + kopi.getStok());

        System.out.println(
            teh.getId() + " | " + teh.getNama()
            + " | Rp" + teh.getHargaBase()
            + " | Stok: " + teh.getStok());

        System.out.println(
            Roti.getId() + " | " + roti.getNama()
            + " | Rp" + roti.getHargaBase()
            + " | Stok: " + roti.getStok());

        System.out.println("\nProgram berhasil dijalankan.");
    }
}
// OK
