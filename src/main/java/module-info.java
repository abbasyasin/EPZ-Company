module com.example.simulating_operations_of_an_epz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.simulating_operations_of_an_epz to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz;
    opens com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer  to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;
    opens com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer  to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;
    opens com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion  to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;
    opens com.example.simulating_operations_of_an_epz.abbas.executiveChairman  to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.abbas.executiveChairman;
    opens com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;
    opens com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;
    opens com.example.simulating_operations_of_an_epz.rathna.company to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.rathna.company;
    opens com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;
    opens com.example.simulating_operations_of_an_epz.login to javafx.fxml;
    exports com.example.simulating_operations_of_an_epz.login;

}