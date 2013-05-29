package treecalc.vm.asm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import treecalc.vm.asm.TciAssembler.Asm;

public class TciAsmReaderWriter {
	public static void write(Asm asm, String filename) throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(asm);
		} finally {
			if(out!=null) {
				out.close();
			} else if(fos!=null) {
				fos.close();
			}
		}
	}
	public static Asm read(String filename) throws IOException {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			Asm asm = null;
			try {
				asm = (Asm) in.readObject();
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			in.close();	
			return asm;
		} finally {
			if (in!=null) {
				in.close();
			} else if (fis!=null) {
				fis.close();
			}
		}
	}
	public static Asm readFromJar(String filename) throws IOException {
		InputStream fis = TciAsmReaderWriter.class.getClassLoader().getResourceAsStream(filename);
		if (fis==null) {
			return read(filename);
		}
		ObjectInputStream in = new ObjectInputStream(fis);
		Asm asm = null;
		try {
			try {
				asm = (Asm) in.readObject();
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			in.close();
			return asm;
		} finally {
			if (in!=null) {
				in.close();
			} else if (fis!=null) {
				fis.close();
			}
		}
	}
}
