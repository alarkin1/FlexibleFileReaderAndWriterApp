 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class FileHandlerService {

    FileReaderStrategy fileReaderMechanism;
    FileWriterStrategy fileWriterMechanism;

    public FileHandlerService(FileReaderStrategy fileReaderMechanism, FileWriterStrategy fileWriterMechanism) {
        setFileReaderMechanism(fileReaderMechanism);
        setFileWriterMechanism(fileWriterMechanism);
    }

    public final void setFileReaderMechanism(FileReaderStrategy fileReaderMechanism) {
        if (fileReaderMechanism != null) {
            this.fileReaderMechanism = fileReaderMechanism;
        }
    }

    public final void setFileWriterMechanism(FileWriterStrategy fileWriterMechanism) {
        if (fileWriterMechanism != null) {
            this.fileWriterMechanism = fileWriterMechanism;
        }
    }

    public final List<Map<String, String>> readFromFile(String path) {
        List<Map<String, String>> output = new ArrayList<>();
        if (path != null && path.isEmpty() == false) {
            try {
                File file = new File(path);
                output = fileReaderMechanism.readFromFile(file);
            } catch (IOException ioe) {
                //output Error to the correct OutputStrategy Object
                System.out.println(ioe.getMessage());
            }
        }
        return output;
    }

    public final void writeToFile(String path, List<Map<String, String>> dataToWrite) {
        if (path != null && path.isEmpty() == false) {
            try {
                File outputFile = new File(path);
                fileWriterMechanism.writeToFile(outputFile, dataToWrite);
            } catch (IOException ioe) {
                //output Error to the correct OutputStrategy Object
                System.out.println(ioe.getMessage());
            }
        }
    }

}
