# Distance Converter App

## Overview
The **Distance Converter App** is a JavaFX-based distance conversion application that allows users to convert between various units of distance, such as feet, inches, miles, yards, meters, centimeters, and millimeters.

## Features
- **Intuitive Graphical User Interface (GUI)** for distance conversions.
- Supports conversion between multiple distance units.
- Includes a **console-based alternative (CLI)** for distance conversions.
- **Unit Reversal**: Reverse the conversion units with a click of a button.
- **Error Handling**: Handles invalid inputs and provides informative error messages.

## Installation and Usage

### Prerequisites
To run the application, you will need the following:
- **Java Development Kit (JDK)** (Version 11 or higher recommended).
- **JavaFX SDK**
**Steps to Set Up JavaFX SDK:**
1. Go to the official [Gluon JavaFX website](https://gluonhq.com/products/javafx/).
2. Scroll down and download the JavaFX SDK for your operating system.
3. Extract the downloaded ZIP file to a location on your computer.

## File Structure

The project consists of the following main Java files:

- **App.java**: This file contains the JavaFX-based graphical user interface (GUI) for the distance converter application. It allows users to input a value, select units, and view the converted result. The application also includes error handling, a unit reversal feature, and a clean UI layout.

- **Convert.java**: This file handles the core conversion logic of the application. It calculates the conversion between different distance units by utilizing data from the `Data.java` class. The method ensures accurate unit conversions based on predefined conversion rates.

- **Data.java**: This file stores and manages the conversion factors for different distance units. It provides methods to convert values to and from meters, ensuring flexibility and accuracy in unit conversions. The data is structured in a way that allows easy retrieval and calculation.

- **Main.java**: This is the command-line interface (CLI) version of the distance converter. It takes user input via the console, performs the conversion using `Convert.java`, and displays the results. This file serves as an alternative to the GUI-based application.

### Running the Application

#### Compile the Java Files

Open a terminal/command prompt and navigate to the directory where the Java files are stored. 
Use the following commands to compile the Java files and to run the GUI-based distance converter application:

```bash
javac --module-path ./<path_to_javaFX_directory>/lib --add-modules javafx.controls -cp . -Xlint:deprecation App.java Convert.java Data.java Main.java

java --module-path ./<path_to_javaFX_directory>/lib --add-modules javafx.controls App
