## PROGRAMACIÓN EN AMBIENTES GRÁFICOS CON ACCESO A DATOS
#### Tema: Interface utilizando Layouts
![](https://scontent.fgye30-1.fna.fbcdn.net/v/t1.15752-9/441975341_1018421543037462_2040574894034559846_n.png?_nc_cat=103&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGaEGjRxHVgaFuCvIlVt9UIM8PylYoGn6Mzw_KVigafo94tFFyN6u0Us2mMP3jbbOW7LAW2RhIiAeuPp5mFivVn&_nc_ohc=NV9AgAH1VgsQ7kNvgFh21YR&_nc_ht=scontent.fgye30-1.fna&oh=03_Q7cD1QH0kcs80uI0Xc5QMxlF6Bn3yPp1aV3VB9X7TQOdjXdtIA&oe=665FCA1F)
- Crear una interfaz utilizado layouts.
- La interfaz contiene del lado izquierdo una lista de estudiantes. Ejemplo: imagen - Nombre y Apellido.
- Del lado derecho hay una ListView que al presionar el nombre de un Alumno aparecerá su información.
- En la parte inferior derecha, está un TextField que sirve como buscador por coincidencia.

### JavaFX

Cambiar la ruta de acceso en caso de modificar la imagen.
```javaFX
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
```

#### EJECUCIÓN
![](https://scontent.fgye30-1.fna.fbcdn.net/v/t1.15752-9/441025597_764857225770368_614755159757913928_n.png?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGepPk0bjyguV6Act5CUortjczGMOthTmyNzMYw62FObFh7QMKLYHOITMmT6u-rUD_iyUgXlF5h4dDbIirk1o4-&_nc_ohc=jaYpzqGajwkQ7kNvgH-3TUN&_nc_ht=scontent.fgye30-1.fna&oh=03_Q7cD1QHBTFCgYjR79cIVu87rA2Z1m9l8FdEs0Q6PLX9fc11JAg&oe=665FE39C)
