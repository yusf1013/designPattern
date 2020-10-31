package sample;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.Scanner;

public class XML extends FileConverter {
    @Override
    public void convert(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String toWrite = "";
            String s2 = scanner.nextLine();
            String [] list = s2.split("\\s\\s+");
            while (scanner.hasNext())
            {
                String s3[] = scanner.nextLine().split("\\s\\s+");
                toWrite += "<Student>\n";
                for(int i=0; i<list.length; i++) {
                    toWrite += "\t<"+ list[i] + ">" + s3[i] + "</" + list[i] + ">" + "\n";
                }
                toWrite+="</Student>\n\n";
            }
            //System.out.println(toWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/res/"+file.getName().split("[.]")[0]+".xml")));
            bufferedWriter.write(toWrite);
            bufferedWriter.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Success");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
