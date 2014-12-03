package com.aron.utils.note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHexGen {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String filePath="";
        //fonts/aat/almas/mongolianwhite.ttf
        //genarateFont.ttf
        //haha
        if (args.length == 0)
        {
            System.out.println("please input ttf file name");
            InputStreamReader	isr	= new InputStreamReader(System.in);
            BufferedReader 		br	= new BufferedReader(isr);
            filePath 	= br.readLine();
        }
        else
            filePath = args[0];
        byte[] filedata = GetBin(new File(filePath));
        
        File outFile = new File("d:\\MNWHITE.txt");
        FileWriter filewriter = new FileWriter(outFile);
        for(int i= 0; i < filedata.length; i++ )
        {
        	if(i % 16 == 0 )
        	{
        		System.out.println();
        		filewriter.write("\r\n\t");
        	}
        	String str = String.format("0x%02X, ", filedata[i]);
        	System.out.print(str);
        	filewriter.write(str);
        }
        
        filewriter.write("\r\nEOF");
        filewriter.close();
        System.out.print("gen to file \""+ outFile.getAbsolutePath()+ "\"");
	}
	public static byte[] GetBin(File file) throws IOException
	{
		byte[] fileData = new byte[(int) file.length()];
		FileInputStream in = new FileInputStream(file);
		in.read(fileData);
		in.close();
		return fileData;
	}
}
