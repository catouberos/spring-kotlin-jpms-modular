module vn.edu.rmit.dto {
    requires spring.context;

    exports vn.edu.rmit.dto.course;
    exports vn.edu.rmit.dto.course.internal to vn.edu.rmit.service;
}