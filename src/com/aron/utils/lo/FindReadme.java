package com.aron.utils.lo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FindReadme {

	//こんにちは
	private File outFile = null;
	private BufferedOutputStream  bos = null;
	private int fileCount = 0;
	private String clsContent="Content" ;
	private String clsTitle="title";
	private String idContent="Content" ;
	private String idTitle="title";
	
	String divTitle= "<div class = '" + clsTitle + "', id='" + idTitle + "'>";
	String divContent= "<div class = '" + clsContent + "', id='" + idContent + "'><pre>";
	String divContentEnd = "</div></pre>\n";
	String divEnd = "</div>\n";
	public FindReadme() {
		// TODO Auto-generated constructor stub
		outFile = new File("d:\\readme_all_java.txt");
		try {
			bos = new BufferedOutputStream(new FileOutputStream (outFile)) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(File dir) throws IOException
	{
		
		File[] fs = dir.listFiles();
		
//		FileWriter writer = new FileWriter(outFile); 
//		OutputStream os = new BufferedOutputStream() 
		
		for(int i=0; i<fs.length; i++)
		{
			if(fs[i].isDirectory())
			{
				if(fs[i].getAbsolutePath().contains(".git"))
					continue;
				File readmeFile = new File(fs[i].getAbsolutePath() + "\\README");
				if(readmeFile.exists() && readmeFile.isFile())
				{
					String fileName = String.format("%03d", fileCount++) + ". " + fs[i].getAbsolutePath() + "\\README";
					String text = repeat("*",fileName.length() + 6 ) + "\n";
					text += "** " + fileName + " **\n";
					text += repeat("*",fileName.length() + 6 ) + "\n";
					System.out.print(text );

					
//					InputStreamReader isr = new InputStreamReader(new FileInputStream (readmeFile));
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readmeFile));
//					bos.write(fileCount++ + fs[i].getAbsolutePath() + "\\README\n");
					bos.write("<li>".getBytes());
					bos.write(divTitle.getBytes());
					bos.write(fs[i].getAbsolutePath().getBytes());
					bos.write(divEnd.getBytes());
					//					new inputstream
//					new InputStrea)
					bos.write(divContent.getBytes());
					copy((InputStream)bis, (OutputStream)bos);
					bos.write(divContentEnd.getBytes());
					bos.write("</li>".getBytes());
				}
				run(fs[i]);
			}
		}
		
	}
	private String repeat(String text,int times)
	{
		String text1 = "";
		for(int i = 0; i < times ;i++)
		{
			text1 += text;
//			System.out.print(text);
		}
		return text1;
	}
	public void close() throws IOException
	{
		bos.close();
	
	}
	private static final int EOF = -1;

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	public static int copy(InputStream input, OutputStream output) throws IOException {
	    long count = copyLarge(input, output);
	    if (count > Integer.MAX_VALUE) {
	        return -1;
	    }
	    return (int) count;
	}

	private String addDiv(String content, String clas , String id)
	{
		String text = "<div class = '" + clas + "', id='" + id + "'>" + content +"</div>";
		return text;
	}
	public static long copyLarge(InputStream input, OutputStream output)
	        throws IOException {
	    return copyLarge(input, output, new byte[DEFAULT_BUFFER_SIZE]);
	}

	public static long copyLarge(InputStream input, OutputStream output, byte[] buffer)
	        throws IOException {
	    long count = 0;
	    int n = 0;
	    while (EOF != (n = input.read(buffer))) {
	        output.write(buffer, 0, n);
	        count += n;
	    }
	    return count;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			FindReadme findReadme = new FindReadme();
			findReadme.run(new File("D:\\lo\\core"));
			findReadme.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Finished..");
	}

}
