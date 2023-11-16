package com.example.qusrydsl_ex11ver.repository;

import com.example.qusrydsl_ex11ver.entity.Department;
import com.example.qusrydsl_ex11ver.entity.Employee;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.example.qusrydsl_ex11ver.entity.QEmployee.employee;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
//@Rollback(value=false)
public class QueryDslTest {
    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory;


    @BeforeEach
    public void factoryCreate(){
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    public void jpqlTest(){
        //given
        createTestData();

        //when
        Employee findEmp = em.createQuery("select e from Employee e where e.empName = :empName", Employee.class)
                .setParameter("empName", "emp1")
                .getSingleResult();
        //then
        assertThat(findEmp.getDepartment().getDeptName()).isEqualTo("dept1");
        System.out.println(findEmp);
        System.out.println(findEmp.getDepartment());
    }

    @Test
    public void querydslTest(){
        createTestData();
        //QEmployee e = employee; // 직접 만든 별칭
        Employee findEmp = queryFactory
                .select(employee)
                .from(employee)
                .where(employee.empName.eq("emp1"))
                .fetchOne();
        assertThat(findEmp.getDepartment().getDeptName()).isEqualTo("dept1");
        System.out.println(findEmp);
        System.out.println(findEmp.getDepartment());
    }

    @Test
    public void 검색(){
        // when
        List<Employee> findEmp = queryFactory
                .select(employee)
                .from(employee)
                .where(
                        employee.department.deptId.eq(1)
                                .or(employee.salary.goe(100))
                )
                .fetch();
        // then
        assertThat(findEmp.size()).isEqualTo(3);
    }

    private void createTestData() {
        Department dept1 = new Department();
        dept1.setDeptName("dept1");
        em.persist(dept1);

        Department dept2 = new Department();
        dept2.setDeptName("dept2");
        em.persist(dept2);

        Employee emp1 = new Employee();
        emp1.setEmpName("emp1");
        emp1.setDepartment(dept1);
        emp1.setSalary(100);
        em.persist(emp1);

        Employee emp2 = new Employee();
        emp2.setEmpName("emp2");
        emp2.setDepartment(dept1);
        emp1.setSalary(200);
        em.persist(emp2);

        Employee emp3 = new Employee();
        emp3.setEmpName("emp3");
        emp3.setDepartment(dept2);
        emp1.setSalary(300);
        em.persist(emp3);
    }

}
