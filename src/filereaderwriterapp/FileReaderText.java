/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.io.*;
import java.util.*;

/**
 *
 * @author Alex
 */
public class FileReaderText implements FileReaderStrategy {

    FormatStrategy formatter;

    public FileReaderText(FormatStrategy formatter) {
        setFormatter(formatter);
    }

    @Override
    public final void setFormatter(FormatStrategy formatter) {
        this.formatter = formatter;
    }

    @Override
    public final List<Map<String, String>> readFromFile(File file) throws IOException {
        String fileText;
        if (file == null || file.exists() == false) {
            throw new NullPointerException(GlobalErrorMessagesAndVariables.INPUT_FILE_NOT_FOUND_ERROR_MESSAGE);
        } else {
            Scanner fileReader = new Scanner(new BufferedReader(new FileReader(file)));
            fileText = fileReader.useDelimiter(GlobalErrorMessagesAndVariables.EOF).next();
            fileReader.close();
        }
        return formatter.decode(fileText);
    }

}
