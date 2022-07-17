package phamtuan_qlgv;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhamTuan_GiangVien extends PhamTuan_Nguoi {

	private String rollNo;
	private String email;
	private String department;
	private String level;
	private float time;

	public PhamTuan_GiangVien() {
		super();
	}

	public PhamTuan_GiangVien(String rollNo, String email, String department, String level, float time) {
		super();
		this.rollNo = rollNo;
		this.email = email;
		this.department = department;
		this.level = level;
		this.time = time;
	}

	public String getRollNo() {
		return rollNo;
	}

	public boolean setRollNo(String rollNo) {
		if (rollNo != null && rollNo.length() == 8) {
			this.rollNo = rollNo;
			return true;
		} else {
			System.err.println("Nhập lại mã giảng viên(độ dài phải 8 ký tự): ");
			return false;
		}
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		if (email != null && email.contains("@") && !email.contains(" ")) {
			this.email = email;
			return true;
		} else {
			System.err.println("Nhập lại email(phải có ký tự @ và không có khoảng trắng): ");
			return false;
		}
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLevel() {
		return level;
	}

	public boolean setLevel(String level) {
		if (level.contains("Thạc Sĩ") || level.contains("Tiến Sĩ") || level.contains("Giáo Sư")) {
			this.level = level;
			return true;
		} else {
			System.err.println("Vui lòng nhập lại: ");
			return false;
		}
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public void inputInfo() {
		super.inputInfo();
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập mã giảng viên: ");
		while (true) {
			String rollNoInput = sc.nextLine();
			boolean check = setRollNo(rollNoInput);
			if (check) {
				break;
			}
		}

		System.out.print("Nhập email giảng viên: ");
		while (true) {
			String emailInput = sc.nextLine();
			boolean check = setEmail(emailInput);
			if (check) {
				break;
			}
		}

		System.out.print("Nhập khoa: ");
		department = sc.nextLine();

		System.out.print("Nhập trình độ: ");
		while (true) {
			String levelInput = sc.nextLine();
			boolean check = setLevel(levelInput);
			if (check) {
				break;
			}
		}

		System.out.print("Nhập số giờ giảng dạy: ");
		while (true) {
			try {
				time = Float.parseFloat(sc.nextLine());
				break;
			} catch (Exception e) {
				System.err.println("Bạn đã nhập sai, vui lòng nhập lại: ");
			}
		}

	}

	public void outputInfo() {
		super.outputInfo();

		System.out.println("Mã giảng viên: " + rollNo);
		System.out.println("Email: " + email);
		System.out.println("Trình độ: " + level);
		System.out.println("Khoa: " + department);
		System.out.println("Số giờ dạy: " + time);
	}

	public void salary() {
		double salary = 0;
		if (level.contains("Thạc Sĩ")) {
			salary = 100 * time;
		} else if (level.contains("Tiến Sĩ")) {
			salary = 250 * time;
		} else if (level.contains("Giáo Sư")) {
			salary = 500 * time;
		}

		System.out.println(salary);
	}
}
