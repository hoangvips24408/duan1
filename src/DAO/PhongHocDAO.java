package DAO;

import entyti.PhongHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class PhongHocDAO extends EduSysDAO<PhongHoc, String> {

    String insert_sql = "INSERT INTO PhongHoc(MaPH,TenPH,SoPH,GV,GhiChu) VALUES (?, ?, ?,?,?)";
    String update_sql = "UPDATE PhongHoc SET TenPH = ?,SoPH = ?, GV = ?, GhiChu = ?";
    String delete_sql = "DELETE FROM PhongHoc where MaPH=?";
    String select_all = "SELECT * FROM PhongHoc";
    String select_byID = "SELECT * FROM PhongHoc where MaPH=?";

    @Override
    public void insert(PhongHoc entity) {
        JdbcHelper.update(insert_sql, entity.getMaPH(),entity.getTenPH(),entity.getSoPH(),entity.getGv(),entity.getGhiChu());
    }

    @Override
    public void update(PhongHoc entity) {
        JdbcHelper.update(update_sql,entity.getTenPH(),entity.getSoPH(),entity.getGv(),entity.getGhiChu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<PhongHoc> selectAll() {
        return selectBySql(select_all);
    }

    @Override
    public PhongHoc selectById(String key) {
        List<PhongHoc> list = selectBySql(select_byID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<PhongHoc> selectBySql(String sql, Object... args) {
        List<PhongHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhongHoc entyti = new PhongHoc();
                entyti.setMaPH(rs.getString("MaPH"));
                entyti.setGhiChu(rs.getString("GhiChu"));
                entyti.setGv(rs.getString("GV"));
                entyti.setSoPH(rs.getInt("SOPH"));
                entyti.setTenPH(rs.getString("TenPH"));
                list.add(entyti);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }
    }

 

