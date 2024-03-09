

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
