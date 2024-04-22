import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.initializeEmployees();
        system.displayEmployees();
        system.addEmployee();
        system.displayEmployees();
        system.removeEmployee();
        system.displayEmployees();
    }

    public void initializeEmployees() {
        // Khởi tạo 10 nhân viên
        for (int i = 1; i <= 10; i++) {
            employees.add(new Employee(i, "Employee" + i, 25 + i, "Department" + i, "Code" + i, 1000 + i * 100));
        }
    }

    public void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void addEmployee() {
        System.out.println("Thông tin nhân viên mới:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Code: ");
        String code = scanner.nextLine();
        System.out.print("Salary Rate: ");
        double salaryRate = scanner.nextDouble();

        employees.add(new Employee(id, name, age, department, code, salaryRate));
        System.out.println("Thêm thành công!");
    }

    public void removeEmployee() {
        System.out.print("Nhập ID nhân viên cần xóa: ");
        int idToRemove = scanner.nextInt();
        boolean removed = false;
        for (Employee employee : employees) {
            if (employee.getId() == idToRemove) {
                employees.remove(employee);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Đã xóa thành công nhân viên có ID " + idToRemove + "!");
        } else {
            System.out.println("Nhân viên có ID " + idToRemove + " không tồn tại");
        }
    }
}
