package t10;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import t10.db.JDBC;


public class T10 {
    public static void main(String[] args) throws SQLException {
        JDBC db;
        ArrayList postos = null;
        
        db = new JDBC("postosdb");
        try {
            postos = db.getPostos();
            for(int i=0; i<postos.size(); i++){
                ((Posto)postos.get(i)).setValores(db.getPrecos(((Posto)postos.get(i)).getIdposto()));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T10.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0; i<postos.size(); i++){
            System.out.println(postos.get(i).toString());
        }
    }
}
