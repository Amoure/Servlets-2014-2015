import java.sql.*;

public class AccesoBaseDatos{
    public static String Base(String nom){

        //Definir el driver y el url de la conexión a la BD teniendo en cuenta el SGBD empleado
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://10.2.7.17:3306/bdtramos";
        Connection con=null;
        int info=0;
        String devo="No se encuentra la localidad";
        try{
            //Carga del driver
            Class.forName(driver);

            //Establecimiento de la conexión. El segundo y tercer argumento son el user
            //y password, por defecto, necesarios para conectarnos como administradores a la BD
            con=DriverManager.getConnection(url,"admin","admin");

            //Obtención de un objeto Statement para ejecutar sentencias SQL
            Statement stmt=con.createStatement();

            //Ejecución de la sentencia SQL y obtención de resultados en un objeto ResultSet
            String sentenciaSQL="SELECT * from localidades where NombreL="+"'"+nom+"'";
            ResultSet rs=stmt.executeQuery(sentenciaSQL);
            
            //Muestra de resultados mediante un bucle que recorre los registros que verifican
            //la sentencia
            
            while(rs.next()){                
                String codigo=rs.getString("CodLoc");
                String nombre=rs.getString("NombreL");
                String censo=rs.getString("Censo");
                String habitantes=rs.getString("Habitantes");
                String codigProv=rs.getString("CodProv");
                devo="<b>Código: </b>"+codigo+"  <b>Nombre:</b> "+nombre+" <b> Censo:</b> "+censo+" <b> Habitantes:</b> "+habitantes+" <b> Código Provincia:</b> "+codigProv;
            }
            
        }catch(ClassNotFoundException e){
            System.out.println("Controlador JDBC no encontrado: "+e.toString());
        }catch(SQLException e){
            System.out.println("Excepcion capturada de SQL: "+e.toString());
       
        //Cierre de la conexión
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(SQLException e){
                System.out.println("No se puede cerrar la conexion: "+e.toString());
            }
        } 
        return devo;
    }
}