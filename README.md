# Orange HRM Live Demo app

This README provides an overview of the Orange HRM Live Demo web application automation project and its setup

## Table of Contents

- [Description](#description)
- [Framework](#framework)
- [Installation](#installation)
- [Contact](#contact)

## Description

The aim of the project is to create an automation framework to automate several workflows within the orange HRM Live demo application. The project is built in BDD format using Cucumber and Java as the programming language.

## Framework
The project is built in Cucumber framework using Java programming language.
Page Object Model is utilised to build the tests. Elements from different pages of the application are grouped into its respective pages - Login,Admin etc.
The base url, test environment and some other parameters are saved on a config.properties file. 
A custom logger is implemented which defines the logging format and logging level and is configured to log to console. 
Extent report is implemented to generate a report after running the tests, which also adds screeshots at failed steps.
 
## Installation

To install and run this project, follow these steps:

1. On GitHub.com, navigate to https://github.com/niranjananandu/com.orangehrmlive.demo
2. Above the list of files, click Code.
3. Click Download ZIP.
4. Extract the files and run the run.bat file in the folder (Install any dependencies).

## Contact
Name: Niranjana Nandu
email: nanduniranjana@gmail.com


