package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.InputStreamReader;

public class FileAccess {

	public static void main(String[] args) throws IOException {
		// In order to access files, Java has provided some inbuilt classes and
		// methods
		// What things do we need to access file?
		// 1. We need File name (String format)
		// 2. We need File path/file location (String format)

		// How to use those things to access file?
		// 1. Using file path+ file name, check if the file exists or not
		// 2. Establish the reference to the file based on the file path
		// 3. Read the content of file byte by byte using buffer
		// 4. Print the file contents
		// 5. close the buffers

		// File referenceToTheFile = new File("temp.txt");
		// if (referenceToTheFile.exists()) {
		// System.out.println("File exists");
		// } else {
		// System.out.println("File does not exist");
		// }
		// String myContent = "Content of my new file";
		// byte[] myByteArray = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r',
		// 'l', 'd' };

		// We explored 3 options to see if we can convert String into byte[]
		// 1 option : we looked at all static methods from String class
		// 2 option: we looked at all static methods from Byte class
		// 3 option: we looked at all methods of the String object
		// 4 options: You can use constructor of String or Byte to convert one
		// from another

		// byte[] myContentByteArray = myContent.getBytes();
		//
		// String convertedString = new String(myContentByteArray);
		// System.out.println(convertedString);
		// OutputStream stream = new FileOutputStream(referenceToTheFile);
		// stream.write(myContentByteArray);
		// stream.close();

		FileAccess fl = new FileAccess();
		fl.writeFile("temp2.txt", "data written in file successfully");
		// // First way to read a file
		// File referenceToTheFile = new File("temp.txt");
		// InputStream inputStream = new FileInputStream(referenceToTheFile);
		// InputStreamReader reader = new InputStreamReader(inputStream);
		// BufferedReader bufferedReader = new BufferedReader(reader);
		// String fileContent = bufferedReader.readLine();
		// System.out.println("File contents are: " + fileContent);

		// Second way to read a file.
		FileReader myReader = new FileReader("temp1.txt");
		BufferedReader in = new BufferedReader(myReader);
		String fileContent1 = in.readLine();
		System.out.println("New File content : " + fileContent1);

	}

	public void readFile(String file, String content) throws IOException {
		File referenceToTheFile = new File(file);
		if (referenceToTheFile.exists()) {
			System.out.println("File exists");
		} else {
			System.out.println("File does not exist");
		}

		byte[] myContentByteArray = content.getBytes();

		String convertedString = new String(myContentByteArray);
		System.out.println(convertedString);
		OutputStream stream = new FileOutputStream(referenceToTheFile);
		stream.write(myContentByteArray);
		stream.close();
	}

	public void writeFile(String file, String content) throws IOException {
		File FileRefrance = new File(file);
		if (FileRefrance.exists()) {
			System.out.println("File exists");

		} else {
			System.out.println("File does not exist new one created");
		}
		OutputStream outstream = new FileOutputStream(file);
		byte[] data = content.getBytes();
		outstream.write(data);
		outstream.close();

	}

}
