import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity {
    private static EmployeeManagementSystem employeeManagementSystem;

    public static void main(String[] args) {
        employeeManagementSystem = new EmployeeManagementSystem();
        employeeManagementSystem.initializeEmployees();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayEmployeeList(employeeManagementSystem.getEmployees());
                    break;
                case 2:
                    addEmployee(scanner);
                    break;
                case 3:
                    chooseEmployeeToRemove(scanner);
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }

    private static void displayEmployeeList(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Nhập ID của nhân viên mới: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên của nhân viên mới: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi của nhân viên mới: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập phòng ban của nhân viên mới: ");
        String department = scanner.nextLine();
        System.out.print("Nhập mã code của nhân viên mới: ");
        String code = scanner.nextLine();
        System.out.print("Nhập lương của nhân viên mới: ");
        double salaryRate = scanner.nextDouble();

        Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
        employeeManagementSystem.getNewEmployee(newEmployee);
    }

    private static void chooseEmployeeToRemove(Scanner scanner) {
        System.out.print("Nhập ID của nhân viên cần xóa: ");
        int idToRemove = scanner.nextInt();
        Employee employeeToRemove = null;
        for (Employee employee : employeeManagementSystem.getEmployees()) {
            if (employee.getId() == idToRemove) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeManagementSystem.removeEmployee(employeeToRemove);
            System.out.println("Nhân viên đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy nhân viên có ID " + idToRemove);
        }
    }
}
