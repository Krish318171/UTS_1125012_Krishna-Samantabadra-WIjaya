
package model;

import java.util.List;

public class roti extends MenuItem implements Customizable {
    private int gula;
    private int meses;
    private int karamel;

    public roti(String id, String nama,
                double hargaBase, int stok) {
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
        int[] data = new int[c.size()];

        for (int i = 0; i < c.size(); i++) {
            data[i] = c.get(i);
        }

        customize(data);
    }

    @Override
    public double hitungHargaTotal() {
        return getHargaBase()
            + meses * 500
            + karamel * 3000;
    }

    @Override
    public String getOrderDetail() {
        return getNama()
            + "  Gula: " + gula
            + ", Meses: " + meses
            + ", Karamel: " + karamel;
    }
}
