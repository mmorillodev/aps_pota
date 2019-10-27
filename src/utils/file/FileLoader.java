package utils.file;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    private BufferedReader reader;
    private boolean closed;

    public FileLoader(String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(new File(filePath)));
    }

    public String loadAsString() throws IOException {
        if(closed)
            throw new ClosedStreamException();

        StringBuilder builder = new StringBuilder();

        for(String currentLine = ""; (currentLine = reader.readLine()) != null; ) {
            builder.append(currentLine).append( "\n");
        }

        return builder.toString();
    }

    public void close() throws IOException {
        reader.close();
        closed = true;
    }

    class ClosedStreamException extends IOException {

        ClosedStreamException() {}

        ClosedStreamException(String msg) {
            super(msg);
        }
    }
}
