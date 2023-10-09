package com.ilovethislanguagesomuch;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class download {
    public static void downplease(String u, String path) {
        String audioUrl = u; // Replace with the URL of the audio file you want to com.ilovethislanguagesomuch.download
        String saveFilePath = path; // Replace with the desired save path

        try {
            // Create a URL object with the audio file's URL
            URL url = new URL(audioUrl);

            // Open a connection to the URL
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // Get the HTTP response code
            int responseCode = httpConn.getResponseCode();

            // Check if the request was successful (HTTP status code 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Open input stream from the connection
                InputStream inputStream = httpConn.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                // Create a FileOutputStream to save the audio file
                FileOutputStream outputStream = new FileOutputStream(saveFilePath);

                // Read and write the audio file
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                // Close streams
                outputStream.close();
                bufferedInputStream.close();

                System.out.println("Audio file downloaded successfully.");
            } else {
                System.out.println("HTTP GET request failed with response code: " + responseCode);
            }

            // Close the connection
            httpConn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

