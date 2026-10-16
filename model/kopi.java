
package model;

import java.util.List;

public class kopi extends MenuItem implements Customizable {
    private int rum;
    private int es;
    private int gula;
    private int karamel;

    public kopi(String id, String nama,double hargaBase, int stok) {
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
                "kustomisasi tidak valid.");
        }

        rum = c[0];
        es = c[1];
        gula = c[2];
        karamel = c[3];
    }

    @Override
    public void customize(List<Integer> c) {
        int[] data = new int[c.size()];

        for (int i = 0; i < c.size(); i++) {
            data[i] = c.get(i);
        }

        customize(data);
    }

    @Override
    public double hitungHargaTotal() {
        return getHargaBase()
            + rum * 3000
            + karamel * 3000;
    }

    @Override
    public String getOrderDetail() {
        return getNama()
            + "  Rum: " + rum
            + ", Es: " + es
            + ", Gula: " + gula
            + ", Karamel: " + karamel;
    }
}
