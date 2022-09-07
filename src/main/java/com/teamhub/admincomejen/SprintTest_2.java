package com.teamhub.admincomejen;

import com.teamhub.admincomejen.entities.*;

import java.time.LocalDate;

public class SprintTest_2 {

    public static void main(String[] args) {
        System.out.println("\n########################################## TASK 1 ##########################################\n");

        long id = 270822;
        String name = "Empresa Prueba";
        String document = "000" + 1;
        String phone = "111" + 1;
        String address = "calle Prueba";
        LocalDate createdAt = LocalDate.now();
        LocalDate updateAt = LocalDate.now();

        Enterprise enterprice = new Enterprise(id, name, document, phone, address, createdAt,updateAt);

        System.out.println(enterprice.printEnterprise());

        System.out.println("\n====================================");
        System.out.println(" El nombre de la empresa es: " + enterprice.getName());
        enterprice.setName("planta de energía nuclear Springfield");
        System.out.println(" EL nombre de la empresa despues de modificar es: " + enterprice.getName());
        System.out.println("\n====================================");
        System.out.println(" La direccion de la empresa es: " + enterprice.getAddress());
        enterprice.setAddress("Avenida Siempreviva");
        System.out.println(" La direccion de la empresa despues de modificar es: " + enterprice.getAddress());
        System.out.println("\n====================================");
        System.out.println(" EL numero de telefono de la empresa es: " +  enterprice.getPhone());
        enterprice.setPhone("764-84377");
        System.out.println(" El numero de telefono despues de modificar es: " + enterprice.getPhone());
        System.out.println("\n====================================");
        System.out.println(" El documento o NIT de la emprersa es: " + enterprice.getDocument());
        enterprice.setDocument("Moe-84377");
        System.out.println(" El documento o NIT de la empresa despues de modificar es: " + enterprice.getDocument());

        System.out.println(enterprice.printEnterprise());

        System.out.println("\n########################################## TASK 2 ##########################################\n");

        long idEmployee = 1;
        String nameEmployee = "Homero";
        String email = "homero23@Springfield.com";
        Profile profile = new Profile();
        Enum_RoleName enum_roleName = Enum_RoleName.Operario;
        LocalDate createdAtEmployee = LocalDate.now();
        LocalDate updateAtEmployee = LocalDate.now();

        Employee employee = new Employee(idEmployee, nameEmployee, email, profile, enum_roleName, enterprice, updateAtEmployee, createdAtEmployee);

        System.out.println(employee.printEmployee());

        System.out.println("\n====================================");
        System.out.println(" El nombre del empleado es: " + employee.getName());
        employee.setName("Homero Simpson");
        System.out.println(" El nombre del empleado despues de modificar es: " + employee.getName());
        System.out.println("\n====================================");
        System.out.println(" El email del empleado es: " + employee.getEmail());
        employee.setEmail("homeroSimpson23@Springfield.com");
        System.out.println(" El email del empleado despues de modificar es: " + employee.getEmail());
        System.out.println("\n====================================");
        System.out.println(" La empresa a la que pertenece el empleado es: " + employee.getEnterprise().printEnterprise());
        employee.setEnterprise(new Enterprise(220827L,"Homer's web page","Hom-84377","764-84377","742 Evergreen Terrace",LocalDate.now(),LocalDate.now()));
        System.out.println(" La empresa a la que pertenece el empleado despues de modificar es: " +  employee.getEnterprise().printEnterprise());
        System.out.println("\n====================================");
        System.out.println(" El rol del empleado es: " + employee.getRole());
        employee.setRole(Enum_RoleName.Admin);
        System.out.println(" El rol del empleado depues de modificar es: " + employee.getRole());

        System.out.println(employee.printEmployee());

        System.out.println("\n########################################## TASK 3 ##########################################\n");

        long idTransaction = 1;
        String concept = "Compra de Rosquillas Diablo";
        float amount = (float) 5.80;
        LocalDate createdAtTransaction = LocalDate.now();
        LocalDate updateAtTransaction = LocalDate.now();

        Transaction transaction = new Transaction(idTransaction, concept, amount, employee, enterprice, createdAtTransaction, updateAtTransaction);

        System.out.println(transaction.printTransaction());

        System.out.println("\n====================================");
        System.out.println(" El monto de la transaccion es: " + transaction.getAmount() + "$");
        transaction.setAmount((float) 10);
        System.out.println(" El monto de la transaccion despues de modificar es: " + transaction.getAmount() + "$");
        transaction.setAmount((float) -9.8);
        System.out.println(" El monto de la transaccion depues de modificar por un valor negativo es: " + transaction.getAmount() + "$");
        System.out.println("\n====================================");
        System.out.println(" El concepto de la transaccion es: " + transaction.getConcept());
        transaction.setConcept("Cerveza Duff BEER");
        System.out.println(" El concepto de la transaccion despues de modificar es: " + transaction.getConcept());
        System.out.println("\n====================================");
        System.out.println(" El Usuario que registro la transaccion es: " + transaction.getEmployee().printEmployee());

        System.out.println(transaction.printTransaction());

    }
}
