package lk.ijse.MobileVision.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO {
    List<T> getAll() throws SQLException;
    boolean save(T t) throws SQLException ;
    boolean update(T t) throws SQLException;
    boolean delete(String id) throws SQLException;
    boolean exist(String id) throws SQLException;
    String generateId() throws SQLException ;
    T search(String s) throws SQLException;
}
