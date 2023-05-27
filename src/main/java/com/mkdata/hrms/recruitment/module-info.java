module com.mkdata.hrms.recruitment {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    exports com.mkdata.hrms.recruitment.application;
    exports com.mkdata.hrms.recruitment.domain;
    exports com.mkdata.hrms.recruitment.infrastructure;
    exports com.mkdata.hrms.recruitment.interfaces;
}
