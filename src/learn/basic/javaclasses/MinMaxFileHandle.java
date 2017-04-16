package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class MinMaxFileHandle {

	int counter = 0;
	int result = 0;
	int[] array;
	static int[] random = new int[10];

	public static void main(String[] args) throws IOException {
		MinMaxFileHandle fn = new MinMaxFileHandle();
		fn.readFile("temp1.txt");
		fn.minMax(random);
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

		int i = 0;
		while (counter < 1000) {

			String data = bfr.readLine();
			if (data == null) {
				break;
			}
			result = (Integer.parseInt(data));

			random[i] = result;
			i++;
			counter++;
		}
		for (int j = 0; j < counter; j++) {
			System.out.println(random[j]);
		}
		bfr.close();
	}

	public void minMax(int[] array) {

		int max = 0;
		int min = 0;
		int temp2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				temp2 = array[i];
			}
		}
		for (int i = 0; i < counter; i++) {
			if (array[i] > max) {
				max = array[i];
			} else {
				if (array[i] < temp2) {
					min = array[i];
					temp2 = array[i];
				}
			}
		}
		if (min == 0) {
			min = array[0];
		}

		System.out.println("Maximum value is :" + max);
		System.out.println("Minimum value is :" + min);
	}

}
