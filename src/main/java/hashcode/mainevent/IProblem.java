package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IProblem {
	public void readFile(File f) throws FileNotFoundException, IOException;
}
