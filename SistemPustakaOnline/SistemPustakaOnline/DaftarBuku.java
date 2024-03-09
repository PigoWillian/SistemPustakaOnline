import java.util.ArrayList;

class DaftarBuku {
    private ArrayList<Buku> daftarBuku;

    public DaftarBuku() {
        daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan ke daftar.");
    }

    public void tampilkanDaftarBuku() {
        System.out.println("\nDaftar Buku:");

        if (daftarBuku.isEmpty()) {
            System.out.println("Daftar buku kosong.");
        } else {
            for (Buku buku : daftarBuku) {
                buku.tampilkanInfo();
                System.out.println("------------------------");
            }
        }
    }

    public void cariBuku(String judul) {
        boolean found = false;

        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                buku.tampilkanInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        }
    }

    public void hapusBuku(String judul) {
        boolean removed = daftarBuku.removeIf(buku -> buku.getJudul().equalsIgnoreCase(judul));

        if (removed) {
            System.out.println("Buku dengan judul '" + judul + "' berhasil dihapus dari daftar.");
        } else {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan dalam daftar.");
        }
    }
}
