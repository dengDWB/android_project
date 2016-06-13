package activity.dengwenbin.com.dopdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 40284 on 2016/6/8.
 */
public class DownloadFile {

    public static void DownloadFile(String fileURL,File directory) {
        try {
            FileOutputStream outFile = new FileOutputStream(directory);
            URL url = new URL(fileURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.connect();

            InputStream in = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=in.read(bytes))>0){
                outFile.write(bytes,0,len);
            }
            outFile.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
