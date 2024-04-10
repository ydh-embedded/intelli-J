package MAP;

import pEmployment.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Eine Tabelle mit zwei Spalten
in der Ersten-Spalte steht de rKey
in der Zweite-Spalte steht das value
 */
public class cMAP {

    public static Map<String, Employee> mapEmployeeById = new HashMap<>(Map.of(
            "A001" , new Employee("Alice" , "A001" , "Sales"),
            "A002" , new Employee("Abe" , "A002" , "Sales"),
            "A003" , new Employee("Abbey" , "A003" , "Sales"),
            "A004" , new Employee("Adrian" , "A004" , "Sales")
    ));

    public static void main(String[] args) {
        mCreateHashMaps("A001" , "sales");
        mCreateTreeMaps("A001" , "sales");
        mRemoveKeyValuePair("EM001");

    }

    public static void mCreateHashMaps(String id , String department){


        mapEmployeeById.put("EM001" , new Employee("ElonM" , "EM001" , "CEO"));
        System.out.println(mapEmployeeById);


    }


    public static void mCreateTreeMaps( String id , String department){
        Map< String , Employee > employeeById = new TreeMap<>(Map.of(
                "A001" , new Employee("Alice" , "A001" , "Sales"),
                "A002" , new Employee("Abe" , "A002" , "Sales"),
                "A003" , new Employee("Abbey" , "A003" , "Sales"),
                "A004" , new Employee("Adrian" , "A004" , "Sales")
        ));

        employeeById.put("EM001" , new Employee("ElonM" , "EM001" , "CEO"));
        System.out.println(employeeById);


    }

    public static void mRemoveKeyValuePair( String id ){



        mapEmployeeById.remove("EM001");
        System.out.println(mapEmployeeById);


    }
    public static void mPrintEmployeeMap(Map<String , Employee> map){
        for (String id: map.keySet()){
            Employee employee = map.get(id);
            System.out.printf("ID: %-10s Name: %-20s Department: %-10s\n" ,
                    id ,
                    employee.name(),
                    employee.department()
            );
        }
    }







}
