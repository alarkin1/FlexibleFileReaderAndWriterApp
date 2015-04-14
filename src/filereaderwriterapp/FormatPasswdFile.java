/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author Alex
 */
public class FormatPasswdFile implements FormatStrategy {

    private final String DELIM = ":";

    @Override
    public final String encode(List<Map<String, String>> decodedListOfMaps) {
        String encodedPasswdString = "";
        for (Map<String, String> mapOfLine : decodedListOfMaps) {
            String passwdLine = "";
            for (Entry<String, String> entry : mapOfLine.entrySet()) {
                if (entry.getValue().equals(DELIM) == false) {
                    passwdLine += entry.getValue() + DELIM;
                } else {
                    String lineBreak = System.getProperty("line.separator");
                    passwdLine = passwdLine.substring(0, passwdLine.length()-1);
                    passwdLine += lineBreak;
                    break;
                }
            }
            encodedPasswdString += passwdLine;
        }
        return encodedPasswdString;
    }

    @Override
    public final List<Map<String, String>> decode(String encodedData) {
        String[] arrayOfLines = encodedData.split("\n");
        List<Map<String, String>> decodedData = new ArrayList<>();
        for (String line : arrayOfLines) {
            String[] sectionsOfLine = line.split(DELIM);
            Map<String, String> mapOfLine = new LinkedHashMap<>();
            mapOfLine.put("username", sectionsOfLine[0]);
            mapOfLine.put("password", sectionsOfLine[1]);
            mapOfLine.put("userId", sectionsOfLine[2]);
            mapOfLine.put("groupId", sectionsOfLine[3]);
            mapOfLine.put("fullname", sectionsOfLine[4]);
            mapOfLine.put("homeDir", sectionsOfLine[5]);
            mapOfLine.put("shellAccount", sectionsOfLine[6]);
            mapOfLine.put("DELIM", ":");
            decodedData.add(mapOfLine);
        }
        return decodedData;
    }
}
