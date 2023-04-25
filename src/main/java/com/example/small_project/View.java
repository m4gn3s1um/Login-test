package com.example.small_project;

public enum View {
    LOGIN("hello-view.fxml"),
    ADMIN("adminTest.fxml"),
    MAIN("LoggedInView.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
