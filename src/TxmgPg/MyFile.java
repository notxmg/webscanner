package TxmgPg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFile {
	public  boolean createFile(String filePath){
		boolean result = false;
		File file = new File(filePath);
		if(!file.exists()){
			try {
				result = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public static void writeFileByFileOutputStream(String filePath, String content) throws IOException{
		File file = new File(filePath);
		synchronized (file) {
			FileOutputStream fos = new FileOutputStream(filePath,true);
			fos.write(content.getBytes("GBK"));
			fos.close();
		}
	}


}
