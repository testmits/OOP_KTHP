package phamtuan_qlgv;

import java.util.List;

public interface PhamTuan_Function {
	public void add(List<PhamTuan_GiangVien> teacherList);

	public void remove(List<PhamTuan_GiangVien> teacherList, int i);

	public void edit(List<PhamTuan_GiangVien> teacherList, int i);
}
