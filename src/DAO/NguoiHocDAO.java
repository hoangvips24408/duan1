package DAO;

import entyti.NguoiHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String>{
    String insert_sql="INSERT INTO NguoiHoc (MaNH,HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (?,?,?,?,?,?,?,?,?)";
    String update_sql="UPDATE NguoiHoc SET HoTen =?, NgaySinh =?, GioiTinh =?, DienThoai =?, Email =?, GhiChu =?, MaNV =?, NgayDK =? where MaNH=?";
    String delete_sql="DELETE FROM NguoiHoc where MaNH=?";
    String select_all="SELECT * FROM NguoiHoc";
    String select_byID="SELECT * FROM NguoiHoc where MaNH=?";
    String select_byKey="SELECT * FROM NguoiHoc where HoTen like ?";
    @Override
    public void insert(NguoiHoc entity) {
        JdbcHelper.update(insert_sql, entity.getMaNH(),entity.getHoTen(),entity.getNgaySinh(),entity.isGioiTinh(),entity.getDienThoai(),entity.getEmail(),entity.getGhiChu(),entity.getMaNV(),entity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc entity) {
        JdbcHelper.update(update_sql, entity.getHoTen(),entity.getNgaySinh(),entity.isGioiTinh(),entity.getDienThoai(),entity.getEmail(),entity.getGhiChu(),entity.getMaNV(),entity.getNgayDK(),entity.getMaNH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySql(select_all);
    }

    @Override
    public NguoiHoc selectById(String key) {
        List<NguoiHoc> list = selectBySql(select_byID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiHoc entyti = new NguoiHoc();
                entyti.setMaNH(rs.getString("MaNH"));
                entyti.setHoTen(rs.getString("HoTen"));
                entyti.setNgaySinh(rs.getString("NgaySinh"));
                entyti.setGioiTinh(rs.getBoolean("GioiTinh"));
                entyti.setDienThoai(rs.getString("DienThoai"));
                entyti.setEmail(rs.getString("Email"));
                entyti.setGhiChu(rs.getString("GhiChu"));
                entyti.setMaNV(rs.getString("MaNV"));
                entyti.setNgayDK(rs.getString("NgayDK"));
                list.add(entyti);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
    public List<NguoiHoc> selectByKey(String key) {
        return selectBySql(select_byKey,"%"+key+"%");
    }
    public List<NguoiHoc> selectNotInCourse(int makh,String keyword){
        String sql ="select * from NguoiHoc where HoTen like ? and MaNH not in (select MaNH from HocVien where MaKH=?)";
        return selectBySql(sql, "%"+keyword+"%",makh);
    }
    
}
