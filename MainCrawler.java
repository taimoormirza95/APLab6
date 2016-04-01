//help taken from oan hasib

package APLab6;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCrawler {
	
	String root;
	File folder;
	File[] listOfFiles;
	String search;
	
	ArrayList<String> file_content;
	ArrayList<String> file_paths;
	
	public MainCrawler(){
		this.root = "C://Users";
		listOfFiles = folder.listFiles();
		folder = new File(this.root);
		file_paths = new ArrayList<String>();
		
		file_content = new ArrayList<String>();
		
	}
	
	public ArrayList<String> getFile_Path(){
		return this.file_paths;
	}
	
	
	public ArrayList<String> getFile_Content(){
		return this.file_content;
	}
	
	
	public String getroot(){
		return this.root;
	}
	
	public static void main(String[] args) {
		
		MainCrawler cm = new MainCrawler();
		CrawlerClass cc = new CrawlerClass(cm.root, cm.getFile_Content(), cm.getFile_Path());
		
		Thread CrawlerThread = new Thread(cc);
		CrawlerThread.start();
		cc.walk(cm.root);
		
		System.out.println("Enter string for searching:");
		Scanner s = new Scanner(System.in);
		String search = s.next();
		
		Searching se = new Searching( search, cm.getFile_Content(), cm.getFile_Path(), CrawlerThread);
		Thread SearchThread = new Thread(se);
		SearchThread.start();
		
		
		
	}

}
