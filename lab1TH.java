import java.util.Scanner;
import java.util.Arrays;
 class SinhVien {
    private int mssv;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    public SinhVien() {
    }

    public SinhVien(int mssv, String hoTen, String diaChi, String soDienThoai) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv=" + mssv +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
    public void showInfo() {
        System.out.printf("%-5d %-20s %-15s %-15s \n", mssv, hoTen, diaChi, soDienThoai);
    }
}
public class lab1TH {
    static Scanner sc = new Scanner(System.in);

    static void inputInfo(SinhVien nhap) {
        System.out.println("Nhap ho ten Sinh vien: ");
        nhap.setHoTen(sc.nextLine());
        System.out.println("Nhap dia chi Sinh vien");
        nhap.setDiaChi(sc.nextLine());
        System.out.println("Nhap ma Sinh vien: ");
        nhap.setMssv(sc.nextInt());
        ;
        sc.nextLine();
        do {
            System.out.println("Yeu cau nhap SDT 9 so: ");
            nhap.setSoDienThoai(sc.nextLine());
        } while (nhap.getSoDienThoai().length() != 9);
    }

    static void menu() {
      
        System.out.println("       BAN CHON LAM GI          ");
        
        System.out.println("1. Nhap thong tin sinh vien");
        System.out.println("2. Xuat thong tin sinh vien");
        System.out.println("3. Nhap so khac de thoat");
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien sv[] = null;
        int a, n = 0;
        boolean c = true;
        do {
            menu();
            System.out.print("NHAP YEU CAU: "); int chon = sc.nextInt();
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.print("Nhap so luong sinh vien can khai bao: ");
                    n = sc.nextInt();
                    sv = new SinhVien[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh vien thu " + (i + 1)+": ");
                        sv[i] = new SinhVien();
                        inputInfo(sv[i]);
                    }
                    break;
                case 2:
                    SinhVien temp = sv[0];
                    for (int i = 0; i < sv.length - 1; i++) {
                        for (int j = i + 1; j < sv.length; j++) {
                            if (sv[i].getMssv() > sv[j].getMssv()) {
                                temp = sv[j];
                                sv[j] = sv[i];
                                sv[i] = temp;
                            }
                        }
                    }
                    System.out.printf("%-5s %15s %15s %20s \n", "MSSV", "Ho va ten", "Đia chi", "So đien thoai");
                    for (int i = 0; i < n; i++) {
                        sv[i].showInfo();
                    }
                    break;
                default:
                    System.out.println("Ket thuc");
                    c = false;
                    break;
            }
        }while (c);
    }
}

