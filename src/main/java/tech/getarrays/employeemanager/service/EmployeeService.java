package tech.getarrays.employeemanager.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeService {

    public static final String EMPLOYEE_NOT_BY_ID = "Employee not by id ";
    private final EmployeeRepo employeeRepo;


    public Employee addEmployee(Employee  employee){
         employee.setEmployeeCode(UUID.randomUUID().toString());
         return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee()
    {
        return  employeeRepo.findAll();
    }

    public  Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }


    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }


    public Employee findEmployeeById(Long id) throws Throwable {
        return employeeRepo.findEmployeeById (id).orElseThrow(()->new UserNotFoundException(EMPLOYEE_NOT_BY_ID +id));
    }


}
