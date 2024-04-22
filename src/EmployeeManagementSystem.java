import java.util.ArrayList;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void initializeEmployees() {
        // Khởi tạo danh sách nhân viên
        for (int i = 1; i <= 10; i++) {
            employees.add(new Employee(i, "Employee" + i, 25 + i, "Department" + i, "Code" + i, 1000 + i * 100));
        }
    }

    public void getNewEmployee(Employee employee) {
        boolean idExists = false;
        for (Employee existingEmployee : employees) {
            if (existingEmployee.getId() == employee.getId()) {
                idExists = true;
                break;
            }
        }
        if (!idExists) {
            // Nếu ID chưa tồn tại, thêm nhân viên vào danh sách
            employees.add(employee);
            System.out.println("Nhân viên đã được thêm thành công.");
        } else {
            System.out.println("ID đã tồn tại. Không thể thêm nhân viên.");
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}
