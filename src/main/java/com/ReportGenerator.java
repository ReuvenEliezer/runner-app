package com;

import java.time.LocalDate;

public interface ReportGenerator extends Report {

    void generateReport(LocalDate localDate);
}
