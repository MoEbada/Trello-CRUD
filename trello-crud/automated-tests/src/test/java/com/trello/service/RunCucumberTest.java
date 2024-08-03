package com.trello.service;

import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("com/trello/service/TrelloBoardScenarios.feature")
public class RunCucumberTest {
}