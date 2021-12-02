/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kas.model.DatabaseConfig;
import kas.model.Kas;

/**
 *
 * @author Azka Pratama
 */
public class KasDAOProses implements KasDAO {
    Connection connection = null;
    ResultSet resultset = null;
    Statement statement = null;
    PreparedStatement preparedstatement = null;
    
    @Override
    public List<Kas> get() {
        List<Kas> list =new ArrayList<Kas>();
        try {
            String sql = "select * from tb_kas";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery(sql);
            while(resultset.next()){
                Kas kas= new Kas();
                kas.setId(resultset.getInt("id"));
                kas.setTanggal(resultset.getString("tanggal"));
                kas.setKeterangan(resultset.getString("keterangan"));
                kas.setPemasukan(resultset.getString("pemasukan"));
                kas.setPengeluaran(resultset.getString("pengeluaran"));
                list.add(kas);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Kas kas) {
        boolean flag = false;
         try {
            String sql = "insert into tb_kas(tanggal,keterangan,pemasukan,pengeluaran) values(?,?,?,?)";
            connection = DatabaseConfig.openConnection();
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, kas.getTanggal());
            preparedstatement.setString(2, kas.getKeterangan());
            preparedstatement.setString(3, kas.getPemasukan());
            preparedstatement.setString(4, kas.getPengeluaran());
            preparedstatement.executeUpdate();
            flag = true ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return flag;
    }

    @Override
    public Kas getSinggle(int id){
        Kas kas = null;
        try{
            String sql = "select * from tb_kas where id=?";
            connection = DatabaseConfig.openConnection();
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, id);
            resultset = preparedstatement.executeQuery();
            while(resultset.next()){
                kas= new Kas();
                kas.setId(resultset.getInt("id"));
                kas.setTanggal(resultset.getString("tanggal"));
                kas.setKeterangan(resultset.getString("keterangan"));
                kas.setPemasukan(resultset.getString("pemasukan"));
                kas.setPengeluaran(resultset.getString("pengeluaran"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return kas;
    }

    @Override
    public boolean update(Kas kas) {
        boolean flag = false;
        try{
             String sql ="update tb_kas set tanggal=?,keterangan=?,pemasukan=?,pengeluaran=? where id=?";
             connection = DatabaseConfig.openConnection();
             preparedstatement = connection.prepareStatement(sql);
             preparedstatement.setString(1, kas.getTanggal());
             preparedstatement.setString(2, kas.getKeterangan());
             preparedstatement.setString(3, kas.getPemasukan());
             preparedstatement.setString(4, kas.getPengeluaran());
             preparedstatement.setInt(5, kas.getId());
             preparedstatement.executeUpdate();
             flag = true ;
         }catch(SQLException ex){
             ex.printStackTrace();
         }
         return flag;
    }

    @Override
    public boolean delete(int id) {
       boolean flag = false;
       try{
           String sql = "delete from tb_kas where id=?";
            connection = DatabaseConfig.openConnection();
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, id);
            preparedstatement.executeUpdate();
            flag = true;
       }catch(SQLException ex){
           ex.printStackTrace();
       }
       return flag;
    }
}
