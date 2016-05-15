import java.io.File;

public class DeleteFolder {
	public static boolean deleteFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			return file.delete();
		}
		return false;
	}
	public boolean deleteFolder(String path){
		File file = new File(path);
		if(file.exists()){
			if(file.isFile()){
				return deleteFile(file.getAbsolutePath());
			}
			else {
				if(file.isDirectory()){
					File[] f = file.listFiles();
				}
			}
		}
		return false;
	}

}
