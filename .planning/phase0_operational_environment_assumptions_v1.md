## Phase 0 Operational Environment Assumptions (v1)

Status: Provisional baseline approved for planning
Version: 1.0
Last Updated: 2026-08-26
Source roadmap: [plan_modernization_firstblush.md](plan_modernization_firstblush.md)
Source acceptance criteria: [phase0_acceptance_criteria_v1.md](phase0_acceptance_criteria_v1.md)

### Purpose
Record the target operational assumptions for the modernization effort before server-hosted deployment is considered.

### Operating Model (Current Modernization Scope)
1. Application remains client-side only for this stage.
1. Server-hosted runtime (for example, Apache Tomcat) is deferred to a later phase.
1. Primary objective remains SCORM 2004 4th Edition conformance validation behavior.

### Target Runtime Environment
1. Host OS: Standard Windows 11 machine.
1. Java runtime: OpenJDK runtime (JRE portion of chosen OpenJDK distribution policy).
1. Browser support policy:
1. Google Chrome current major and one previous major version (as of 2026-08-26).
1. Microsoft Edge current major and one previous major version (as of 2026-08-26).
1. Offline capability: Required.

### Security and Access Assumptions
1. Authentication model: None for client-only phase.
1. Authorization model: Not introduced in this phase.
1. Security hardening still applies to local runtime behavior, dependency policy, and artifact integrity.

### Installation and Packaging Assumptions
1. Runtime launch package is the contents of [software_development/TestSuite](software_development/TestSuite).
1. Launch entry point is [software_development/TestSuite/main.htm](software_development/TestSuite/main.htm).
1. Files outside TestSuite are treated as build-time source/assets used to produce deployable TestSuite runtime artifacts.

### Logging and Local Artifacts
1. Historical behavior included local test logs.
1. Expected legacy location is [software_development/TestSuite/Logs](software_development/TestSuite/Logs), pending Phase 1 verification.
1. Exact runtime logging paths and artifact naming conventions will be validated during Phase 1 baseline evidence capture.

### Accessibility and Compliance Assumptions
1. Legacy application did not target modern accessibility requirements.
1. Refactor target is WCAG 2.2 AA alignment as much as feasible without breaking conformance testing goals.
1. SCORM conformance behavior remains primary and must be preserved.

### Audit and Verification Expectations
1. Audit expectations are broader than unit tests alone.
1. Required verification evidence should include:
1. Unit tests for deterministic logic where practical.
1. Functional and integration verification of key workflows.
1. Regression comparison evidence against baseline behavior.
1. Accessibility evidence (automated and manual checks) for modernized UI changes.

### Deferred Decisions
1. Server deployment model (Tomcat or equivalent), including auth and multi-user controls.
1. Centralized log retention and enterprise access controls.
1. Production-grade networked architecture decisions.

### Version History
- v1.0 (2026-08-26): Initial operational environment assumptions baseline for client-only modernization phase.
