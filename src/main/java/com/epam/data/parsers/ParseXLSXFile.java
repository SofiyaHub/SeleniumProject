package com.epam.data.parsers;

import com.epam.model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseXLSXFile {
    File file;

    public List<User> parseUsers(String filePath) {
        List<User> userList=new ArrayList<User>();

        file=new File(filePath);
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(filePath);
            XSSFWorkbook book=new XSSFWorkbook(input);
            XSSFSheet sheet=book.getSheetAt(0);
            Iterator<Row> rowIterator=sheet.iterator();
            User user;
            String login;
            String password;

            while (rowIterator.hasNext()){
                Row row=rowIterator.next();

                Iterator<Cell> cellIterator=row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell=cellIterator.next();
                    login=cell.getStringCellValue();

                    password=cellIterator.next().getStringCellValue();
                    user=new User(login, password);
                    userList.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
