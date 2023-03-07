package rikkei.academy;

import java.util.Scanner;

public class Main {
    static Student[] students = new  Student[1000];
    static Scanner scanner =new Scanner(System.in);
    static int index=0;
    public static void main(String[] args) {
        do {
            System.out.println("\n**********DANH SÁCH SINH VIÊN**********");
            System.out.println("Chon 1 để nhập số sinh viên và thông tin cho các sinh viên");
            System.out.println("Chon 2 in thông tin các sinh viên");
            System.out.println("Chon 3 để sắp xếp các sinh viên theo điểm trung bình tăng dần");
            System.out.println("Chon 4 để nhập vào tên và tìm kiếm sinh viên theo tên");
            System.out.println("Chon 5 thống kê số sinh viên nam nữ đang quản lý");
            System.out.println("Chon 6 in ra thông tin các sinh viên xếp loại giỏi và trung bình");
            System.out.println("Chon 7 Thoát");
            System.out.print("Mời chọn lựa (1/2/3/4/5/6/7) : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Main.inputStudent(scanner);
                    break;
                case 2:
                    Main.displayStudents();
                    break;
                case 3:
                    Main.sortedByAvgMark();
                    break;
                case 4:
                    Main.searchByName();
                    break;
                case 5:
                    Main.maleFemaleStudents();
                    break;
                case 6:
                    Main.rankAvgMark();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Chỉ nhập từ 1 đến 7");
            }
        }while (true);
    }

    public static void inputStudent(Scanner sc){
        System.out.printf("Nhâp số lượng sinh viên cần nhập thông tin : ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " +(i+1));
            students[index]=new Student();
            students[index].inputData();
            index++;
        }
    }
    public static void displayStudents(){
        for (int i = 0; i < index; i++) {
            students[i].displayData();
        }
    }
    public static void sortedByAvgMark(){
        for (int i = 0; i < index-1; i++) {
            for (int j = i+1; j < index; j++) {
                if (students[i].getAvgMark()>students[j].getAvgMark()){
                    Student sv = students[i];
                    students[i] = students[j];
                    students[j] = sv;
                }
            }
        }
        System.out.println("Đã sắp xếp sinh viên theo điểm trung bình tăng dần");
    }
    public static void searchByName() {
        System.out.println("Nhập tên sinh viên cần tìm : ");
        String s = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (students[i].getStudentName().startsWith(s)){
                students[i].displayData();
            }
        }
    }
    public static void maleFemaleStudents() {
        int countMale=0;
        int countFemale=0;
        for (int i = 0; i < index; i++) {
            if (students[i].getSex().equalsIgnoreCase("nam")){
                countMale++;
            }
            if (students[i].getSex().equalsIgnoreCase("nu")){
                countFemale++;
            }
        }
        System.out.println("Sô sinh viên nam là : " +countMale +" người");
        System.out.println("Sô sinh viên nam là : " +countFemale +" người");
    }

    public static void rankAvgMark(){
        System.out.println("Danh sách sinh viên xếp loại giỏi : ");
        for (int i = 0; i < index; i++) {
            if (students[i].getAvgMark() >= 8 && students[i].getAvgMark() < 9) {
                students[i].displayData();
            }
        }

        System.out.println("Danh sách sinh viên xếp loại TB : ");
        for (int i = 0; i < index; i++) {
            if (students[i].getAvgMark()>=5 && students[i].getAvgMark()<7){
                students[i].displayData();
            }
        }
    }
}

