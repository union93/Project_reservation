package main_pkg;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main_pkg.textDB;

public class File_IO {
	
	// ���� ��¥�κ��� n�� ���� ��¥�� ���ϴ� �޼ҵ�
	private String get_date(int n) {
		SimpleDateFormat new_format = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date today = new Date(System.currentTimeMillis());
		cal.setTime(today);
		cal.add(Calendar.DATE, n);
		String date = new_format.format(cal.getTime());
		return date;
	}

    private void read_file(String directory,String name) {

    }
    private void write_file(String directory, String name,String line) {

    }
    
    private void create_file(){ // �ʿ��� ������ ���� ��, ������ �����ϴ� �޼ҵ�
    	String user_name = "Administrator";	// ����� �̸�
    	String directory =  "C:\\Users\\"; 
    	String home_directory =  directory + user_name ; // {HOME}���
    	String data_directory =  home_directory + "\\data" ; // data���
    		
    	String days[] = new String[3]; // ���� ��¥�κ��� 3�ϱ����� �����Ͽ� stringŸ������ �����մϴ�. ex) 20201023 
		days[0] = get_date(0);
		days[1] = get_date(1);
		days[2] = get_date(2);
		
		for(int k = 0; k<3; k++) { // ����, ����, �� �� 3�ϰ��� ������������ Ȯ���Ͽ� ���� �� �������ݴϴ�. 
			String filename = "\\"+days[k]+".txt"; 
			File file = new File(data_directory+filename);
			
			boolean file_is_exist = file.exists(); 
			if(!file_is_exist) { // �ش� ������ �������� �ʴ´ٸ�,
				try {
					System.out.println("������ ��ο� �ʿ��� <���� ���� ���� : "+days[k]+".txt>�� �������� �ʽ��ϴ�. �ʿ��� ������ ������ �����մϴ�.");
					file.createNewFile(); // �ش� ������ �����մϴ�. 
					FileWriter fw = new FileWriter(file, false); // ������ ���Ͽ� �⺻ ������ �Է��մϴ�.
					String line = "";
					for(int i = 1; i<=20; i++) {
						for(int j = 10; j<= 20; j++) {
							line += i + " ";
							if(1<=i && i<=6) line += 2 + " ";
							if(7<=i && i<=16) line += 4 + " ";
							if(17<=i && i<=20) line += 6 + " ";
							line += 0 + " " + j + "\n";
						}
						fw.write(line);
						line = "";
					}
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    
    private void delete_file(){ // ������ ������ ������ ������ ��, �����ϴ� �޼ҵ�
    	String user_name = "Administrator"; // ����� �̸�
    	String directory =  "C:\\Users\\";
    	String home_directory =  directory + user_name ;
    	String data_directory =  home_directory + "\\data" ;
    
    	String str_today = get_date(0); // ���� ��¥�� stringŸ������ ����
    	int int_today = Integer.parseInt(str_today); // ������ ��¥�� ���ϱ� ���� ������ ��¥�� int Ÿ������ ����
    	
    	File file = new File(data_directory); // directory�� �����ϴ� ��� ������ �̸��� list�� ����
        String[] files = file.list();
       
        for(int i=0 ; i < files.length ; i++){ // list�� ����� ������ ������ŭ �ݺ�
        	String file_name = files[i];
            file_name = file_name.replace(".txt", ""); // ������ �̸�(��¥)�� ���� ��¥�� ���ϱ� ���� ����ȯ�� ����
            int file_date = Integer.parseInt(file_name);
            
            if(file_date<int_today) { // ���� ������ ������ ������ �����Ѵٸ�,
            	System.out.println("������ ��ο� ������ <���� ���� ���� : "+files[i]+">�� �����մϴ�. �ش� �����͸� �����մϴ�.");
            	File file_ = new File(data_directory+"\\"+files[i]);
            	file_.delete(); // ������ �����Ѵ�. 	
             }
        }


    	
    }

	
}
