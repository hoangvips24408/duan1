package entyti;

/**
 *
 * @author Admin
 */
public class PhongHoc {
    String maPH;
    String tenPH;
    int soPH;
    String gv;
    String ghiChu;

    public PhongHoc() {
    }

    public PhongHoc(String maPH, String tenPH, int soPH, String gv, String ghiChu) {
        this.maPH = maPH;
        this.tenPH = tenPH;
        this.soPH = soPH;
        this.gv = gv;
        this.ghiChu = ghiChu;
    }

    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }

    public String getTenPH() {
        return tenPH;
    }

    public void setTenPH(String tenPH) {
        this.tenPH = tenPH;
    }

    public int getSoPH() {
        return soPH;
    }

    public void setSoPH(int soPH) {
        this.soPH = soPH;
    }

    public String getGv() {
        return gv;
    }

    public void setGv(String gv) {
        this.gv = gv;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
