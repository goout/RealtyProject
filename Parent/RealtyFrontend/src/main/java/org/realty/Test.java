package org.realty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.out;


public class Test {
    public static void main(String[] args)  {

        Locale loc = new Locale("ru","");
       // Locale loc = Locale.ENGLISH;
        ResourceBundle rbund = ResourceBundle.getBundle("org.realty.Translations", loc);
        String str = rbund.getString("index.title");
        System.out.printf("title: %s",str);



    }

}
