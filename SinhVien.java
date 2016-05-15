import java.io.DataOutput;
import java.io.IOException;

public class SinhVien {
	String name;
	int tuoi;
	double grade;

	public SinhVien(String name, int tuoi, double grade) {
		super();
		this.name = name;
		this.tuoi = tuoi;
		this.grade = grade;
	}

	public boolean saveSV(DataOutput out) {
		try {
			out.writeUTF(getName());
			out.writeInt(getTuoi());
			out.writeDouble(grade);
			return true;

		} catch (IOException e) {
			return false;
			// TODO: handle exception
		}
	}
		public SinhVien read(int j){
			return null;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

}
