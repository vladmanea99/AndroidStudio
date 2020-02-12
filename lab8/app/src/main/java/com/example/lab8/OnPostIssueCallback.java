package com.example.lab8;

public interface OnPostIssueCallback {
    void onSuccess(Issue issue);
    void onError();
}