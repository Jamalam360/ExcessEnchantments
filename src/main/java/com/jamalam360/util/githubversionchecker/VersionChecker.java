package com.jamalam360.util.githubversionchecker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class VersionChecker {
    public static String getGithubResponse() throws Throwable {
        String link = "https://raw.githubusercontent.com/Jamalam360/ExcessEnchantments/main/version.txt";
        URL githubUrl = new URL(link);
        HttpURLConnection githubHttp = (HttpURLConnection) githubUrl.openConnection();
        InputStream githubStream = githubHttp.getInputStream();
        return githubGetStringFromStream(githubStream);
    }

    // ConvertStreamToString() Utility - we name it as githubGetStringFromStream()
    private static String githubGetStringFromStream(InputStream githubStream) throws IOException {
        if (githubStream != null) {
            Writer githubWriter = new StringWriter();

            char[] githubBuffer = new char[2048];
            try {
                Reader githubReader = new BufferedReader(new InputStreamReader(githubStream, StandardCharsets.UTF_8));
                int counter;
                while ((counter = githubReader.read(githubBuffer)) != -1) {
                    githubWriter.write(githubBuffer, 0, counter);
                }
            } finally {
                githubStream.close();
            }
            return githubWriter.toString();
        } else {
            return "No Contents";
        }
    }
}
