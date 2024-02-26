module com.courses.jsp_examples {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.courses.jsp_examples to javafx.fxml;
    exports com.courses.jsp_examples;
    exports utilities;
    opens utilities to javafx.fxml;
}