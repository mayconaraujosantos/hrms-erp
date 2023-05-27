module com.mkdata.hrms.payroll {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    exports com.mkdata.hrms.payroll.application;
    exports com.mkdata.hrms.payroll.domain;
    exports com.mkdata.hrms.payroll.infrastructure;
    exports com.mkdata.hrms.payroll.interfaces;
}
