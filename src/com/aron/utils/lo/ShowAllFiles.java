package com.aron.utils.lo;

import java.io.File;

 public class ShowAllFiles {

		public ShowAllFiles() {
			// TODO Auto-generated constructor stub
		}
		public static void main(String[] args) throws Exception {
			//こんにちは
			File root = new File("c:");
			showAllFiles(root);
		}
		final static void showAllFiles(File dir) throws Exception
		{
			File[] fs = dir.listFiles();
			for(int i=0; i<fs.length; i++)
			{
				System.out.println(fs[i].getAbsolutePath());
				if(fs[i].isDirectory()){
			    try{
			    	showAllFiles(fs[i]);
			    }
			    catch(Exception e){}
			   }
			  }
		}
 }