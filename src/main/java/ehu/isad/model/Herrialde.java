package ehu.isad.model;

public class Herrialde {

    private String izena;
    private String taldea;
    private String abestia;
    private int puntuak = 0;
    private boolean boz = false;

    public Herrialde(String izena, String taldea, String abestia) {
        this.izena = izena;
        this.taldea = taldea;
        this.abestia = abestia;
    }

    public void gehituPuntuak(int n){ puntuak =+ n; }

    public void bozkatu(){boz=true;}

    public boolean bozkatuDu(){return boz;}
}
