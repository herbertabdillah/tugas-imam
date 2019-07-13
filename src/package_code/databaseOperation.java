/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author AtlantisSeeker
 */
public class databaseOperation {
    Connection connection;
    PreparedStatement preparedStatement;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public void save(contoh contoh) throws SQLException{
        preparedStatement=connection.prepareStatement("insert into contoh(judul_item, image) values(?,?)");
        preparedStatement.setString(1, contoh.getTitle());
        preparedStatement.setString(2, contoh.getImage());
        preparedStatement.executeUpdate();
    }
    
    public List<contoh> findAll() throws SQLException{
        List<contoh> listOfcontoh=new ArrayList<>();
        preparedStatement=connection.prepareStatement("Select * from contoh");
        ResultSet rs = preparedStatement.executeQuery();
        
        while(rs.next()){
            contoh contoh1=new contoh();
            contoh1.setId(rs.getInt("id_item"));
            contoh1.setTitle(rs.getString("judul_item"));
            contoh1.setImage(rs.getString("image"));
            listOfcontoh.add(contoh1);
        }
        return listOfcontoh;
    }
}
