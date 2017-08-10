package com.epam;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProperty {

    private InputStream input;
    private Properties properties;
    private String propertyFile="gmailconfig.property";

    public ProjectProperty()  {
        input=getClass().getClassLoader().getResourceAsStream(propertyFile);
        if(input!=null) {
            properties=new Properties();
            try {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String getKey(){
        return properties.getProperty("key");
    }

    public String getValue(){
        return properties.getProperty("value");
    }

    public String getUrl(){
        return properties.getProperty("url");
    }

    public String getSubject(){
        return properties.getProperty("subject");
    }

    public String getLogin(){
        return properties.getProperty("login");
    }

    public String getText(){
        return properties.getProperty("text");
    }

}
