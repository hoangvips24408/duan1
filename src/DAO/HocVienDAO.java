package DAO;

import entyti.HocVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */     
public class HocVienDAO extends EduSysDAO<HocVien, Integer>{
    String insert_sql="INSERT INTO HocVien ( MaKH, MaNH, Diem) VALUES (?,?,?)";
    String update_sql="UPDATE HocVien SET MaKH =?, MaNH =?, Diem =? where MaHV=?";
    String delete_sql="DELETE FROM HocVien where MaHV=?";
    String select_all="SELECT * FROM HocVien";
    String select_byID="SELECT * FROM HocVien where MaHV=?";
    @Override
    public void insert(HocVien entity) {
        JdbcHelper.update(insert_sql,entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JdbcHelper.update(update_sql,entity.getMaKH(),entity.getMaNH(),entity.getDiem(), entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return selectBySql(select_all);
    }

    @Override
    public HocVien selectById(Integer key) {
        List<HocVien> list = selectBySql(select_byID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
         try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HocVien entyti = new HocVien();
                entyti.setMaHV(rs.getInt("MaHV"));
                entyti.setMaKH(rs.getInt("MaKH"));
                entyti.setMaNH(rs.getString("MaNH"));
                entyti.setDiem(rs.getFloat("Diem"));
                list.add(entyti);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
    public List<HocVien> selectByKhoaHoc(int makh){
        String sql ="select * from HocVien where MaKH=?";
        return this.selectBySql(sql, makh);
    }

}
