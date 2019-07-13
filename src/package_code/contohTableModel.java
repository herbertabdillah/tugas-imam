/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_code;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author AtlantisSeeker
 */
public class contohTableModel extends AbstractTableModel{
    List<contoh> listOfcontoh=new ArrayList<contoh>();
    private final String[] header ={"Judul", "Nama Gambar"};
    
    public contohTableModel(List<contoh> listOfcontoh){
        this.listOfcontoh=listOfcontoh;
    }
    
    public void save(contoh contoh1){
        listOfcontoh.add(contoh1);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public contoh findOne(int index){
        return listOfcontoh.get(index);
    }

    @Override
    public int getRowCount() {
        return listOfcontoh.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        contoh contoh1=listOfcontoh.get(rowIndex);
        switch(columnIndex){
            case 0 : return contoh1.getTitle();
            case 1 : return contoh1.getImage();
            default : return null;
        }
    }
    
}
