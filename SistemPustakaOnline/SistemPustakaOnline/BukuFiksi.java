

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
