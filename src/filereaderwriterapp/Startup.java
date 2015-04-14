/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriterapp;

import java.io.File;

/**
 *
 * @author Alex
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    //I 
    public static void main(String[] args) {
        FileHandlerService fileService = new FileHandlerService(new FileReaderText(new FormatPasswdFile()), new FileWriterText(new FormatPasswdFile()));

        fileService.writeToFile(File.separatorChar + "Users" + File.separatorChar + "Alex" + File.separatorChar + "Desktop" + File.separatorChar + "newpasswd.txt", fileService.readFromFile(File.separatorChar + "Users" + File.separatorChar + "Alex" + File.separatorChar + "Desktop" + File.separatorChar + "passwd.txt"));

    }

}
