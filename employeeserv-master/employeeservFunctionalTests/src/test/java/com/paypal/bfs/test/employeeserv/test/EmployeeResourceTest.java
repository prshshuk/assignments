package com.paypal.bfs.test.employeeserv.test;


import com.paypal.bfs.test.employeeserv.EmployeeservApplication;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.EmployeeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = EmployeeservApplication.class)
@AutoConfigureMockMvc
public class EmployeeResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    String exampleEmployeeJson = "{\n" +
            "    \"id\": 1,\n" +
            "    \"first_name\": \"BFS\",\n" +
            "    \"last_name\": \"Developer\",\n" +
            "    \"birthday\": \"2018-11-13\",\n" +
            "    \"address\": {\n" +
            "        \"line1\": \"line 1 of address\",\n" +
            "        \"line2\": \"line 2 of address\",\n" +
            "        \"city\": \"Hyderabad\",\n" +
            "        \"state\": \"Telangana\",\n" +
            "        \"country\": \"India\",\n" +
            "        \"zipcode\": \"100503\"\n" +
            "    }\n" +
            "}";

    @Test
    public void createEmployee() throws Exception {

        Employee mockEmployee = createMockEmployee();

        Mockito.when(
                employeeService.createEmployee(Mockito.any(EmployeeDto.class))).thenReturn(Optional.of(EmployeeUtil.getEmployeeDto(mockEmployee)));;

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/bfs/employees")
                .accept(MediaType.APPLICATION_JSON).content(exampleEmployeeJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    private Employee createMockEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("BFS");
        employee.setLastName("Developer");
        employee.setBirthday("2018-11-13");

        Address address = new Address();
        address.setLine1("line 1 of address");
        address.setLine2("line 2 of address");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setCountry("India");
        address.setZipcode("100503");

        employee.setAddress(address);
        return employee;
    }
}
