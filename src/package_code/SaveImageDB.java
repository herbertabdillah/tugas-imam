/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_code;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author AtlantisSeeker
 */
public class SaveImageDB {
    private static service service1;
    
    public static service getservice(){
        return service1;
    }
    
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("gui_image"); 
        
        service1= new service(dataSource);
        
        new JFrameDesign().setVisible(true);
    }
}
    