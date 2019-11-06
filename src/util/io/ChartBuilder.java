package util.io;

import com.google.gson.Gson;
import resource.R;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//TODO
@SuppressWarnings("all")
public class ChartBuilder {

    private String targetFolder;
    private Class basedOn;
    private File[] files;
    private Field[] fields;

    private final Gson json;

    public ChartBuilder(String targetFolder, Class basedOn) {
        this.targetFolder = targetFolder;
        this.fields = basedOn.getFields();
        this.files = new File[fields.length];
        this.json = new Gson();
    }

    public void buildBasedOn(Object data) {
//        for (int i = 0; i < fields.length; i++) {
//            try {
////                loadAndWrite((files[i] = new File(targetFolder + "/" + fields[i].getName() + ".html")), fields[i].get(null), json.toJson(data));
//            } catch (IllegalAccessException e) {
//                System.out.println("Access to private/protected attribute attempt.");
//            }
//        }
    }

    private void loadAndWrite(File file, String template, String data) {
        try {
            Path path = Paths.get(R.string.REPORTS_FOLDER_ADDRESS);
            if(!Files.exists(path))
                Files.createDirectories(path);
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            FileLoader loader = new FileLoader(template);

            String html = loader.loadAsString().replace("$data", data);

            pw.print(html);
            loader.close();
            pw.close();
        } catch (IOException e) {
            System.err.println("Failed creating file " + file.getName() + "\nError: " + e.getMessage());
        }
    }
}
