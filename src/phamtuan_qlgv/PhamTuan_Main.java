package phamtuan_qlgv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhamTuan_Main {

	public static Scanner sc = new Scanner(System.in);

	static int k;

	public static void main(String[] args) {

		PhamTuan_Function pt = (PhamTuan_Function) new PhamTuan_Validate();

		ArrayList<PhamTuan_GiangVien> teacherList = new ArrayList<>();

		boolean flag = true;
		do {
			menu();
			System.out.print("\nMời bạn chọn: ");
			try {
				k = Integer.parseInt(sc.nextLine());
				switch (k) {
				case 1:
					int n;
					System.out.println("Nhập số Giảng Viên cần thêm: ");
					n = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < n; i++) {
						PhamTuan_GiangVien gv = new PhamTuan_GiangVien();
						System.out.println("----");
						System.out.println("Giảng viên thứ " + (i + 1));
						gv.inputInfo();
						teacherList.add(gv);
					}

					System.out.println(" ");
					break;
				case 2:
					for (int i = 0; i < teacherList.size(); i++) {
						System.out.println("----");
						teacherList.get(i).outputInfo();
					}

					System.out.println(" ");
					break;
				case 3:
					for (int i = 0; i < teacherList.size(); i++) {
						System.out.print("Tiền lương của Giảng Viên " + (i + 1) + " là: ");
						teacherList.get(i).salary();
					}

					System.out.println(" ");
					break;
				case 4:
					int minIndex = 0, maxIndex = 0;
					float minTime = teacherList.get(0).getTime();
					float maxTime = teacherList.get(0).getTime();

					for (int i = 1; i < teacherList.size(); i++) {
						if (teacherList.get(i).getTime() < minTime) {
							minIndex = i;
							minTime = teacherList.get(i).getTime();
						}

						if (teacherList.get(i).getTime() > maxTime) {
							maxIndex = i;
							maxTime = teacherList.get(i).getTime();
						}
					}

					System.out.println("Giảng viên làm ít nhất là: ");
					teacherList.get(minIndex).outputInfo();

					System.out.println("Giảng viên làm nhiều nhất là: ");
					teacherList.get(maxIndex).outputInfo();

					System.out.println(" ");
					break;
				case 5:
					Collections.sort(teacherList, new Comparator<PhamTuan_GiangVien>() {
						public int compare(PhamTuan_GiangVien o1, PhamTuan_GiangVien o2) {
							int tuan = o1.getName().compareTo(o2.getName());
							if (tuan >= 0) {
								return 1;
							}
							return -1;
						}
					});

					for (int i = 0; i < teacherList.size(); i++) {
						teacherList.get(i).outputInfo();
					}

					System.out.println(" ");
					break;
				case 6:
					System.out.println("Nhập mã Giảng viên cần tìm kiếm: ");
					String rollNoSearch = sc.nextLine();
					int count = 0;

					for (PhamTuan_GiangVien phamTuan_GiangVien : teacherList) {
						if (phamTuan_GiangVien.getRollNo().equalsIgnoreCase(rollNoSearch)) {
							phamTuan_GiangVien.outputInfo();
							count++;
						}
					}

					if (count == 0)
						System.out.println("Không tìm thấy Giảng viên nào!");

					System.out.println(" ");
					break;
				case 7:
					pt.add(teacherList);

					System.out.println(" ");
					break;
				case 8:

					System.out.println("Nhập vị trí cần sửa: ");

					while (true) {
						try {
							int index1 = Integer.parseInt(sc.nextLine());

							if (index1 < 0 || index1 > teacherList.size() - 1) {
								System.err.println("Bạn đã nhập sai vị trí trong mảng!");
							} else {
								pt.edit(teacherList, index1);
								System.out.println("Đã sửa thành công!");
							}
							break;
						} catch (Exception e) {
							System.err.println("Vui lòng nhập lại(số tự nhiên): ");
						}
					}

					System.out.println(" ");
					break;
				case 9:
					System.out.println("Nhập vị trí cần xóa: ");
					while (true) {
						try {
							int index = Integer.parseInt(sc.nextLine());

							if (index < 0 || index > teacherList.size() - 1) {
								System.err.println("Bạn đã nhập sai vị trí trong mảng, vui lòng nhập lai: ");
							} else {
								pt.remove(teacherList, index);
								System.out.println("Đã xóa thành công!");
								break;
							}
						} catch (Exception e) {
							System.err.println("Vui lòng nhập lại(số tự nhiên): ");
						}
					}

					System.out.println(" ");
					break;
				case 10:
					Collections.sort(teacherList, new Comparator<PhamTuan_GiangVien>() {
						public int compare(PhamTuan_GiangVien o1, PhamTuan_GiangVien o2) {
							return (int) (o1.getTime() - o2.getTime());
						}
					});

					System.out.println("Mảng sau khi sắp xếp.");
					for (PhamTuan_GiangVien phamTuan_GiangVien : teacherList) {
						System.out.println("-----");
						phamTuan_GiangVien.outputInfo();
					}

					System.out.println(" ");
					break;
				default:
					System.err.println("_____________Chương trình đã thoát______________");
					System.err.println("                   ---bye---");
					flag = false;
					break;
				}
			} catch (NumberFormatException ei) {
				System.err.println("Bạn đã nhập sai, hãy nhập lại(số tự nhiên)!");
				System.out.println(" ");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (flag);

	}

	static void menu() {
		System.out.println("PHẠM VĂN TUẤN - CHƯƠNG TRÌNH QUẢN LÝ GIẢNG VIÊN");
		System.out.println("--------------------MENU-----------------------");
		System.out.println("1. Nhập Giảng viên.");
		System.out.println("2. Hiển thị thông tin Giảng viên.");
		System.out.println("3. Hiển thị lương của Giảng viên.");
		System.out.println("4. Hiển thị Giảng viên có số giờ làm cao nhất và ít nhất.");
		System.out.println("5. Sắp xếp theo thứ tự A->Z dựa vào tên Giảng viên.");
		System.out.println("6. Tìm kiếm Giảng Viên theo mã.");
		System.out.println("7. Thêm Giảng viên.");
		System.out.println("8. Sửa thông tin Giảng viên theo vị trí.");
		System.out.println("9. Xóa Giảng viên theo vị trí.");
		System.out.println("10. Hiển thị mảng tăng dần theo giờ dạy.");
		System.out.println("Nhập số khác để thoát!!!");
	}

}
