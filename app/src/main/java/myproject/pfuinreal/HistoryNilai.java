package myproject.pfuinreal;

public class HistoryNilai {
    public int id;
    public int nilai;
    public String namaMateri;
    public int idUser;
    public String tanggal;

   /* public HistoryNilai(int id, int nilai, String namaMateri, int idUser, String tanggal) {
        this.id = id;
        this.nilai = nilai;
        this.namaMateri = namaMateri;
        this.idUser = idUser;
        this.tanggal = tanggal;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public String getNamaMateri() {
        return namaMateri;
    }

    public void setNamaMateri(String namaMateri) {
        this.namaMateri = namaMateri;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
