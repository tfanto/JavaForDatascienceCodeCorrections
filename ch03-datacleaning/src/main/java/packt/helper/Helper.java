package packt.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Helper {

	public static String getFromClassPath(String filename) throws IOException {

		InputStream inputStream = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			inputStream = loader.getResourceAsStream(filename);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			return baos.toString("UTF-8");
		} catch (IOException e) {
			throw e;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// dont care
				}
			}
		}

	}

	public static String getAbsolutePath(String filename) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(filename);
		return url.getPath();
	}

}
