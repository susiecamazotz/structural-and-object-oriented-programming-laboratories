package laboratories9and10;

import java.io.Serial;

public class FileFormatException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;
    protected int lineNumber;
    protected String info;
    protected String fileName;

    @Override
    public String toString() {
        return "FileFormatException{" + "lineNumber=" + lineNumber + ", info='" + info + '\'' + ", fileName='" + fileName + '\'' + '}';
    }

    public FileFormatException(String fileName, int lineNo, String info) {
        this.fileName = fileName;
        this.lineNumber = lineNo;
        this.info = info;
    }

    public int getLineNo() {
        return lineNumber;
    }

    public String getInfo() {
        return info;
    }

    public String getFileName() {
        return fileName;
    }
}
