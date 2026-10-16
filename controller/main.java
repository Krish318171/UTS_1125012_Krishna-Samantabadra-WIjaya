//git add .
//git commit -m "update code"
//git push
package controller;

interface Customizable{
    void customize();
    void notCustomize();
}

enum ukuran {
    SMALL,
    MEDIUM,
    LARGE
}

abstract class MenuItem {

    private String id;
    private String nama;
    private double hargaBase;
    private int stok;

    MenuItem(String id, String nama, double hargaBase, int stok){
        this.id = id;
        this.nama = nama;
        this.hargaBase = hargaBase;
        this.stok = stok;

    }

    abstract double hitungHargaTotal();

    


}

class kopi extends MenuItem implements Customizable{
    private String rum;
    private String es;
    private String gula;
    private String karamel;

    kopi(String rum, Strng es, String gula, String karamel){
        this.rum = rum;
        this.es = es;
        this.gula = gula;
        this.karamel = karamel;
    }

    @Override
    double hitungHargaTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void customize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notCustomize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

class teh extends MenuItem implements Customizable{
    private String boba;
    private String es;
    private String gula;
    private String karamel;

    teh(String boba, String es, String gula, String karamel){
        this.boba = boba;
        this.es = es;
        this.gula = gula;
        this.karamel = karamel;
    }

    @Override
    double hitungHargaTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void customize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notCustomize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

class roti extends MenuItem implements Customizable{
    private String gula;
    private String meses;
    private String karamel;

    roti(String gula, String meses, String karamel){
        this.gula = gula;
        this.meses = meses;
        this.karamel = karamel;
    }

    @Override
    double hitungHargaTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void customize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notCustomize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}