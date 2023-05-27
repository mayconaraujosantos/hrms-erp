module com.mkdata.hrms.timeandattendance {
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    exports com.mkdata.hrms.timeandattendance.application;
    exports com.mkdata.hrms.timeandattendance.domain;
    exports com.mkdata.hrms.timeandattendance.infrastructure;
    exports com.mkdata.hrms.timeandattendance.interfaces;
}
