
package view;

import java.util.Scanner;
import java.util.List;
import model.MenuItem;

public class CoffeeShopView {
    private Scanner input = new Scanner(System.in);

    public void tampilkanMenu(List<MenuItem> daftarMenu) {
        System.out.println("\n=== COFFEE SHOP ===");

        for (MenuItem menu : daftarMenu) {
            System.out.println(
                menu.getId() + " | "
                + menu.getNama() + " | Rp"
                + menu.getHargaBase() + " | Stok: "
                + menu.getStok()
            );
        }

        System.out.println("0. Selesai");
    }

    public String inputTeks(String pesan) {
        System.out.print(pesan);
        return input.nextLine().trim();
    }

    public int inputAngka(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka");
            }
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanStruk(
            String detail, int jumlah, double total) {
        System.out.println(detail);
        System.out.println("Jumlah: " + jumlah);
        System.out.printf("Total: Rp%.0f%n", total);
    }
}
