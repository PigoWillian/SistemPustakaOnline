
import java.util.ArrayList;
import java.util.Scanner;

class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String genre;
    private int fiksi;
    private int nonFiksi;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }


    public int getFiksi() {
        return fiksi;
    }

    public int getNonFiksi() {
        return nonFiksi;
    }


    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Genre : " + genre );
        System.out.println("Fiksi : " + fiksi);
        System.out.println("NonFiksi : " + nonFiksi );
    }
}

class BukuFiksi extends Buku {
    private String genre;

    public BukuFiksi(String judul, String penulis, int tahunTerbit, String genre, int fiksi) {
        super(judul, penulis, tahunTerbit);
        this.genre = genre;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Genre: " + genre);
    }
}

class BukuNonFiksi extends Buku {
    private String subyek;

    public BukuNonFiksi(String judul, String penulis, int tahunTerbit, String subyek) {
        super(judul, penulis, tahunTerbit);
        this.subyek = subyek;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Subyek: " + subyek);
    }
}

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

public class Utama {
    public static void main(String[] args) {
        DaftarBuku daftar = new DaftarBuku();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Hapus Buku");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahunTerbit = scanner.nextInt();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    scanner.nextLine(); 

                    System.out.print("Jenis buku (1. Fiksi / 2. Non-Fiksi): ");
                    int jenisBuku = scanner.nextInt();
                    scanner.nextLine(); 

                    Buku bukuBaru = new Buku(judul, penulis, tahunTerbit);
                    daftar.tambahBuku(bukuBaru);
                    break;

                case 2:
                    daftar.tampilkanDaftarBuku();
                    break;

                case 3:
                    System.out.print("Masukkan judul buku yang akan dicari: ");
                    String judulCari = scanner.nextLine();
                    daftar.cariBuku(judulCari);
                    break;

                case 4:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    daftar.hapusBuku(judulHapus);
                    break;


                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 4);

        scanner.close();
    }
}