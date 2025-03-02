open module vn.edu.rmit.application {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.core;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.context;
    requires kotlin.stdlib;
    requires kotlin.reflect;

    requires vn.edu.rmit.controller;
    requires vn.edu.rmit.service;
    requires vn.edu.rmit.repository;
    requires vn.edu.rmit.generator;
}