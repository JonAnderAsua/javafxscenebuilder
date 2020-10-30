package ehu.isad.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;

public class Irudia {

    private static Irudia irudia = new Irudia();

    private Irudia(){}

    public static Irudia getInstantzia(){return irudia;}

    public Image irudiaKargatu(String s){
        InputStream is = getClass().getResourceAsStream("/"+s+".png");
        BufferedReader reader = imageIO.read(is);
        return SwingFXUUtils.toFXImage(reader,null);
    }

}
