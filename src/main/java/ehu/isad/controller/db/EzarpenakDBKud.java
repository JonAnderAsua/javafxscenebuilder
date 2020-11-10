package ehu.isad.controller.db;

import ehu.isad.model.Herrialde;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EzarpenakDBKud {

  // singleton patroia

  private static EzarpenakDBKud instantzia = new EzarpenakDBKud();

  public static EzarpenakDBKud getInstantzia(){
      return instantzia;
  };

  private EzarpenakDBKud (){}

  DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

  public List<Herrialde> lortuEzarpenak(){

    List<Herrialde> emaitza = new ArrayList<>();

    String query = "select herrialdea, artista, abestia,bandera, puntuak from Ordezkaritza\n" +
            " JOIN ParteHartzea on ParteHartzea.izena=Ordezkaritza.herrialdea\n" +
            " JOIN Herrialde on Herrialde.izena=Ordezkaritza.herrialdea\n" +
            " where ParteHartzea.urtea = strftime('%Y', 'now') and Ordezkaritza.urtea =strftime('%Y','now') and etorrikoDa='Bai'";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {
        String izena = rs.getString("herrialdea");
        String artista = rs.getString("artista");
        String abestia = rs.getString("abestia");
        String bandera = rs.getString("bandera");
        Integer puntuak = rs.getInt("puntuak");
        Herrialde herrialde = new Herrialde(izena, artista, abestia, "irudiak/"+bandera+".png",puntuak);
        emaitza.add(herrialde);
      }
    }catch (SQLException e){
      System.err.println(e);
    }
    return emaitza;
  }

  public void eguneratu() {
    dbkud.execSQL("INSERT INTO properties ('userid', 'key', 'value') values ('5','6','7')");
  }

  public boolean bozkatuDu(Herrialde h) throws SQLException {
    ResultSet rs = dbkud.execSQL("SELECT bozkatuDu FROM BOZKAKETA WHERE bozkatuDU LIKE "+h.getName()+";");
    if(rs.next()){
      return true;
    }
    else{
      return false;
    }
  }

  public List<Herrialde> topLortu() throws SQLException {
    ResultSet rs = dbkud.execSQL("select herrialdea,artista,abestia,puntuak from Ordezkaritza where urtea=YEAR(DATE())");
    int i = 0;
    List<Herrialde> lista = new ArrayList<Herrialde>();
    while(rs.next() && i<4){
      String herrialdea = rs.getString("herrialdea");
      String artista = rs.getString("artista");
      String abestia = rs.getString("abestia");
      int puntuak = rs.getInt("puntuak");
      Herrialde h = new Herrialde(herrialdea,artista,abestia,"irudiak/"+herrialdea+".png",puntuak);
    }
    return lista;
  }
}
