package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    private ListView<String> studentInfoListView;
    private TextField searchField;

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(490);
        anchorPane.setPrefHeight(680);

        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.setPrefWidth(50);
        leftAnchorPane.setPrefHeight(590);

        ListView<HBox> studentListView = new ListView<>();
        studentListView.setPrefWidth(230);
        studentListView.setPrefHeight(550);

        for (int i = 1; i <= 10; i++) {
            HBox studentHBox = createStudentHBox(i);
            studentListView.getItems().add(studentHBox);
        }

        AnchorPane.setTopAnchor(studentListView, 10.0);
        AnchorPane.setLeftAnchor(studentListView, 10.0);
        leftAnchorPane.getChildren().add(studentListView);

        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.setPrefWidth(250);
        rightAnchorPane.setPrefHeight(620);

        studentInfoListView = new ListView<>();
        studentInfoListView.setPrefSize(230, 510);

        searchField = new TextField();
        searchField.setPromptText("Buscar alumno...");
        searchField.setPrefWidth(230);
        searchField.setPrefHeight(30);
        searchField.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(studentInfoListView, 10.0);
        AnchorPane.setLeftAnchor(studentInfoListView, 10.0);
        AnchorPane.setTopAnchor(searchField, 530.0);
        AnchorPane.setLeftAnchor(searchField, 10.0);
        rightAnchorPane.getChildren().addAll(studentInfoListView, searchField);

        AnchorPane.setLeftAnchor(leftAnchorPane, 0.0);
        AnchorPane.setRightAnchor(rightAnchorPane, 0.0);
        anchorPane.getChildren().addAll(leftAnchorPane, rightAnchorPane);
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            String searchText = newValue.toLowerCase();
            ObservableList<HBox> filteredStudents = FXCollections.observableArrayList();
            if (searchText.isEmpty()) {
                filteredStudents.addAll(studentListView.getItems());
            } else {
                for (HBox studentHBox : studentListView.getItems()) {
                    Label nameLabel = (Label) studentHBox.getChildren().get(1);
                    String studentName = nameLabel.getText().toLowerCase();
                    if (studentName.contains(searchText)) {
                        filteredStudents.add(studentHBox);
                    }
                }
            }
            studentListView.setItems(filteredStudents);
        });

        // Agregar un listener para restablecer la lista completa de alumnos cuando se borre el texto del campo de búsqueda
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                studentListView.setItems(FXCollections.observableArrayList(studentListView.getItems()));
            }
        });

        Scene scene = new Scene(anchorPane, 490, 570);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Interface utiizando Layouts");
        primaryStage.setResizable(false);

        primaryStage.show();

        studentListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showStudentInfo(newValue);
            }
        });
    }

    private HBox createStudentHBox(int index) {
        Image image = new Image("file:C:\\Users\\Kev54\\Documents\\Java - Proyectos\\KevRBriones\\Usuario.png"); // Reemplaza con la ruta de tu imagen
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        Label label = new Label(getStudentName(index));
        label.setStyle("-fx-font-weight: bold;");

        HBox studentHBox = new HBox(imageView, label);
        studentHBox.setAlignment(Pos.CENTER_LEFT);
        studentHBox.setSpacing(10);
        studentHBox.setPadding(new Insets(10));

        return studentHBox;
    }

    private String getStudentName(int index) {
        switch (index) {
            case 1:
                return "John Doe";
            case 2:
                return "Alice Smith";
            case 3:
                return "Michael Johnson";
            case 4:
                return "Emily Brown";
            case 5:
                return "David Wilson";
            case 6:
                return "Sophia Martinez";
            case 7:
                return "Daniel Lee";
            case 8:
                return "Olivia Garcia";
            case 9:
                return "William Rodriguez";
            case 10:
                return "Isabella Lopez";
            default:
                return "Unknown";
        }
    }

    private void showStudentInfo(HBox studentHBox) {
        ObservableList<String> studentInfo = FXCollections.observableArrayList();
        if (studentHBox.getChildren().size() > 1) {
            Label nameLabel = (Label) studentHBox.getChildren().get(1);
            String studentName = nameLabel.getText();
            switch (studentName) {
                case "John Doe":
                    studentInfo.addAll("Cédula: 12345678", "Nombres: John", "Apellidos: Doe", "Edad: 25",
                            "Estado civil: Soltero", "Curso: Programación Java", "Paralelo: A",
                            "Teléfono: 123456789", "Hobby: Fotografía", "Estatura: 175 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Alice Smith":
                    studentInfo.addAll("Cédula: 87654321", "Nombres: Alice", "Apellidos: Smith", "Edad: 23",
                            "Estado civil: Casada", "Curso: Diseño Gráfico", "Paralelo: B",
                            "Teléfono: 987654321", "Hobby: Pintura", "Estatura: 160 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Michael Johnson":
                    studentInfo.addAll("Cédula: 45678912", "Nombres: Michael", "Apellidos: Johnson", "Edad: 27",
                            "Estado civil: Soltero", "Curso: Ingeniería de Software", "Paralelo: A",
                            "Teléfono: 123456789", "Hobby: Ajedrez", "Estatura: 180 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Emily Brown":
                    studentInfo.addAll("Cédula: 98765432", "Nombres: Emily", "Apellidos: Brown", "Edad: 22",
                            "Estado civil: Soltera", "Curso: Diseño Gráfico", "Paralelo: B",
                            "Teléfono: 987654321", "Hobby: Lectura", "Estatura: 165 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "David Wilson":
                    studentInfo.addAll("Cédula: 56789012", "Nombres: David", "Apellidos: Wilson", "Edad: 24",
                            "Estado civil: Casado", "Curso: Programación Java", "Paralelo: A",
                            "Teléfono: 123456789", "Hobby: Fútbol", "Estatura: 170 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Sophia Martinez":
                    studentInfo.addAll("Cédula: 23456789", "Nombres: Sophia", "Apellidos: Martinez", "Edad: 21",
                            "Estado civil: Soltera", "Curso: Diseño Gráfico", "Paralelo: B",
                            "Teléfono: 987654321", "Hobby: Música", "Estatura: 163 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Daniel Lee":
                    studentInfo.addAll("Cédula: 67890123", "Nombres: Daniel", "Apellidos: Lee", "Edad: 26",
                            "Estado civil: Soltero", "Curso: Ingeniería de Software", "Paralelo: A",
                            "Teléfono: 123456789", "Hobby: Senderismo", "Estatura: 175 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Olivia Garcia":
                    studentInfo.addAll("Cédula: 34567890", "Nombres: Olivia", "Apellidos: Garcia", "Edad: 22",
                            "Estado civil: Soltera", "Curso: Diseño Gráfico", "Paralelo: B",
                            "Teléfono: 987654321", "Hobby: Jardinería", "Estatura: 158 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "William Rodriguez":
                    studentInfo.addAll("Cédula: 89012345", "Nombres: William", "Apellidos: Rodriguez", "Edad: 25",
                            "Estado civil: Soltero", "Curso: Programación Java", "Paralelo: A",
                            "Teléfono: 123456789", "Hobby: Cocinar", "Estatura: 180 cm",
                            "Discapacidad: Ninguna");
                    break;
                case "Isabella Lopez":
                    studentInfo.addAll("Cédula: 45612378", "Nombres: Isabella", "Apellidos: Lopez", "Edad: 20",
                            "Estado civil: Soltera", "Curso: Diseño Gráfico", "Paralelo: B",
                            "Teléfono: 987654321", "Hobby: Viajar", "Estatura: 162 cm",
                            "Discapacidad: Ninguna");
                    break;
                default:
                    studentInfo.add("Información no disponible");
            }
        }
        studentInfoListView.setItems(studentInfo);
    }

    public static void main(String[] args) {
        launch(args);
    }
}