open module vn.edu.rmit.application {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.core;
    requires spring.beans;
    requires kotlin.stdlib;
    requires kotlin.reflect;

    requires vn.edu.rmit.controller;
    requires vn.edu.rmit.service;
    requires vn.edu.rmit.repository;
    requires spring.data.jpa;
}