
package model;

import java.util.List;

public class teh extends MenuItem implements Customizable {
    private int boba;
    private int es;
    private int gula;
    private int karamel;

    public teh(String id, String nama, double hargaBase, int stok) {
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
        int[] data = new int[c.size()];

        for (int i = 0; i < c.size(); i++) {
            data[i] = c.get(i);
        }

        customize(data);
    }

    @Override
    public double hitungHargaTotal() {
        return getHargaBase()
            + boba * 1000
            + karamel * 3000;
    }

    @Override
    public String getOrderDetail() {
        return getNama()
            + "  Boba: " + boba
            + ", Es: " + es
            + ", Gula: " + gula
            + ", Karamel: " + karamel;
    }
}
