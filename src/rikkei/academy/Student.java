package rikkei.academy;

import java.time.LocalDate;
import java.util.Scanner;

public class Student {
    Scanner scanner = new Scanner(System.in);
    private String studenId;
    private String studentName;
    private int age;
    private String sex;
    private String phone;
    private String address;
    private float scoreHtml;
    private float scoreCss;
    private float scoreJavaScrip;
    private float avgMark;

    public Student() {
    }

    public Student(String studenId, String studentName, int age, String sex, String phone, String address, float scoreHtml, float scoreCss, float scoreJavaScrip, float avgMark) {
        this.studenId = studenId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.scoreHtml = scoreHtml;
        this.scoreCss = scoreCss;
        this.scoreJavaScrip = scoreJavaScrip;
        this.avgMark = avgMark;
    }

    public String getStudenId() {
        return studenId;
    }

    public void setStudenId(String studenId) {
        this.studenId = studenId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getScoreHtml() {
        return scoreHtml;
    }

    public void setScoreHtml(float scoreHtml) {
        this.scoreHtml = scoreHtml;
    }

    public float getScoreCss() {
        return scoreCss;
    }

    public void setScoreCss(float scoreCss) {
        this.scoreCss = scoreCss;
    }

    public float getScoreJavaScrip() {
        return scoreJavaScrip;
    }

    public void setScoreJavaScrip(float scoreJavaScrip) {
        this.scoreJavaScrip = scoreJavaScrip;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void inputData(){
        boolean checkStudenName = true;
        do {
            System.out.println("Nh??p m?? sinh vi??n (G???m 5 k?? t??? b???t ?????u t??? RA) : ");
            this.studenId = scanner.nextLine();
            if (this.studenId.startsWith("RA")){
                checkStudenName =false;
            }else {
                System.err.println("Vui l??ng nh???p ????ng ?????nh d???ng");
            }
        }while (checkStudenName);


        do {
            System.out.println("Nh???p t??n sinh vi??n (ph???i t??? 8 ?????n 50 k?? t???): ");
            this.studentName = scanner.nextLine();
        }while (this.studentName.length()<8 || this.studentName.length()>50);

        do {
            System.out.println("Nh???p tu???i sinh vi??n (>= 18) : ");
            this.age = Integer.parseInt(scanner.nextLine());
        }while (this.age<18);

        System.out.println("Nh???p gi???i t??nh sinh vi??n : ");
        this.sex = scanner.nextLine();

        do {
            System.out.println("Nh???p s??? ??i???n thoai c???a sinh vi??n (ch??? nh???n 10 s??? v?? b???t ?????u t??? 0) : ");
            this.phone = scanner.nextLine();
        }while (this.phone.length()==11);

        System.out.println("Nh???p ?????a ch??? sinh vi??n : ");
        this.address = scanner.nextLine();

        do {
            System.out.println("Nh???p ??i???m thi HTML c???a sinh vi??n (0-10) : ");
            this.scoreHtml = Float.parseFloat(scanner.nextLine());
        }while (this.scoreHtml<0||this.scoreHtml>10);

        do {
            System.out.println("Nh???p ??i???m thi CSS c???a sinh vi??n (0-10) : ");
            this.scoreCss = Float.parseFloat(scanner.nextLine());
        }while (this.scoreCss<0||this.scoreCss>10);

        do {
            System.out.println("Nh???p ??i???m thi JacaScrip c???a sinh vi??n (0-10) : ");
            this.scoreJavaScrip = Float.parseFloat(scanner.nextLine());
        }while (this.scoreJavaScrip<0 || this.scoreJavaScrip>10);


        calAvgMark();
    }
    public void calAvgMark(){
        this.avgMark = (this.scoreHtml + this.scoreCss + 2*this.scoreJavaScrip )/4;
    }

    public void displayData(){
        System.out.printf("%8s%8s%50s%50s\n%10s%10d%5s%5s%15s%15s\n%10s%10s%5s%5f\n","M?? SV : ",this.studenId,". T??n Sinh Vi??n: ",this.studentName,
                "N??m Sinh: ",(LocalDate.now().getYear()-this.age),". Gi???i T??nh: ",this.sex,"S??? ??T: ",this.phone,"?????a Ch???: ",this.address,". ??i???m TB: ",this.avgMark);

    }
}
