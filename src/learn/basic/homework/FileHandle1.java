package learn.basic.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileHandle1 {

	public static void main(String[] args) throws IOException {

		FileHandle1 fh = new FileHandle1();

		String filename = "temp.txt";
		fh.read(filename);
		fh.writeFile("temp1.txt", "this is new data in file");
	}

	public void read(String filename) throws IOException {
		File fileref = new File(filename);
		if (fileref.exists()) {
			System.out.println("File Is Present");
		} else {
			System.out.println("File not present New One Created");
		}

		InputStream in = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader bfr = new BufferedReader(isr);
		String data = bfr.readLine();

		System.out.println("Data in file:" + data);
		bfr.close();
	}

	public void writeFile(String filename, String content) throws IOException {
		File fileref = new File(filename);
		if (fileref.exists()) {
			System.out.println("File Is Present");
		} else {
			System.out.println("File not present New One Created");
		}

		OutputStream os = new FileOutputStream(filename);
		byte[] data = content.getBytes();
		os.write(data);
		System.out.println("Data is Written:" + content);
		os.close();

	}

}
