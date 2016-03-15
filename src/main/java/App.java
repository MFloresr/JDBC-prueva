import java.sql.*;

/**
 * Created by Vipi on 14/03/2016.
 */
public class App {
    public static  void main( String[] arg){
        Connection con =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.4.1/futbol","foot","ball");
            String consulta = "SELECT * FROM equips WHERE nom LIKE '%Real%'";

            Statement peticio = con.createStatement();

            ResultSet resultat = peticio.executeQuery(consulta);

            while (resultat.next()){
                System.out.println(resultat.getString("nom"));
            }


            //prepare statements

            PreparedStatement p =con.prepareStatement("select * from equips where nom=?");

            p.setString(1,"Sabadell");
            resultat = p.executeQuery();

            while (resultat.next()){
                System.out.println(resultat.getString("nom"));
            }

            p.setString(1,"Espanyol");
            resultat = p.executeQuery();

            while (resultat.next()){
                System.out.println(resultat.getString("nom"));
                System.out.println(resultat.getInt("id"));
            }

            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
