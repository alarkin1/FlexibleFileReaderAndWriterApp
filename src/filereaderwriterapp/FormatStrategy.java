/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public interface FormatStrategy {
    public abstract List<Map<String, String>> decode(String encodedData);
    public abstract String encode(List<Map<String, String>> decodedListOfMaps);
}
