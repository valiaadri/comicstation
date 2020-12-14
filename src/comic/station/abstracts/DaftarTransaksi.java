
package comic.station.abstracts;


public abstract class DaftarTransaksi {
    
    public abstract void setIdTransaksi(int id_transaksi);
    public abstract int getIdTransaksi();
    
    public abstract void setJumlah(int jumlah);
    public abstract int getJumlah();
    
    public abstract void setTotalUang(int TotalUang);
    public abstract int getTotalUang();
    
    public abstract void setNoRekening(String noRekening);
    public abstract String getNoRekening();
    
    public abstract void setTanggal(String tanggal);
    public abstract String getTanggal();
    
    public abstract void setNamaPlgn(String nama_plgn);
    public abstract String getNamaPlgn();
    
    public abstract void setNoTlp(String no_tlp);
    public abstract String getNoTlp();
    
    public abstract void setAlamat(String alamat);
    public abstract String getAlamat();
}
