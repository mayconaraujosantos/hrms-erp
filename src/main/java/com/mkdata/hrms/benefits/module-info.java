module com.mkdata.hrms.benefits {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    exports com.mkdata.hrms.benefits.application;
    exports com.mkdata.hrms.benefits.domain;
    exports com.mkdata.hrms.benefits.infrastructure;
    exports com.mkdata.hrms.benefits.interfaces;
}
