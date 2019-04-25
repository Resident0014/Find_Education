import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Test_for_Find {

    @Test
    void test() {
        Find file = new Find();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("test/test.txt"));
        assertEquals(files,
                file.search(new File("test"), "test.txt", false));
    }

    @Test
    void test2() {
        Find file = new Find();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("test/dir/test2.txt"));
        files.add(new File("test/dir/dir2/test2.txt"));
        assertEquals(files,
                file.search(new File("test"), "test2.txt", true));
    }

    @Test
    void test3() {
        Find file = new Find();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("test/dir/dir2/test3.txt"));
        assertEquals(files,
                file.search(new File("test"), "test3.txt", true));
    }
}
