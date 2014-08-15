package processbuilder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


/**
 * This class is used to create operating system processes.
 * 
 * Each ProcessBuilder instance manages a collection of process attributes. The
 * start() method creates a new Process instance with those attributes. The
 * start() method can be invoked repeatedly from the same instance to create new
 * subprocesses with identical or related attributes.
 * 
 * 
 * @author crimsonfantasy
 * 
 */
public class ProcessBuilderTest {

	public static void main(String arg[]) throws IOException {

		ProcessBuilder pb = new ProcessBuilder(
				"curl",
				"-s",
				"http://static.tumblr.com/cszmzik/RUTlyrplz/the-simpsons-season-22-episode-13-the-blue-and-the-gray.jpg ");

		pb.directory(new File("/home/crimsonfantasy/Pictures"));
		pb.redirectErrorStream(true);
		Process p = pb.start();
		InputStream is = p.getInputStream();

		FileOutputStream outputStream = new FileOutputStream(
				"/home/crimsonfantasy/Pictures/simpson_download.jpg");

		String line;
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] bytes = new byte[100];
		int numberByteReaded;
		while ((numberByteReaded = bis.read(bytes, 0, 100)) != -1) {

			outputStream.write(bytes, 0, numberByteReaded);
			Arrays.fill(bytes, (byte) 0);

		}

		outputStream.flush();
		outputStream.close();

	}

}
