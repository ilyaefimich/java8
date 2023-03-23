module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    exports com.serviceimpl.initializator;
    exports com.serviceimpl;
}