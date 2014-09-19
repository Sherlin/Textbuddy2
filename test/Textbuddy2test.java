
import static org.junit.Assert.*;

import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Textbuddy2test {

	private TextBuddy2 textbuddy;
	private static File textFile1;
	private static File expected;
	@Before
	public void setUp() throws Exception {
		textbuddy = new TextBuddy2();
		System.out.println("before :");
		TextBuddy2.add();
		textFile1 = new File("textfile.txt");
		textFile1.createNewFile();
		expected = new File("expected.txt");
		expected.createNewFile();
		TextBuddy2.displayContent("textfile.txt");
		
	}

/*	@Test
	public void sortContenttest() throws IOException {
		System.out.println("Sorting");
		textbuddy.sortContent(textFile1, "textfile.txt");
		PrintWriter writer = new PrintWriter(expected);
		writer.println("ab");
		writer.println("ac");
		writer.println("b");
		writer.close();
		assertTrue(testIfFilesAreTheSame(textFile1, expected));

	}*/
/*	@Test
	public void clearContentTest() throws IOException {
		System.out.println("Clearing");
		textbuddy.clearContent(textFile1, "textfile.txt");
		assertTrue(textFile1.length() == 0);

	}*/
/*	@Test
	public void deleteContentTest() throws IOException {
		System.out.println("Delete");
		textbuddy.deleteContent(textFile1, "textfile.txt");

	}*/
	/*@Test
	public void addContentTest() throws IOException {
		System.out.println("Add");
		textbuddy.addContent(textFile1, "textfile.txt");

	}*/
/*	@Test
	public void searchContentTest() throws IOException {
		System.out.println("Search");
		textbuddy.searchContent("textfile.txt");

	}*/
	public boolean testIfFilesAreTheSame(File file1, File file2){
		BufferedReader file1Reader =null;
		BufferedReader file2Reader =null;
		boolean equals = true;;
		try{
		file1Reader = new BufferedReader( new FileReader(file1));
		file2Reader = new BufferedReader( new FileReader(file2));
		String linefromfile1;
		String linefromfile2;
		while(((linefromfile1 = file1Reader.readLine())!= null)
				&& ((linefromfile2 = file2Reader.readLine())!=null)){
			if(!linefromfile1.equals(linefromfile2)){
				equals = false;
				break;
			}			
		}
		
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
			 try {
			        file1Reader.close();
			        file2Reader.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		}
		return equals;
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("After :");
		TextBuddy2.displayContent("textfile.txt");
		TextBuddy2.clearContent(expected, "expected.txt");
	}
}
