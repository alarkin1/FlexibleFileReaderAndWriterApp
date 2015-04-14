/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class FileWriterText implements FileWriterStrategy{

    FormatStrategy formatter;

    public FileWriterText(FormatStrategy formatter) {
        setFormatter(formatter);
    }

    @Override
    public final void setFormatter(FormatStrategy formatter) {
        if(formatter == null)
            throw new NullPointerException(GlobalErrorMessagesAndVariables.MUST_PROVIDE_FORMATTER_ERROR_MESSAGE);
        this.formatter = formatter;
    }
    
    @Override
    public final void writeToFile(File file, List<Map<String, String>> dataToWrite) throws IOException {
        if(file == null)
            throw new NullPointerException(GlobalErrorMessagesAndVariables.MUST_PROVIDE_AN_OUTPUT_FILE_ERROR_MESSAGE);
        PrintWriter fileWriter = new PrintWriter(new FileWriter(file));
        fileWriter.print(formatter.encode(dataToWrite));
        fileWriter.flush();
        fileWriter.close();
    }
    
}
