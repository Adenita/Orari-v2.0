public class Department 
{
    private int departmentID;
    private String name; 
	
	public Department(int departmentID, String name) {	
		this.name = name;
        this.departmentID = departmentID;
	}
	
    public String getName() {
		return name;
	}

    public int getDepartmentID() {
        return departmentID;
    }

}