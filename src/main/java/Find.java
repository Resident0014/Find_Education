import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Find {

    private ArrayList<File> roadToFile = new ArrayList();

    List<File> search(File dir, String fileName, boolean moreDir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File entry: files) {
                if (moreDir && entry.isDirectory()) {
                    search(entry, fileName, moreDir);
                }
                else {
                    if (entry.getName().equals(fileName)) {
                        roadToFile.add(entry);
                    }
                }
            }
        }
        return roadToFile;
    }
}
