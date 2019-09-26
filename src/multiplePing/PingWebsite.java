package multiplePing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 
  
public class PingWebsite 
{  
	static ArrayList<Process> processes=new ArrayList<Process>();
    // method for finding the ping statics of website 
    
	static ArrayList<ProcessBuilder> processarray=new ArrayList<ProcessBuilder>();
    
	static void commands(ArrayList<String> commandList)  
                                           throws Exception 
    {  
        // creating the sub process, execute system command 
    	
    		
    	
		int prosize=0;
    	for(int i=0;i<=19;i+=2) {
    	
    	
    	
    	processarray.add(new ProcessBuilder(commandList.get(i),commandList.get(i+1)));
    	
    	

    		
    	
    	
    	
       processes.add(processarray.get(prosize).start() ) ;
       DosyayaEkle(commandList.get(i+1));
       DosyayaEkle("\n");
   		prosize++;
   		
    	}
    	
    	
    	
	
		for(int y=0;y<processes.size();y++) {
			
		
        // to read the output 
        BufferedReader input = new BufferedReader(new InputStreamReader 
                                   (processes.get(y).getInputStream())); 
        BufferedReader Error = new BufferedReader(new InputStreamReader 
                                   (processes.get(y).getErrorStream())); 
        
        String s = null; 
        String yeni = null; 
        int kcni=0;
        int msi=0;
        System.out.println("Standard output: "); 
        while((s = input.readLine()) != null) 
        { 
            System.out.println(s); 
         if(s.contains("Average")) {
        	 
       
        	 
        	 kcni =s.indexOf("Average")+10;
        msi= s.lastIndexOf("ms");
        yeni=s.substring(kcni, msi);
        System.out.println("Baslangýc"+kcni+"  "+"Bitiþ"+msi );
        System.out.println("Avaragesdasad"+"  "+yeni );
        DosyayaEkle(yeni);
        DosyayaEkle("\n");
         }
      
        	
        } 
       
      
        System.out.println("error (if any): "); 
        while((s = Error.readLine()) != null) 
        { 
            System.out.println(s); 
        } 
		}
    } 
	private static String Zaman() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		return   dtf.format(now);  
	}
	
	  private static void DosyayaEkle(String metin){
          try{
                File dosya = new File("D:\\NY-Files\\Desktop\\AynýGünAynýSaat.txt");
                FileWriter yazici = new FileWriter(dosya,true);
                BufferedWriter yaz = new BufferedWriter(yazici);
                yaz.write(metin);
                yaz.close();
                System.out.println("Ekleme Ýþlemi Baþarýlý");
          }
          catch (Exception hata){
                hata.printStackTrace();
          }
    }
    // Driver method 
    public static void main(String args[]) throws Exception 
    {  
        // creating list for commands 
        ArrayList<String> commandList = new ArrayList<String>(); 
          
        commandList.add("ping"); 
        // can be replaced by IP 
        commandList.add("216.58.206.164"); 
        commandList.add("ping"); 
        // can be replaced by IP 
        commandList.add("31.13.64.35"); 
        commandList.add("ping"); 
        commandList.add("5.77.50.88");
        commandList.add("ping"); 
        commandList.add("185.117.118.126");
        commandList.add("ping"); 
        commandList.add("149.154.152.93");
  
        commandList.add("ping"); 
        commandList.add("77.81.104.105");
        commandList.add("ping"); 
        commandList.add("167.86.78.20");
        commandList.add("ping"); 
        commandList.add("154.66.197.14");
        commandList.add("ping"); 
        commandList.add("91.219.236.236");
        commandList.add("ping"); 
        commandList.add("80.87.196.114");
        PingWebsite.commands(commandList); 
        DosyayaEkle(Zaman());
        DosyayaEkle("\n");
        DosyayaEkle("\n");
        DosyayaEkle("\n");
        DosyayaEkle("\n");
        DosyayaEkle("\n");
      
    } 
} 
