package src.constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Checked {
    public static boolean usernameExists(String filePath, String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            int totalLines = 0;
            while(reader.readLine() != null)
                totalLines++;
            reader.close();

            for(int i = 0; i < totalLines; i++) {
                String username_ = Files.readAllLines(Paths.get(filePath)).get(i).substring(10);

                if(username.equals(username_)) {
                    return true;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
