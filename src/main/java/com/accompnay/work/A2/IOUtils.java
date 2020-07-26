package com.accompnay.work.A2;

import java.io.*;

public class IOUtils {

    private static final String encoding = "UTF-8";

    static BufferedReader getBufferedReader(String filePath) throws UnsupportedEncodingException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);
        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, IOUtils.encoding);
        return new BufferedReader(inputStreamReader);
    }

    static BufferedWriter getBufferWriter(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        return new BufferedWriter(new FileWriter(file));
    }
}
