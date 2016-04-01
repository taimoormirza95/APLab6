////help taken from oan hasib


package APLab6;

import java.util.ArrayList;

public class Searching implements Runnable {
	
	public Thread prevThread;
	public ArrayList<String> file_paths;
	public String search;
	public ArrayList<String> file_content;
	
	
	
	
	public Searching(String s, ArrayList<String> fc,ArrayList<String> fp, Thread t){
		this.file_content = fc;
		this.search = s;
		this.file_paths = fp;
		this.prevThread = t;
	}

	
	
	public void search(String s){
		for (int i=0 ; i<file_paths.size() ; i++){
			if(file_paths.get(i).contains(s) || file_content.get(i).contains(s))
				System.out.println("Found. Location : "+file_paths.get(i));
		}
	}
	
	
	

	
	public void run() {
		while(true){
			if(this.file_content.size()>0 && this.file_paths.size()>0){
				search(this.search);
				break;
			}
		}
	}	
}
