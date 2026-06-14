# Automated & Comprehensive Software Quality Assurance Portfolio
> End-to-End Manual, Functional Automated, Performance, and Security Testing for the "Sweet Shop" E-Commerce Platform.

## 📌 Project Overview
This repository serves as a production-grade demonstration of Software Quality Assurance (SQA) engineering competencies across the entire testing lifecycle. Using the **Sweet Shop** e-commerce web application as the Target Under Test (TUT), this project implements a rigorous, four-pillar verification strategy spanning manual exploration, Behavior-Driven Development (BDD) automated functional pipelines, infrastructure performance profiling, and dynamic application security testing (DAST).

The core objective is to move beyond superficial testing to validate business-critical workflows (Authentication, Cart Persistence, Checkout Operations), ensure infrastructure resilience under heavy concurrent transactional loads, and expose exploitable security vulnerabilities prior to deployment.

---

## 🛠️ Core Testing Pillars & Technical Stack

The engineering strategy isolates risks by splitting verification into specialized runtime targets:

### 1. Manual & Exploratory Testing
* **Scope:** Initial boundary UI/UX evaluation, visual regression checks, edge-case sanity sweeps, and usability heuristic mapping.
* **Deliverables:** Structured matrix charting unexpected behavioral shifts outside scripted execution paths.

### 2. Automated Functional Testing (BDD)
* **Runtime Infrastructure:** `Java Core (JDK 11+)` | `Selenium WebDriver`
* **Architecture Pattern:** Page Object Model (POM) separating UI selectors/interactions from test assertions to minimize regression maintenance overhead.
* **Framework Execution:** `Cucumber` utilizing `Gherkin` natural language syntax to bridge technical implementation and business requirement documentation.

### 3. Performance & Scalability Profiling
* **Core Engine:** `Apache JMeter`
* **Test Profiles Executed:** 
    * **Load Testing:** Establishing steady-state performance baselines under standard operational capacity.
    * **Stress Testing:** Exposing system degradation thresholds, memory leaks, and saturation failure behaviors under maximum concurrency.

### 4. Security Vulnerability Assessment (DAST)
* **Core Engine:** `OWASP ZAP (Zed Attack Proxy)`
* **Vector Scans:** Automated active/passive vulnerability mapping focused on critical attack surfaces including Cross-Site Scripting (XSS), SQL Injection (SQLi), and Missing Security Header configurations (e.g., Anti-CSRF, X-Frame-Options).

---

## 📋 Repository Architecture & Matrix

The workspace is systematically partitioned to isolate source code from configuration blueprints and reporting artifacts:

| Artifact / Directory | Format / Stack | Engineering Purpose |
| :--- | :--- | :--- |
| `/src/test/java/` | Java / Cucumber / Selenium | Source code holding Page Object abstractions, Step Definitions, and Test Runner wrappers. |
| `/src/test/resources/features/` | Gherkin Feature Files | Plain-text declarative testing specifications mapping business acceptance criteria. |
| `/performance/` | JMeter `.jmx` Blueprints | Configured thread groups, timers, and samplers detailing standardized performance scenarios. |
| `/security/` | OWASP ZAP Reports | Executive alerts, raw payload responses, and CVSS severity scoring logs mapping vulnerability postures. |
| `Test_Execution_Matrix.xlsx` | Microsoft Excel | Unified master matrix containing 13 granular test cases (5 Functional, 5 Performance, 3 Security). |
| `QA_Strategy_Reporting.pdf` | Word / PDF Document | Comprehensive test closure report including methodology, environment configurations, and visual execution proofs. |

---

## 🚀 Key Objectives & Metric Thresholds

To ensure high objective alignment, the project enforces strict, quantified Key Performance Indicators (KPIs):
* **Functional Scope:** Achieve a 100% execution pass rate across mission-critical transaction flows (*User Login validation*, *dynamic Shopping Cart state updates*, *multi-step Checkout execution*).
* **Performance Benchmark:** System must maintain an optimal average response time threshold (`< 2000ms`) when subjected to a concurrent load profile of `50+ virtual users (VUs)` without throwing HTTP 5xx or connection timeout errors.
* **Security Risk Mitigation:** Isolation, reporting, and architectural remediation recommendations for all identified high-to-medium risk vulnerabilities affecting transactional pages.

---

## 💻 Sample Automation Blueprint (BDD Feature)

```gherkin
Feature: Shopping Cart Checkout Integrity

  Scenario: Authenticated user successfully checks out an e-commerce order
    Given the consumer is authenticated on the Sweet Shop portal
    When they add a production item to the shopping cart
    And they proceed to the checkout terminal with valid payment credentials
    Then the system should process the transaction successfully
    And an order tracking identifier must be visible to the consumer
