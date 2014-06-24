package springbook.user.process;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import spring.user.dao.GradeDao;
import springbook.user.domain.Grade;

public class GradeProcess {
		GradeDao gradeDao;
		public void setGradeDao(GradeDao gradeDao){
			this.gradeDao = gradeDao;
		}
		
		public void inputData() throws SQLException{
			//데이터의 입력과 성적 데이터를 처리하기 위한 함수 
			Scanner scan = new Scanner(System.in);
			System.out.println("Input data");
			System.out.println("School number : ");
			int snumber = scan.nextInt();
			System.out.println("Name : ");
			String name = scan.next();
			System.out.println("Korean : ");
			int korean = scan.nextInt();
			System.out.println("English : ");
			int english = scan.nextInt();
			System.out.println("Math : ");
			int math = scan.nextInt();
			
			Grade grade = new Grade(snumber, name, korean, english, math);
			grade = processData(grade);

			gradeDao.insertGrade(grade);
		}
		
		public Grade processData(Grade grade){
			//총점 및 평균 그리고 학점을 연산하기 위한 함수 
			grade.setSum(grade.getKorean()+grade.getEnglish()+grade.getMath());
			grade.setAvr((float)grade.getSum()/3);
			if(grade.getAvr() >= 90) grade.setGrade("A");
			else if(grade.getAvr() >= 80) grade.setGrade("B");
			else grade.setGrade("F");
			grade.setRank(1);
			
			return grade;
		}
		
		public ArrayList<Grade> rankProcess(ArrayList<Grade> list){
			//﻿ 데이터들의 평균을 비교하여 순위를 연산하기 위한 함수
			for(int i=0;i<list.size(); i++) list.get(i).setRank(1);
            for(int i=0;i<list.size(); i++){                   
                    for(int j=0;j<list.size(); j++){
                          if(list.get(i).getAvr()<list.get(j).getAvr())
                        	  list.get(i).setRank(list.get(i).getRank()+1); 
                    }
            }
            return list;
		}
		
		public ArrayList<Grade> insertProcess() throws SQLException,ClassNotFoundException{
			// 전체적인 성적 입력 처리에 대한 로직을 내포한 함수
			ArrayList<Grade> list = new ArrayList<Grade>();
			inputData();
			list = gradeDao.getStudent();
			gradeDao.rankUpdate(list);
			
			int size = list.size()-1;
			DecimalFormat df = new DecimalFormat (".00");
			
			System.out.println("=====***** Adding Grade Information *****=====");
			System.out.println("Snumber\tName\tKorean\tEnglish\tMath\tSum\tAvr\tGrade\tRank");
			System.out.println(list.get(size).getSnumber()+ "\t " + list.get(size).getName() + "\t " + list.get(size).getKorean()
					+ "\t " + list.get(size).getEnglish() + "\t " + list.get(size).getMath() + "\t " + list.get(size).getSum()
					+ "\t " + df.format(list.get(size).getAvr())+"\t "+list.get(size).getGrade()+"\t "+list.get(size).getRank());
			
			return list;
		}
		
		public void printProcess() throws ClassNotFoundException, SQLException{
			// 전체적인 성적 출력 처리에 대한 로직을 내포한 함수
			ArrayList<Grade> list = new ArrayList<Grade>();
            list = gradeDao.getStudent();
            
			DecimalFormat df = new DecimalFormat (".00");

			System.out.println("=====***** Printing Grade Data *****=====");
			System.out.println("Snumber\tName\tKorean\tEnglish\tMath\tSum\tAvr\tGrade\tRank");
			for(int size=0; size<list.size(); size++){
				System.out.println(list.get(size).getSnumber()+ "\t " + list.get(size).getName() + "\t " + list.get(size).getKorean()
						+ "\t " + list.get(size).getEnglish() + "\t " + list.get(size).getMath() + "\t " + list.get(size).getSum()
						+ "\t " + df.format(list.get(size).getAvr())+"\t "+list.get(size).getGrade()+"\t "+list.get(size).getRank());
			}
		}
		
		 public void deleteAllProcess() throws SQLException{
             gradeDao.deleteAll();
		 }
}
