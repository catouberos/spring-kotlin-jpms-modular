open module vn.edu.rmit.service {
    requires vn.edu.rmit.repository;
    requires vn.edu.rmit.dto;
    requires spring.context;
    requires kotlin.stdlib;
    requires vn.edu.rmit.model;
    requires spring.data.commons;

    exports vn.edu.rmit.service;
}