package main_pkg;

import java.util.Scanner;
import main_pkg.File_IO;

public class Main {
	
    public static void main(String[] args) {
    	
    	/* file_write ��뿹�� */

        File_IO fi = new File_IO();
        
        String date = "20201027";
        fi.read_file(date);
        String[][][] temp = fi.tb.get_day();
        String temp_check ="";

        for (int i =0;i<20 ;i++){
            for (int k= 0; k<11; k++){
                for(int j =0;j<11;j++ ){
                   System.out.println(fi.tb.get_day()[j][k][i]);
                }
            }
        }

        
        Reservation reservation = new Reservation();
        Validate validate = new Validate();
        
       while(true) {
            print_menu();
            
            Scanner input_scan = new Scanner(System.in);
            Scanner pwd_scan = new Scanner(System.in);
            String menu_choice = input_scan.next();
            
            if(menu_choice.matches("[1-7]")) {
            	int chosen_menu = Integer.parseInt(menu_choice);
            	if(chosen_menu >= 1 && chosen_menu <= 7) {
            		switch(chosen_menu){
            			case 1: reservation.user_input();
            					break;
            			case 5: {	String pwd = pwd_scan.next();
            						if(password(pwd) == true) {
            							System.exit(0);
            						}else {
            							System.out.println("��й�ȣ�� �ùٸ��� �ʽ��ϴ�.\n");
            							break;
            						}
            					}
            			case 7: {	String pwd = pwd_scan.next();
            						if(password(pwd) == true) {
            							validate.validate_file_exist();
            							validate.validate_file_grammer();
            						}else {
            							break;
            						}
            					}
            			default: continue;
            		}
            	}
           }else {
        	   System.out.println("�ش� ��ɾ�� �������� �ʽ��ϴ�.\n");
        	   continue;
           }
		}


    }


	public static void print_menu() {
		System.out.println("--------------------");
		System.out.println("	�޴�");
		System.out.println("--------------------");
        System.out.println("1. �����ϱ�");
        System.out.println("2. ���� ��ȸ");
        System.out.println("3. ���� ���");
        System.out.println("4. ���� ����");
        System.out.println("5. ���α׷� ����");
        System.out.println("6. ���� ���");
        System.out.println("7. ���Ἲ �˻�\n");
        System.out.println("���Ͻô� ��ȣ�� �����ϼ���:");
    }
    

    private static boolean password(String pwd) {

        if (pwd.trim().equals("1234"))
            return true;
        else
            return false;
    }

}
