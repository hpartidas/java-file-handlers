/**
 * FileReader
 * 
 * @author Hector Partidas <hpartidas@deuz.net>
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {
	public boolean success = false;
	public String content = null;
	public String file = null;
	public FileReader read() {
		try {
			if (!this.getFile().equalsIgnoreCase(null)) {
				File f = new File(this.getFile());
				
				if (!f.exists() && !f.canRead()) {
					this.success = false;
				} else {
					BufferedReader br  = new BufferedReader(
							 new InputStreamReader(
							 new FileInputStream(f)));
		
					String tmp = null;
					StringBuilder sb = new StringBuilder();
				
					while ((tmp = br.readLine()) != null) {
						sb.append(tmp);
						sb.append(System.getProperty("line.separator"));
					}
					
					br.close();
					this.success = true;
					this.content = sb.toString();
				}
			} else {
				throw new Exception("No file has been specified.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.success = false;
		}
		
		return this;
	}
	
	public void setFile(String file) {
		try {
			this.file = file;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getFile() {
		return this.file;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getContent() {
		return this.content;
	}
}