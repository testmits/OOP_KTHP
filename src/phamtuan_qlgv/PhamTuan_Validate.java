package phamtuan_qlgv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhamTuan_Validate extends PhamTuan_GiangVien implements PhamTuan_Function {

	@Override
	public void add(List<PhamTuan_GiangVien> teacherList) {
		PhamTuan_GiangVien gv = new PhamTuan_GiangVien();
		System.out.println("----");
		gv.inputInfo();
		teacherList.add(gv);

	}

	@Override
	public void remove(List<PhamTuan_GiangVien> teacherList, int i) {
		for (int j = 0; j < teacherList.size(); j++) {
			if (j == i) {
				teacherList.remove(j);
				break;
			}
		}

	}

	@Override
	public void edit(List<PhamTuan_GiangVien> teacherList, int i) {
		for (int j = 0; j < teacherList.size(); j++) {
			if (j == i) {
				teacherList.get(i).inputInfo();
				break;
			}
		}

	}

}
