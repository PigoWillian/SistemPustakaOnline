public class BukuNonFiksi extends BukuFiksi {

    public BukuNonFiksi(String judul, String penulis, int tahunTerbit, String genre) {
        super(judul, penulis, tahunTerbit, genre);
        
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Jenis Buku: Non-Fiksi");
        super.tampilkanInfo(); // Memanggil tampilkanInfo dari kelas induk (BukuFiksi)
    }
    
    public static void main(String[] args) {
        BukuNonFiksi bukunonfiksi1 = new BukuNonFiksi
        ("Perang Dunia 2", "Max Havelar", 1946, "action");
        System.out.println(bukunonfiksi1.getJudul());
        System.out.println(bukunonfiksi1.getPenulis());
        System.out.println(bukunonfiksi1.getTahunTerbit());
        System.out.println(bukunonfiksi1.getgenre());
    }
    
}
