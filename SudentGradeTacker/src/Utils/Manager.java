package Utils;

import java.util.*;

public class Manager {

    public static String IdGenerator(String name, int len){
        String suffix = "SDT_";
        StringBuilder genId = new StringBuilder(suffix + name.substring(0, 4) + "_");

        Random rand = new Random();

        for(int i = 0; i < len; i++){
            genId.append(rand.nextInt(10));
        }

        return genId.toString();
    }
}
