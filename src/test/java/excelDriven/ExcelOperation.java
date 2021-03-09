package excelDriven;

public class ExcelOperation {
    public static void main(String[] args) {
        Xls_Reader reader=new Xls_Reader("/Users/Eda/TestNG_iq/ebay.xlsx");
      /*  String firstname=reader.getCellData("Ebay1", "firstname", 2);
        System.out.println(firstname);
        String lastname=reader.getCellData("Ebay1", "lastname", 2);
        System.out.println(lastname);
        String email=reader.getCellData("Ebay1","email", 2);
        System.out.println(email);
        String password=reader.getCellData("Ebay1","password", 2);
        System.out.println(password);
        // tek tekherkesin isimlerini yazdirmak cok uzun olur onun yerine for loop ise yarar
        String firstname1=reader.getCellData("Ebay1", "firstname", 3);
        System.out.println(firstname1);
        String lastname1=reader.getCellData("Ebay1", "lastname", 3);
        System.out.println(lastname1);
        String email1=reader.getCellData("Ebay1","email", 3);
        System.out.println(email1);
        String password1=reader.getCellData("Ebay1","password", 3);
        System.out.println(password1);

      */

        // for loop listenin tamamini kullanmak yada yazdirmak icin
        int rows =reader.getRowCount("Ebay1");

        for(int rowNum=2; rowNum<rows; rowNum++){
            String firstname=reader.getCellData("Ebay1", "firstname", rowNum);
            System.out.println(firstname);
            String lastname=reader.getCellData("Ebay1", "lastname", rowNum);
            System.out.println(lastname);
            String email=reader.getCellData("Ebay1","email", rowNum);
            System.out.println(email);
            String password=reader.getCellData("Ebay1","password", rowNum);
            System.out.println(password);

            System.out.println("**************************");
        }


    }

}
