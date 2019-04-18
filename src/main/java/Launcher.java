import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

public class Launcher {

    @Option(name ="-r", metaVar = "SubDirect", usage = "Find Subdirectory" )
    private boolean subDirectory;

    @Option(name = "-d", metaVar = "Directory", usage = "Path to the File")
    private String directory;

    @Argument(metaVar = "fileName", usage = "Input file name", required = true)
    private String fileName;

    public static void main(String[] args) throws IOException {
        new Launcher().run(args);
    }

    private void run(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Expected argument: [-r] [-d directory] filename.txt");
            parser.printUsage(System.err);
            return;
        }

        Find file = new Find();
        System.out.println(file.search(new File(directory), fileName, subDirectory));

    }
}
