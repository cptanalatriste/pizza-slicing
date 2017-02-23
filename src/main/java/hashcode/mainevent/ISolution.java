package hashcode.mainevent;

import java.io.File;
import java.io.FileNotFoundException;

public interface ISolution {
	public void toFile(File toWrite) throws FileNotFoundException;
}
