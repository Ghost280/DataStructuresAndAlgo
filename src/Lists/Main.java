package Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {

        /** ArrayList implementation
         * ArrayList is backed by array so accessing arrays based on Index is v v fast O(1) i.e., constant time
         * CAUTION: ArrayList is not Syncronized i.e, not thread safe. If multiple threads access the arrayList
         * and tries to modify it. It may introduce ambuigity in data. A seperate thread Syncronization is required
         * in such cases.
         * Else just use Vector in multi thread environment.
         * FEATURES/DISADVANTAGES: 
         *  - Best for element access via index
         *  - If element addition and deletion i.e, array resize is frequently required, it is best to avoid arrays.
         **/
        {
            List<Employee> employeeList = new ArrayList<>();
            employeeList.add(new Employee("Jane", "Jones", 1234));
            employeeList.add(new Employee("Lara", "Croft", 23434));
            employeeList.add(new Employee("Jhon", "Doe", 23123));
            employeeList.add(new Employee("Kratos", "God", 1240));
            
            // System.out.println(employeeList.get(1));
            // System.out.println(employeeList.isEmpty());
            employeeList.set(2, new Employee("Jhon", "Adams", 23123));
            //  employeeList.forEach(employee -> System.out.println(employee));
            employeeList.add(3, new Employee("Jhon", "Doe", 12));

            employeeList.remove(2);
            Employee[]  employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
            for (Employee employee: employeeArray){ 
                System.out.println(employee);
            }

            System.out.println(employeeList.contains(new Employee("Lara", "Croft", 23434)));
            System.out.println(employeeList.indexOf(new Employee("Jhon", "Adams", 23123)));
            System.out.println(employeeList.size());
        }

         /** Vector implementation
         * Only differece between ArrayList and Vector is that Vector is Thread Safe i.e, syncronized
         * But it is also slow as it is Syncronized. Only use Vector when a thread safe environment is needed.
         **/
        {
            List<Employee> employeeVectorList = new Vector<>();
            employeeVectorList.add(new Employee("Jane", "Jones", 1234));
            employeeVectorList.add(new Employee("Lara", "Croft", 23434));
            employeeVectorList.add(new Employee("Jhon", "Doe", 23123));
            employeeVectorList.add(new Employee("Kratos", "God", 1240));
            
            // System.out.println(employeeVectorList.get(1));
            // System.out.println(employeeVectorList.isEmpty());
            employeeVectorList.set(2, new Employee("Jhon", "Adams", 23123));
            //  employeeVectorList.forEach(employee -> System.out.println(employee));
            employeeVectorList.add(3, new Employee("Jhon", "Doe", 12));

            employeeVectorList.remove(2);
            Employee[]  employeeVectorArray = employeeVectorList.toArray(new Employee[employeeVectorList.size()]);
            for (Employee employee: employeeVectorArray){ 
                System.out.println(employee);
            }

            System.out.println(employeeVectorList.contains(new Employee("Lara", "Croft", 23434)));
            System.out.println(employeeVectorList.indexOf(new Employee("Jhon", "Adams", 23123)));
            System.out.println(employeeVectorList.size());
        }

        /** Singly LinkedList Implementation */
        {
            Employee JaneJones = new Employee("Jane", "Jones", 1234);
            Employee laraCroft = new Employee("Lara", "Croft", 23434);
            Employee JhonDoe = new Employee("Jhon", "Doe", 23123);
            Employee KratosGod = new Employee("Kratos", "God", 1240);

            Employee JhonAdams = new Employee("Jhon", "Adams", 12);

            EmployeeLinkedList linkedList = new EmployeeLinkedList();
            linkedList.addToFront(JaneJones);
            linkedList.addToFront(laraCroft);
            linkedList.addToFront(JhonDoe);
            linkedList.addToFront(KratosGod);
            linkedList.printLL();

            System.out.println(linkedList.getSize());
            System.out.println("");

            linkedList.removeFromFront();
            linkedList.printLL();

            System.out.println(linkedList.getSize());
            System.out.println(linkedList.isEmpty());

            linkedList.addToEnd(JhonAdams);
            System.out.println("");
            linkedList.printLL();
            System.out.println(linkedList.getSize());
            EmployeeNode value = linkedList.retriveAtIndex(1);
            System.out.println(value.toString());
        }
    }
}
