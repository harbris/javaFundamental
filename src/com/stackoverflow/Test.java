package com.stackoverflow;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Test {

	public static void main(String[] args) throws IOException {
		    File workingDir = new File(args[0]);
		    File source = new File(workingDir, "in.zip");
		    File target = new File(workingDir, "out.zip");
		    Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);

		    try (FileSystem zipfs = FileSystems.newFileSystem(target.toPath(), null)) {
		        Path pathInZipfile = zipfs.getPath("test.xml");
		        System.out.println("zipfile writable: " + target.canWrite());
		        System.out.println("zipFS writable: " + !zipfs.isReadOnly());
		        Files.delete(pathInZipfile);
		        System.out.println("File successfully deleted");   
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}

}
