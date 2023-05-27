module com.mkdata.hrms.training {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    exports com.mkdata.hrms.training.application;
    exports com.mkdata.hrms.training.domain;
    exports com.mkdata.hrms.training.infrastructure;
    exports com.mkdata.hrms.training.interfaces;
}
