package DAO;

import entyti.KhoaHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer> {

    String insert_sql = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (?,?,?,?,?,?,?)";
    String update_sql = "UPDATE KhoaHoc SET MaCD =?, HocPhi =?, ThoiLuong =?, NgayKG =?, GhiChu =?, MaNV =?, NgayTao =? where MaKH=?";
    String delete_sql = "DELETE FROM KhoaHoc where MaKH=?";
    String select_all = "SELECT * FROM KhoaHoc";
    String select_byID = "SELECT * FROM KhoaHoc where MaKH=?";
    String select_byMCD = "SELECT * FROM KhoaHoc where MaCD=?";

    @Override
    public void insert(KhoaHoc entity) {
        JdbcHelper.update(insert_sql, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
    }

    @Override
    public void update(KhoaHoc entity) {
        JdbcHelper.update(update_sql, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao(), entity.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(update_sql, id);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return selectBySql(select_all);
    }

    @Override
    public KhoaHoc selectById(Integer key) {
        List<KhoaHoc> list = selectBySql(select_byID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhoaHoc entyti = new KhoaHoc();
                entyti.setMaKH(rs.getInt("MaKH"));
                entyti.setMaCD(rs.getString("MaCD"));
                entyti.setHocPhi(rs.getFloat("HocPhi"));
                entyti.setThoiLuong(rs.getInt("ThoiLuong"));
                entyti.setNgayKG(rs.getString("NgayKG"));
                entyti.setGhiChu(rs.getString("GhiChu"));
                entyti.setMaNV(rs.getString("MaNV"));
                entyti.setNgayTao(rs.getString("NgayTao"));
                list.add(entyti);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
    public List<KhoaHoc> selectKHbyCD(String maCD) {
        return selectBySql(select_byMCD,maCD);
    }
    public List<Integer> seletyear(){
        String sql="select DISTINCT year(NgayKG) from KhoaHoc order by year(NgayKG) desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
