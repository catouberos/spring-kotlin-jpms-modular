open module vn.edu.rmit.model {
    requires spring.data.jpa;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    exports vn.edu.rmit.model to vn.edu.rmit.repository, vn.edu.rmit.service;
}