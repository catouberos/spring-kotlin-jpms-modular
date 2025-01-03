open module vn.edu.rmit.repository {
    requires spring.data.jpa;
    requires spring.context;
    requires vn.edu.rmit.model;

    exports vn.edu.rmit.repository to vn.edu.rmit.service;
}