package DAO;

import entyti.NhanVien;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String>{
    String insert_sql="INSERT INTO NhanVien(MaNV,MatKhau, HoTen, VaiTro) VALUES (?, ?, ?,?)";
    String update_sql="UPDATE NhanVien SET HoTen = ?,MatKhau = ?, VaiTro = ?, MaNV = ?";
    String delete_sql="DELETE FROM NhanVien where MaNV=?";
    String select_all="SELECT * FROM NhanVien";
    String select_byID="SELECT * FROM NhanVien where MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(insert_sql, entity.getMaNV(),entity.getMatKhau(),entity.getHoTen(),entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(update_sql, entity.getMaNV(),entity.getMatKhau(),entity.isVaiTro(),entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(delete_sql,id );
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(select_all);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = selectBySql(select_byID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entyti = new NhanVien();
                entyti.setMaNV(rs.getString("MaNV"));
                entyti.setMatKhau(rs.getString("MatKhau"));
                entyti.setHoTen(rs.getString("HoTen"));
                entyti.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entyti);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
}
