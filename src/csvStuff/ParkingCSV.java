package csvStuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ParkingCSV {
	public static Scanner x;

	public ParkingCSV() {
		// TODO Auto-generated constructor stub
	}

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ParkingCSV m = new ParkingCSV();
		
		//m.getBookings("t1@yorku.ca").toString();
		//m.bookingRemover("3");
	//System.out.println(m.payOff("t1@yorku.ca"));
	System.out.println(m.ruleOfThree("t1@yorku.ca"));
	
	}*/
	
	public boolean changeStatus(String email, String space) {
		
		String line;
		int lastId =0;
		boolean wasthere=false;
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				if ((email.equals(v[6]) &&v[7].equals("paid")&&space.equals(v[4])&&v[8].equals("unconfirmed")) == false   ) {
					// System.out.println("yess");
					ArrayList<String> x1 = new ArrayList<String> ();  
					for(String l : v) {
						x1.add(l);
					}
					x.add(x1);
					
				}else {
					//System.out.println(line);
					ArrayList<String> x1 = new ArrayList<String> ();  
					for(String l : v) {
						//x1.add(v[0]+","+v[1]+","+v[2]+","+v[3]+","+
						//v[4]+","+v[5]+","+v[6]+","+"paid"+","+v[8]);
						
						for (int i = 0; i < v.length; i++) {
							String string1 = v[i];
							if(i!=8) {
								x1.add(string1);
							}else {
								x1.add("confirmed");
							}
						}						
						//System.out.println();
					}
					x.add(x1);	
					wasthere= true;
				}
				//lastID = Integer.parseInt(v[1]);
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
			
			FileWriter fw = new FileWriter("booking.csv", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			for(ArrayList<String> x2: x) {
				pw.println(x2.get(0)+ ","+x2.get(1)+","+x2.get(2)+ ","+x2.get(3)+","+x2.get(4)+","+x2.get(5)+","+x2.get(6)+","+x2.get(7)+","+x2.get(8));	
				
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
	public boolean paystamp(LocalDateTime t, String amount)
	{

		
		try {
			
			FileWriter fw = new FileWriter("payconfirm.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(t.toString() + "," + amount+ "\n");			
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
	
	public boolean payOff(String email) {
		
		String line;
		int lastId =0;
		boolean wasthere=false;
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				if ((email.equals(v[6]) && v[7].equals("unpaid")) == false   ) {
					// System.out.println("yess");
					ArrayList<String> x1 = new ArrayList<String> ();  
					for(String l : v) {
						x1.add(l);
					}
					x.add(x1);
					
				}else {
					//System.out.println(line);
					ArrayList<String> x1 = new ArrayList<String> ();  
					for(String l : v) {
						//x1.add(v[0]+","+v[1]+","+v[2]+","+v[3]+","+
						//v[4]+","+v[5]+","+v[6]+","+"paid"+","+v[8]);
						
						for (int i = 0; i < v.length; i++) {
							String string1 = v[i];
							if(i!=7) {
								x1.add(string1);
							}else {
								x1.add("paid");
							}
						}						
						System.out.println();
					}
					x.add(x1);		
					wasthere = true;
				}
				//lastID = Integer.parseInt(v[1]);
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
			
			FileWriter fw = new FileWriter("booking.csv", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			for(ArrayList<String> x2: x) {
				pw.println(x2.get(0)+ ","+x2.get(1)+","+x2.get(2)+ ","+x2.get(3)+","+x2.get(4)+","+x2.get(5)+","+x2.get(6)+","+x2.get(7)+","+x2.get(8));	
				
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
	
	
	
	public String price(String email) {
		int lastID =0;
		String line;
		double hours=0,mins=0;
		
		
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				if (email.equals(v[6])&&v[7].equals("unpaid")) {
					// System.out.println("yess");
					hours = hours + Integer.parseInt(v[1]);
					mins = mins+ Integer.parseInt(v[2]);
				}
				//lastID = Integer.parseInt(v[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 DecimalFormat df2 = new DecimalFormat("#.##");

		//System.out.println("hours: "+hours+"  mins: "+mins);
		
		double total = hours*10 + mins/60 *10; 
		
		//df2.format(total);
		
		  
		return df2.format(total);
	}
	
	
	
	public boolean bookingRemover(String bookingid, String email) {
		
		String line;
		int lastId =0;
		boolean wasthere=false;
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				
				int hours1 = Integer.parseInt(v[1]);
				int minutes1 = Integer.parseInt(v[2]);
				LocalDateTime date23 = LocalDateTime.parse(v[0]);
				LocalDateTime now = LocalDateTime.now();
				//LocalDateTime date24 = date23.plusHours(hours1).plusMinutes(minutes1);
				
				
				
				if (!(bookingid.equals(v[3])&&email.equals(v[6])&&now.isBefore(date23))) {
					// System.out.println("yess");
					ArrayList<String> x1 = new ArrayList<String> ();  
					for(String l : v) {
						x1.add(l);
					}
					x.add(x1);
					
				}else {
					wasthere =true;
				}
				//lastID = Integer.parseInt(v[1]);
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
			
			FileWriter fw = new FileWriter("booking.csv", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			for(ArrayList<String> x2: x) {
				pw.println(x2.get(0)+ ","+x2.get(1)+","+x2.get(2)+ ","+x2.get(3)+","+x2.get(4)+","+x2.get(5)+","+x2.get(6)+","+x2.get(7)+","+x2.get(8));	
				
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
	public boolean isConflict(LocalDateTime t, int hours, int minutes, String space) {
		// TODO Auto-generated method stub
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				String space1=v[4];
				int hours1 = Integer.parseInt(v[1]);
				int minutes1 = Integer.parseInt(v[2]);
				LocalDateTime date23 = LocalDateTime.parse(v[0]);

				
				
				
				if(t.equals(date23)) {
					return true;
				}		
				else {
				
				if (
					((t.isAfter(date23) && t.isBefore(date23.plusHours(hours1).plusMinutes(minutes1)))
					|| ((t.plusHours(hours).plusMinutes(minutes).isAfter(date23) && t.plusHours(hours)
					.plusMinutes(minutes).isBefore(date23.plusHours(hours1).plusMinutes(minutes1)))))
					&&space.equals(space1)
						) {
					// System.out.println("yess");
					return true;
				}
				if (
					((date23.isAfter(t) && date23.isBefore(t.plusHours(hours).plusMinutes(minutes)))
					|| ((date23.plusHours(hours1).plusMinutes(minutes1).isAfter(t) && date23.plusHours(hours1)
					.plusMinutes(minutes1).isBefore(t.plusHours(hours).plusMinutes(minutes)))))
					&&space.equals(space1)
						) {
					// System.out.println("yess");
					return true;
				}
				
				}
				
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
	public ArrayList<String>  getBookings(String email) {
		
		String line;
		int lastId =0;
		ArrayList<String> x = new ArrayList<String>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				
				
				if (email.equals(v[6])) {
					x.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  x;
	}
	
	
	
	public boolean  ruleOfThree(String email) {
		int count=0;
		String line;
		int lastId =0;
		ArrayList<String> x = new ArrayList<String>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				int hours1 = Integer.parseInt(v[1]);
				int minutes1 = Integer.parseInt(v[2]);
				LocalDateTime date23 = LocalDateTime.parse(v[0]);
				LocalDateTime now = LocalDateTime.now();
				LocalDateTime date24 = date23.plusHours(hours1).plusMinutes(minutes1);
				if (email.equals(v[6])&&now.isBefore(date24)) {
					count++;
					
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
		
		return  count<3;
	}
	
	public boolean booker(LocalDateTime t, int hours, int minutes, String spacenum, String licenseplate, String email)
	{
		int lastID = 0;
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("booking.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
//				if (email.equals(v[2])) {
//					// System.out.println("yess");
//					return false;
//				}
				lastID = Integer.parseInt(v[3]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			FileWriter fw = new FileWriter("booking.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(t.toString() + "," + hours + "," + minutes + "," + (lastID + 1) + "," + spacenum + ","
					+ licenseplate + "," + email + "," + "unpaid" + "," + "unconfirmed" + "\n");
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
	
}
