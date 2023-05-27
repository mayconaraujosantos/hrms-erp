module com.mkdata.hrms.auth {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    exports com.mkdata.hrms.auth.application;
    exports com.mkdata.hrms.auth.domain;
    exports com.mkdata.hrms.auth.infrastructure;
    exports com.mkdata.hrms.auth.interfaces;
}
