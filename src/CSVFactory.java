import java.io.PrintWriter;
import java.io.IOException;
import java.util.Calendar;
import java.io.File;

public class CSVFactory {
    private String 		headers;
    private String		path;
    private PrintWriter writer;
    private File 		file;
    private int 		counter;
    private int 		currentLine;
    private boolean 	printTrace;

    /* Init the factory creating an empty csv file */
    public CSVFactory(String directory) {
        this.path 			= directory;
        this.file 			= new File(buildCSVName());
        this.counter 		= 0;
        this.currentLine 	= 0;

        try {
            this.file.createNewFile();
            this.writer = new PrintWriter(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Overload the constructor calling the other constructor *
     * 		     And writing the provided headers             */
    public CSVFactory(String directory, String... headers) {
        this(directory);
        setHeaders(headers);
    }

    /* If the headers wasn't provided in the constructor it *
     * 				  will be written here                  */
    public void setHeaders(String... headers) {
        if(this.headers != null)
            return;

        StringBuffer builder = new StringBuffer();

        for(int i = 0; i < headers.length; i++)
            builder.append(addSlashes(headers[i]) + (i == headers.length - 1 ? "" : ","));

        this.headers = builder.toString();
        writeInFile(this.headers, false);
        this.writer.flush();
    }

    /*    Add a line in the file. If the number of argument provided    *
     * is bigger than the header length, the subsequent will be ignored */
    public void addRecord(Object... values) {
        Object value;
        StringBuffer builder = new StringBuffer();

        for(int i = 0; i < getHeaderLength(); i++) {
            value = (i >= values.length ? "" : values[i]);
            builder.append(addSlashes(value.toString())+ (i == getHeaderLength() - 1 ? "" : ","));
        }

        writeInFile("\n", false);
        writeInFile(builder.toString(), this.printTrace);
        this.currentLine++;
    }

    /* Write one or more lines in the csv file depending on the *
     *			   quantity of arguments provided				*/
    public void addRecords(Object... values) {
        if(values.length <= getHeaderLength()){
            addRecord(values);
            return;
        }

        //int recordsQtd = values.length % getHeaderLength();

        addRecord(subList(values, 0, getHeaderLength()));
        values = subList(values, getHeaderLength());

        addRecords(values);
    }

    /* Crates a new file and copy the header */
    public void newFile() {
        close();

        this.file = new File(buildCSVName());

        try {
            if (this.file.createNewFile()) {
                this.writer = new PrintWriter(this.file);
                this.currentLine = 0;
                writeInFile(this.headers, false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Returns the file size in Bytes */
    public long getFileSize() {
        return this.file.length();
    }

    /* Returns the number of records/lines written in the file */
    public int getNumberOfRecords() {
        return this.currentLine;
    }

    /* returns the name of the file (auto generated by the program) *
     *					 that contains the records				    */
    public String getFileName() {
        return this.file.getName();
    }

    /* A setter for the boolean that indicated if the program must *
     *				  or not print all written line 			   */
    public void printTrace(boolean printTrace) {
        this.printTrace = printTrace;
    }

    public void flush() {
        writer.flush();
    }

    /* Closes the writer and releases the resource */
    public void close() {
        writer.flush();
        writer.close();
    }

    private void writeInFile(String record, boolean printTrace) {
        if(printTrace)
            System.out.println("Writing line " + this.currentLine + "... ");

        this.writer.print(record);
    }

    private int getHeaderLength() {
        return this.headers.split(",").length;
    }

    private String buildCSVName() {
        if(this.path.contains(".csv"))
            return this.path;

        return this.path + "\\csv" + Calendar.getInstance().getTimeInMillis() + "_" + (this.counter++) + ".csv";
    }

    private String addSlashes(String str) {
        return str.replace("\n", "\\\\n").replace("\t", "\\\\t").replace("\r", "\\\\r");
    }

    private Object[] subList(Object[] list, int start, int end) {
        Object[] arr = new Object[end - start];

        if(start > list.length || end > list.length) {
            return arr;
        }

        if(start > end){
            int aux = start;
            start = end;
            end = aux;
        }

        for(int i = start, j = 0; i < end; i++, j++) {
            arr[j] = list[i];
        }

        return arr;
    }

    private Object[] subList(Object[] list, int start) {
        Object[] arr = new Object[list.length - start];

        if(start > list.length)
            return arr;

        for(int i = start, j = 0; j < arr.length; i++, j++) {
            arr[j] = list[i];
        }

        return arr;
    }
}