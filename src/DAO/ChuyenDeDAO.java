
package DAO;

import entyti.ChuyenDe;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String>{
    String insert_sql="INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa)VALUES (?,?,?,?,?,?)";
    String update_sql="UPDATE ChuyenDe SET TenCD =?, HocPhi =?, ThoiLuong =?, Hinh =?, MoTa =? where MaCD=?";
    String delete_sql="DELETE FROM ChuyenDe where MaCD=?";
    String select_all="SELECT * FROM ChuyenDe";
    String select_byID="SELECT * FROM ChuyenDe where MaCD=?";
    @Override
    public void insert(ChuyenDe entity) {
        JdbcHelper.update(insert_sql, entity.getMaCD(),entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        JdbcHelper.update(update_sql,entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa(), entity.getMaCD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return selectBySql(select_all);
    }

    @Override
    public ChuyenDe selectById(String key) {
        List<ChuyenDe> list = selectBySql(select_byID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
         try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChuyenDe entyti = new ChuyenDe();
                entyti.setMaCD(rs.getString("MaCD"));
                entyti.setTenCD(rs.getString("TenCD"));
                entyti.setHocPhi(rs.getFloat("HocPhi"));
                entyti.setThoiLuong(rs.getInt("ThoiLuong"));
                entyti.setHinh(rs.getString("Hinh"));
                entyti.setMoTa(rs.getString("MoTa"));
                list.add(entyti);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

}
