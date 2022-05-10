//  BuilderExample.groovy
package builder.basic

import builder.basic.CompanyBuilder
import builder.basic.model.Company
import builder.basic.model.Department
import builder.basic.model.Employee

class BuilderExample { 
   static void main(String[] args) { 
      CompanyBuilder builder = new CompanyBuilder()

      Company company = builder.company('ABC') {
        department('XYZ') {
            employee('emp12345') {
               name('John')
               role('Administrator')
            }
        }
        department('123') {
            employee('emp987') {
                name('Karen')
                role('Project Manager')
            }
            department('456') {
               employee('emp456') {
                   name('Mary')
                   role('Developer')
                }
            }
        }
    }
    println("Comapny Id: ${company.getId()}")
    println(company.getDepartments().each { dept -> println("Department Id: ${dept.getId()}") })
    println(company.getDepartments().each { dept -> 
	   println("Department Id: ${dept.getId()}");
	   dept.getEmployees().each { 
	      emp -> println("\tEmployee Id: ${emp.getId()}. Name: ${emp.getName()}. Role: ${emp.getRole()}") 
	   };
	   dept.getDepartments().each { 
	      dpt -> println("\tDept Id: ${dpt.getId()}");
		  dpt.getEmployees().each {e -> println("\t\tEmployee Id: ${e.getId()}. Name: ${e.getName()}. Role: ${e.getRole()}") }
	   }
	})
   } 
}
