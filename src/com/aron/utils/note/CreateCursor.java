package com.aron.utils.note;


public class CreateCursor {

	
	
	int [][] cursor;
	public CreateCursor() {
		// TODO Auto-generated constructor stub
		cursor = new int[32][32];
		for(int i=0;i<32;i++)
			for(int j=0; j<32;j++)
				cursor[i][j] = 1;
		for(int i=6; i < 26; i++)
			cursor[16][i] = 0;
		for(int i=0; i < 3 ; i++)
		{
			cursor[13 + i][5] = 0;
			cursor[17 + i][5] = 0;
			cursor[13 + i][26] = 0;
			cursor[17 + i][26] = 0;
		}
	}
	public void toHex()
	{
		System.out.println();
		for(int i=0;i<32;i++)
		{
			for(int j=0; j<32;j+=8)
			{
				String strHex = String.format("%d%d%d%d%d%d%d%d", cursor[i][j],cursor[i][j+1],cursor[i][j+2],cursor[i][j+3],cursor[i][j+4],cursor[i][j+5],cursor[i][j+6],cursor[i][j+7]);
				int hex = Integer.parseInt(strHex, 2);
				System.out.printf("0x%02X, " ,hex);
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<32;i++)
		{
			for(int j=0; j<32;j+=8)
			{
				String strHex = String.format("%d%d%d%d%d%d%d%d", cursor[i][j],cursor[i][j+1],cursor[i][j+2],cursor[i][j+3],cursor[i][j+4],cursor[i][j+5],cursor[i][j+6],cursor[i][j+7]);
				int hex = Integer.parseInt(strHex, 2);
				System.out.printf("0x%02X, " ,0xFF & ~hex);
			}
			System.out.println();
		}
	}
	public void out()
	{
		for(int i=0;i<32;i++)
		{
			for(int j=0; j<32;j++)
				System.out.printf("%d ", cursor[i][j]);
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateCursor me = new CreateCursor();
		me.out();
		me.toHex();
	}

}
