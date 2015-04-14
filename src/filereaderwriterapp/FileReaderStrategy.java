/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public interface FileReaderStrategy {

    public abstract void setFormatter(FormatStrategy formatter);

    public abstract List<Map<String, String>> readFromFile(File file) throws IOException;
}
