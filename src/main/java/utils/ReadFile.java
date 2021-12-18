package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class ReadFile {

    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "/src/main/java/textfiles");
    File file = new File(appDir,"phones");
    String charset = "UTF-8";
    BufferedReader reader;
    {
        try {
            reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file), charset));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Properties properties = null;
    public ReadFile() {
        properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int listSize = 2;

    public ArrayList getPhone(){
        ArrayList<String> al = new ArrayList<>();
        for (int i=1; i<=listSize; i++){
            al.add(properties.getProperty("phone"+i+""));
        }
        return al;
    }
}
