package csvStuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Spaces {

	public Spaces() {
		// TODO Auto-generated constructor stub
	}

	
	

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Spaces m = new Spaces();
		
	//m.getBookings("t1@yorku.ca").toString();
	//m.bookingRemover("3");
	//System.out.println(m.payOff("t1@yorku.ca"));
	//System.out.println(m.changeStatus("t1@yorku.ca"));
	//m.generate7500();
	//System.out.println(m.addSpace("50000"));
	System.out.println(m.removespace("10"));
	}*/
	
	
	
	
	
//	public void generate7500() {
//		try {
//			FileWriter fw = new FileWriter("spaces.csv", false);
//			BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter pw = new PrintWriter(bw);
//
//			for(int i=0; i<7501;i++) {
//				pw.println(i);
//			}
//			pw.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
	
	
	public boolean addSpace(String space)
	{
		int lastID = 0;
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("spaces.csv"));

			while ((line = csvline.readLine()) != null) {

				//String[] v = line.split(",");
				if (space.equals(line)) {
					// System.out.println("yess");
					return false;
				}
				//lastID = Integer.parseInt(v[3]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			FileWriter fw = new FileWriter("spaces.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(space+"\n");
			// pw.print(fname + " " + lname + ","+(lastID+1) +","+email +
			// ","+password+","+"user"+"\n");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	public boolean isSpace(String space)
	{
		int lastID = 0;
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("spaces.csv"));

			while ((line = csvline.readLine()) != null) {

				//String[] v = line.split(",");
				if (space.equals(line)) {
					// System.out.println("yess");
					return true;
				}
				//lastID = Integer.parseInt(v[3]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
	
	public boolean isOccupied(String space) {
		
		String line;
		int lastId =0;
		boolean wasthere=false;
		
		//ArrayList<String> x = new ArrayList<String>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {
				String[] v = line.split(",");
				LocalDateTime date23 = LocalDateTime.parse(v[0]);
				LocalDateTime da= LocalDateTime.now();
				//String[] v = line.split(",");
				if (da.isBefore(date23)&&space.equals(v[4])) 
				{
					//x.add(line);
					wasthere=true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return wasthere;
	}
	
	
	public boolean removespace(String space) {
		
		String line;
		int lastId =0;
		boolean wasthere=false;
		
		ArrayList<String> x = new ArrayList<String>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("spaces.csv"));

			while ((line = csvline.readLine()) != null) {

				//String[] v = line.split(",");
				if (!line.equals(space)) {
					x.add(line);					
				}else {
					wasthere=true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(x.toString());
		try {
			
			FileWriter fw = new FileWriter("spaces.csv", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			for(String x2: x) {
				pw.println(x2);	
				
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return wasthere;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
