package com;

public enum ReportGroupType {

    A_DAILY(FrequencyType.Daily),
    B_DAILY(FrequencyType.Daily),
    A_MONTHLY(FrequencyType.Monthly);

    private FrequencyType frequencyType;

    ReportGroupType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }
}
