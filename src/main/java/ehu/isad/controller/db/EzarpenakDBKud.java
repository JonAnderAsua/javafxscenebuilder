package ehu.isad.controller.db;

import ehu.isad.model.Ezarpena;
import ehu.isad.model.Herrialde;

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

    String query = "select herrialdea,artista,abestia from Ordezkaritza where urtea=YEAR(CURDATE())";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {
        String herrialdea = rs.getString("herrialdea");
        String artista = rs.getString("artista");
        String abestia = rs.getString("abestia");


        emaitza.add(new Herrialde(herrialdea,artista,abestia));
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
}
