package com;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public abstract class AbstractReportGroup<E extends Enum<E> & ReportType> implements ReportGroup {

    protected final Set<E> getMatchingReports(EnumSet<E> allReports, RunnerParams params) {
        Set<String> reportName = params.getReports();
        if (reportName == null) return allReports;
        Map<String, E> reportMap = allReports.stream().collect(Collectors.toMap(r -> r.getReportName(), e -> e));
        Set<E> reports = new HashSet<>();
        reportName.forEach(name -> {
            if (reportMap.containsKey(name)) {
                reports.add(reportMap.get(name));
            } else {
                throw new IllegalArgumentException("enknown report - " + name);
            }
        });
        return null;
    }

    protected final void generateReport(LocalDate localDate, Set<E> matchingReports) {
        AtomicReference<Exception> ex = new AtomicReference<>();
        for (E report : matchingReports) {
            try {
                ReportGenerator reportGenerator = report.getReportClass().newInstance();
                if (reportGenerator.isEnable())
                    reportGenerator.generateReport(localDate);
            } catch (Exception e) {
                ex.set(e);
            }
        }
        if (ex.get() != null) {
            throw new RuntimeException();
        }
    }
}
