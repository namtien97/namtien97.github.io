import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _690Leetcode {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private Set<Integer> daDuyet = new HashSet<>();

    int totalImportance = 0;

    private void DFS(List<Employee> allEmployee, int id) {
        //1. Kiem tra dieu kien dung
        boolean isExist = false;
        Employee curEmployee = null;
        for (Employee e : allEmployee) {
            if (e.id == id) {
                curEmployee = e;
                break;
            }
        }

        if (isExist == false) {
            return;
        }
        // 2. Kiem tra id da duoc duyet chua
        if (daDuyet.contains(id) == true) {
            return;
        }

        // 3. Xu ly Tang totalImportance + id.importance
        totalImportance += curEmployee.importance;

        // 4. Danh dau da duyet
        daDuyet.add(id);

        // 5.Duyet den tat ca cac node con | nhan vien cap duoi
        for (Integer capDuoiId : curEmployee.subordinates) {
            DFS(allEmployee, capDuoiId);
        }
    }

    public int getImportance(List<Employee> allEmployee, int id) {
        DFS(allEmployee, id);
        return totalImportance;
    }
}
