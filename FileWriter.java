/**
 * FileReader
 * 
 * @author Hector Partidas <hpartidas@deuz.net>
 */import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriter {
	public boolean success = false;
	public String content = null;
	public String file = null;
	public FileWriter write() {
		try {
			if (!this.getFile().equalsIgnoreCase(null)) {
				File f = new File(this.getFile());
				
				if (!f.exists()) {
					if (!f.createNewFile()) {
						throw new IOException("Could not create file: `" + file +"`");
					}
				} else if (!f.canWrite()) {
					this.success = false;
				}
				
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(
						new FileOutputStream(f, true)));
	
				bw.append(this.getContent());
	
				bw.close();
				
				this.success = true;
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
	
	public void setContent(String message) {
		try {
			this.content = message;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}