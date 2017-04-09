package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.imageio.stream.ImageOutputStreamImpl;

import java.io.InputStream;

public class FileAccessHomeWork {
	int h;
	int result = 0;
	int[] array;

	public static void main(String[] args) throws IOException {
		FileAccessHomeWork fn = new FileAccessHomeWork();
		fn.readFile("temp1.txt");
	}

	/*
	 * When we read file in code. We treat ourself as code and file is outside
	 * So data is coming from file to the code So we use all classes related to
	 * "Input"
	 * 
	 * For file read or write, following things are common 1) You need to create
	 * a reference of the file (also known as abstract path or handle of file in
	 * code) 2) You need to create a pipe between your code and file In case of
	 * read file it is InputStream and in case of write file it is OutStream
	 * (These are actually abstract classes)
	 * 
	 * [code] (Buffer)(Reader)==========Stream=============== [File]
	 * 
	 * 
	 * 
	 * 
	 * Writing into file [code] ==========Stream=============== [File]
	 */
	public void readFile(String fileName) throws IOException {

		File fileRefrance = new File(fileName);
		if (fileRefrance.exists()) {
			System.out.println("File Present");
		} else {
			System.out.println("File not Present");
		}

		InputStream in = new FileInputStream(fileName);

		InputStreamReader isr = new InputStreamReader(in);

		BufferedReader bfr = new BufferedReader(isr);
		
		int counter =0;
		while (counter <1000) {
			counter ++;
			String data = bfr.readLine();
			if (data == null) {
			break;	
			}
			// String number = "10";
			// for (h = 0; h < 10; h++) {
			result = (Integer.parseInt(data));
			//			
			System.out.println(result);
			// System.out.println("File Data: " + data);

			// String data1=bfr.readLine();
			// System.out.println("File Data: "+data1);
			// bfr.close();
			// }
		}
		bfr.close();
	}

	
	
}
