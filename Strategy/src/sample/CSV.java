package sample;

import java.io.*;
import java.util.Scanner;

public class CSV extends FileConverter {
    @Override
    public void convert(File file) {
        try {
            String fileContents = "";
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                String s = scanner.nextLine();
                String [] s2 = s.split("\\s\\s+");
                for (String shi: s2)
                {
                    fileContents += shi + ",";
                }

                fileContents = fileContents.substring(0, fileContents.length()-1);
                fileContents+="\n";
            }

            File newFile = new File("src/res/"+file.getName().split("[.]")[0]+".csv");
            BufferedWriter br = new BufferedWriter(new FileWriter(newFile));
            br.write(fileContents);
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
