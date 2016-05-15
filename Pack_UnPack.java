import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pack_UnPack {
	public static void pack(String dir, String des) throws IOException {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(des)));
		File f = new File(des);
		if (f.isDirectory()) {
			File[] list = f.listFiles();
			BufferedInputStream bis;
			for (File f1 : list) {
				bis = new BufferedInputStream(new FileInputStream(f1));
				dos.writeUTF(f1.getName());
				dos.writeLong(f1.length());
				byte[] data = new byte[1024];
				int i;
				while ((i = bis.read(data)) != -1) {
					dos.write(data, 0, i);
				}
				bis.close();
				dos.close();

			}

		}
	}

	public static void unpack(String source, String des) throws IOException {
		File f = new File(source);
		int count = 1;
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
		long readed = 0;
		int byteMustRead;
		String name;
		long size;
		try {
			int j = 0;
			while (true) {
				System.out.println(j++);
				name = dis.readUTF();
				System.out.println(name);
				size = dis.readLong();
				System.out.println(size);
				byteMustRead = size - readed > 1024 ? 1024 : (int) (size - readed);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des + "\\" + name));
				byte[] data = new byte[byteMustRead];
				int i;
				while (byteMustRead != 0) {
					i = dis.read(data);
					bos.write(data, 0, i);
					readed += i;
					byteMustRead = size - readed > 1024 ? 1024 : (int) (size - readed);
					data = new byte[byteMustRead];

				}
				readed = 0;
				bos.flush();
				bos.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			dis.close();
		}

	}

}
