package com.ajunoit.userpermissions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.ColumnInfoRecord;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class SeperateUsers {
	
    private static final String EXCEL_FILE_LOCATION = "C:\\Users\\akasjain\\Desktop\\up\\all_users_3_days.xls";

	public static void main(String[] args) throws BiffException, JSONException, RowsExceededException, WriteException, IOException {
		// TODO Auto-generated method stub
		/*Workbook workbook = null;
        try {

            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
            Sheet sheet = workbook.getSheet(0);
            
            Cell[] metadata = sheet.getColumn(3);
            List<JSONObject> data = new ArrayList<>();
            
            for (int i = 0; i < metadata.length; i++) {
				String row = metadata[i].getContents().toString();
            	data.add(new JSONObject(row));
			}
            
            List<String> userList = new ArrayList<>();
            
            for (JSONObject jsonObject : data) {
				userList.add(jsonObject.getString("remoteModifiedBy"));
			}
            
            Workbook aWorkBook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));

            
            WritableWorkbook aCopy = Workbook.createWorkbook(new File("C:\\Users\\akasjain\\Desktop\\up\\target_group_data_3_month_2003_users.xls"));
            WritableSheet writableSheet = aCopy.createSheet("Sheet 1", 0);
            writableSheet.insertColumn(5);
            
            System.out.println(userList.size());
            for (int i = 0; i < userList.size(); i++) {
				Label label = new Label(5, i, userList.get(i));
				writableSheet.addCell(label);
			}
            
            aCopy.write();
            aCopy.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        
        getUniqueUsers();*/
		
		Set<String> newUsers = getUsers("C:\\Users\\akasjain\\Desktop\\up\\all_users_3_days.xls");
		Set<String> oldUsers = getUsers("C:\\Users\\akasjain\\Desktop\\up\\all_users_3_months_excluded.xls");
		
		System.out.println(newUsers.size() + "  " + newUsers.toString());
		System.out.println(oldUsers.size() + "  " + oldUsers.toString());

		
		boolean diff = newUsers.removeAll(oldUsers);
		System.out.println("New users- " + newUsers.size());
		
		System.out.println("New Users - " + newUsers.toString());
		
		newUsers = getUsers("C:\\Users\\akasjain\\Desktop\\up\\all_users_3_days.xls");

		
		boolean diff2 = oldUsers.removeAll(newUsers);
		System.out.println("Old users- " + oldUsers.size());

	}
	
	public static void getUniqueUsers() throws BiffException, IOException {
		
		Set<UserInfo> usersRecent = getUserSet("C:\\Users\\akasjain\\Desktop\\up\\all_users_3_days.xls");
		Set<UserInfo> usersPrevious = getUserSet("C:\\Users\\akasjain\\Desktop\\up\\all_users_3_months.xls");
		
		Set<UserInfo> diff;
		Workbook workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
		Sheet sheet = workbook.getSheet(0);
		int numOfItems = sheet.getColumn(0).length;
		
        Cell[] imsOrgCell = sheet.getColumn(0);
        Cell[] userIdsCell = sheet.getColumn(1);

        List<String> imsOrgs = new ArrayList<>();
        List<String> userId = new ArrayList<>();
        
        for (int i = 0; i < imsOrgCell.length; i++) {
        	imsOrgs.add(imsOrgCell[i].getContents());
			userId.add(userIdsCell[i].getContents());
		}
		
		for (int i = 0; i < numOfItems; i++) {
			UserInfo user = new UserInfo(imsOrgs.get(i), userId.get(i));
			usersRecent.add(user);
		}
		
		
		System.out.println(usersRecent.size());
		System.out.println(usersPrevious.size());
		
		
		
	}
	
	public static Set<UserInfo> getUserSet(String fileLocation) throws BiffException, IOException {
		
		Set<UserInfo> usersRecent = new HashSet<>();
		
		Workbook workbook = Workbook.getWorkbook(new File(fileLocation));
		Sheet sheet = workbook.getSheet(0);
		int numOfItems = sheet.getColumn(0).length;
		
        Cell[] imsOrgCell = sheet.getColumn(0);
        Cell[] userIdsCell = sheet.getColumn(1);

        List<String> imsOrgs = new ArrayList<>();
        List<String> userId = new ArrayList<>();
        
      
        for (int i = 0; i < imsOrgCell.length; i++) {
        	imsOrgs.add(imsOrgCell[i].getContents());
			userId.add(userIdsCell[i].getContents());
		}
		
		for (int i = 0; i < numOfItems; i++) {
			UserInfo user = new UserInfo(imsOrgs.get(i), userId.get(i));
			usersRecent.add(user);
		}
		return usersRecent;
	}
	
	public static Set<String> getUsers(String fileLocation) throws BiffException, IOException {
		
		Workbook workbook = Workbook.getWorkbook(new File(fileLocation));
		Sheet sheet = workbook.getSheet(0);
		int numOfItems = sheet.getColumn(0).length;
		
        Cell[] imsOrgCell = sheet.getColumn(1);

        List<String> imsOrgs = new ArrayList<>();
        Set<String> imsOrgSet = new HashSet<>();
      
        for (int i = 0; i < imsOrgCell.length; i++) {
        	imsOrgs.add(imsOrgCell[i].getContents());
        	imsOrgSet.add(imsOrgCell[i].getContents());
		}
		
		return imsOrgSet;
	}
}
