package com.epam;

import com.epam.data.parsers.ParseXLSXFile;
import com.epam.model.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ProjectProperty property = new ProjectProperty();

        Logger log = Logger.getLogger(Main.class);

        //check if property is set
        /*  System.out.println(property.getPassword());


        JsonParser jsonParser = new JsonParser();
        File file = new File("src\\main\\resources\\users.json");

        JsonObject object = (JsonObject) jsonParser.parse(new FileReader(file));
        JsonArray arr = object.getAsJsonArray();
        System.out.println(arr.getAsString());*/

        log.info("test");
        ParseXLSXFile parser = new ParseXLSXFile();
        List<User> list = parser.parseUsers("users.xlsx");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }


    }
}
