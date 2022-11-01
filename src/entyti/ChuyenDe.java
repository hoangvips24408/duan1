package entyti;

/**
 *
 * @author Admin
 */
public class ChuyenDe {
    String maCD;
    String tenCD;
    float hocPhi;
    int thoiLuong;
    String hinh;
    String moTa;
    public String getMaCD() {
        return maCD;
    }
    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }
    public String getTenCD() {
        return tenCD;
    }
    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }
    public float getHocPhi() {
        return hocPhi;
    }
    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }
    public int getThoiLuong() {
        return thoiLuong;
    }
    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }
    public String getHinh() {
        return hinh;
    }
    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    @Override
    public String toString(){
        return this.tenCD;
    }
    @Override
    public int hashCode(){
        int hash=5;
        return hash;
    }
    @Override
    public boolean equals(Object obj){
        ChuyenDe other = (ChuyenDe) obj;
        return other.getMaCD().equals(this.getMaCD());
    }
    public ChuyenDe(String maCD, String tenCD, float hocPhi, int thoiLuong, String hinh, String moTa) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.hinh = hinh;
        this.moTa = moTa;
    }
    public ChuyenDe() {
    }

    
}
