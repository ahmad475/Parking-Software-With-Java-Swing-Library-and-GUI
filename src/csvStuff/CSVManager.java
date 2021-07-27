package csvStuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CSVManager {
	public static Scanner x; 

	public CSVManager() {
		// TODO Auto-generated constructor stub
	}

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email="yak@yok";
		
		CSVManager m = new CSVManager() ;
		
	//boolean b = m.Registrar(fname, lname, email, password);
		//System.out.println(m.isOfficerEmail(email));
	//if(m.isOfficerEmail(email))
	//{
			m.officerRemover(email);
	//}
	//	
		//System.out.println(m.isOfficerEmail(email));
		
		System.out.println(m.officerRegistrar("tik", "100", "email", "password"));
		
		
		
		
		
	}
	*/
	
	
	
	
	public boolean officerRemover(String email) {
		
		String line;
		int lastId =0;
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				if (!email.equals(v[2])) {
					// System.out.println("yess");
					ArrayList<String> x1 = new ArrayList<String> ();  
					for(String l : v) {
						x1.add(l);
					}
					x.add(x1);
					
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
			
			FileWriter fw = new FileWriter("user.csv", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			for(ArrayList<String> x2: x) {
				pw.println(x2.get(0)+ ","+x2.get(1)+","+x2.get(2)+ ","+x2.get(3)+","+x2.get(4));	
				
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	
	
	public boolean isCustomer(String email, String password) {
		// TODO Auto-generated method stub
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));
			
			while((line = csvline.readLine()) !=null) {
				
				String[] v = line.split(",") ;
				if(email.equals(v[2])&&password.equals(v[3])&&v[4].equals("user")) {
					//System.out.println("yess");
					return true;
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
	
	public boolean isOfficer(String email, String password) {
		// TODO Auto-generated method stub
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));
			
			while((line = csvline.readLine()) !=null) {
				
				String[] v = line.split(",") ;
				if(email.equals(v[2])&&password.equals(v[3])&&v[4].equals("officer")) {
					//System.out.println("yess");
					return true;
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
	
	public boolean isAdmin(String email, String password) {
		// TODO Auto-generated method stub
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));
			
			while((line = csvline.readLine()) !=null) {
				
				String[] v = line.split(",") ;
				if(email.equals(v[2])&&password.equals(v[3])&&v[4].equals("admin")) {
					//System.out.println("yess");
					return true;
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
	
	
	
	
	
	
	
	
	
	
	
	public boolean customerRegistrar(String fname, String lname, String email, String password) {
		int lastID =0;
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				if (email.equals(v[2])) {
					// System.out.println("yess");
					return false;
				}
				lastID = Integer.parseInt(v[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		
			FileWriter fw = new FileWriter("user.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			pw.print(fname + " " + lname + ","+(lastID+1) +","+email + ","+password+","+"user"+"\n");
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
	
	

	public boolean officerRegistrar(String fname, String lname, String email, String password) {
		int lastID =0;
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));

			while ((line = csvline.readLine()) != null) {

				String[] v = line.split(",");
				if (email.equals(v[2])) {
					// System.out.println("yess");
					return false;
				}
				lastID = Integer.parseInt(v[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		
			FileWriter fw = new FileWriter("user.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			pw.print(fname + " " + lname + ","+(lastID+1) +","+email + ","+password+","+"officer"+"\n");
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

	public boolean isOfficerEmail(String email) {
		// TODO Auto-generated method stub
		String line;
		try {
			BufferedReader csvline = new BufferedReader(new FileReader("user.csv"));
			
			while((line = csvline.readLine()) !=null) {
				
				String[] v = line.split(",") ;
				if(email.equals(v[2])&&v[4].equals("officer")) {
					//System.out.println("yess");
					return true;
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
	
	
}
