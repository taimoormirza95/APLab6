////help taken and discussed with oan hasib


package APLab6;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CrawlerClass implements Runnable {
	
	public String root;
	ArrayList<String> file_content;
	ArrayList<String> file_paths;
	
	public CrawlerClass(String r, ArrayList<String> fc, ArrayList<String> fp){
		root = r;
		file_content = fc;
		file_paths = fp;
	}
	
	
	public String parser(File f){
		List<String> lines = null;
		String con = "";
		try {
			lines = Files.readAllLines(Paths.get(f.getAbsolutePath()),StandardCharsets.UTF_8);
		} catch (IOException e) {}
		
		for(int i=0 ; i<lines.size(); i++ ){
			con += (String) lines.get(i);
		}
		return con;
	}	
	

	public void walk( String path ) {

		File root = new File( path );
		File[] list = root.listFiles();

		if (list == null) return;

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				walk( f.getAbsolutePath() );
			}
			else {
				if(f.getName().contains(".txt")){
					file_content.add(parser(f));
					file_paths.add(f.getAbsolutePath());
				}
			}
		}
	}
	


	public void run() {
		walk(this.root);
		
	}	
	
}
