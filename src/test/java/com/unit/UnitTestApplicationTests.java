package com.unit;

import com.unit.model.Employee;
import com.unit.repo.EmployeeRepository;
import com.unit.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestApplicationTests {
	@Autowired
	public EmployeeService service;

	@MockBean
	public EmployeeRepository repository;

	@Test
	public void getEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new  Employee("1", "Satya", "SDE", 30000), new Employee("2", "Rahul", "ASE", 40000)).collect(Collectors.toList()));
		assertEquals(2, service.getEmployee().size());
	}

	@Test
	public void getEmployeebyEmpIdTest() {
		String empId = "1";
		when(repository.findByEmpId(empId))
				.thenReturn(Stream.of(new  Employee("1", "Satya", "SDE", 30000)).collect(Collectors.toList()));
		assertEquals(1, service.getEmployeebyId(empId).size());
	}

	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee("1", "Satya", "SDE", 30000);
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.addEmployee(employee));
	}

	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee("1", "Satya", "SDE", 30000);
		service.deleteEmployee(employee);
		verify(repository, times(1)).delete(employee);
	}

}