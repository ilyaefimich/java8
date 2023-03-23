module Main {
    requires transitive jmp.service.api;
    requires transitive jmp.bank.api;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    requires jmp.dto;
}