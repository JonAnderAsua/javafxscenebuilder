package ehu.isad.model;

import javafx.scene.image.Image;

public class Herrialde {

    private String izena;
    private String taldea;
    private String abestia;
    private int puntuak ;
    private Image irudia;
    private String irudiPath;

    public Herrialde(String izena, String taldea, String abestia, String irudiP,int punt) {
        this.izena = izena;
        this.taldea = taldea;
        this.abestia = abestia;
        this.irudiPath = irudiP;
        this.irudia = new Image(irudiP);
        this.puntuak = punt;
    }

    public void gehituPuntuak(int n){ puntuak =+ n; }

    public String getName(){return izena;}

    public Image getIrudia() {
        return irudia;
    }

    public String getIrudiPath() {
        return irudiPath;
    }

    public void setPuntuak(int n) {
        this.puntuak = n;
    }
}
