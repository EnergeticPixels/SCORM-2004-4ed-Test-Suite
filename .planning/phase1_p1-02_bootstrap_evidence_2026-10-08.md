## Phase 1 P1-02 Bootstrap Evidence - 2026-10-08

Status: Captured
Related runbook: [phase1_p1-02_legacy_environment_bootstrap_runbook_v1.md](phase1_p1-02_legacy_environment_bootstrap_runbook_v1.md)
Operator: energ + Copilot

### Session Environment Used
- Working directory: [software_development](../software_development)
- `SCORM4ED_TS111_HOME`: `C:\Users\energ\Desktop\SCORM_CTS\software_development`
- `JAVA_HOME`: `C:\Program Files\Microsoft\jdk-25.0.0.36-hotspot`
- `ANT_HOME`: `C:\buildTools\apache-ant-1.10.18`

### Toolchain Verification
- `ant -version`: Apache Ant(TM) version 1.10.18 compiled on September 3 2026
- `java --version`: OpenJDK 25 2025-09-16 LTS
- `where ant`: resolved to `C:\buildTools\apache-ant-1.10.18\bin\ant(.bat/.cmd)`

### Ant Target Discovery
- Command: `ant -p`
- Result: Success
- Notes: Full target list displayed; default target is `CTS`.

### Diagnostics Capture
- Command: `ant -diagnostics`
- Result: Success
- Notes:
- Ant core 1.10.18 loaded from `C:\buildTools\apache-ant-1.10.18\lib\ant.jar`
- Java runtime reported as OpenJDK 25
- OS reported as Windows 11

### Baseline Build Attempt History
1. Attempt A
- Context: `SCORM4ED_TS111_HOME` set to repository root.
- Result: Failed.
- Failure: Source path resolved incorrectly (`...\Desktop\software_development\src` not found).
- Action: Corrected `SCORM4ED_TS111_HOME` to [software_development](../software_development).

1. Attempt B
- Context: Corrected `SCORM4ED_TS111_HOME`; JDK 25.
- Result: Failed at compile in `buildDebug`.
- Failure: Internal JDK API access from [software_development/src/org/adl/util/debug/ADLSimpleFormatter.java](../software_development/src/org/adl/util/debug/ADLSimpleFormatter.java).

1. Attempt C
- Context: Same as Attempt B, after source fix plus temporary compiler export flag.
- Result: Compile phase passed; build advanced to signing.
- Failure: `jarsigner: you must enter key password` in `signJar` target.

### In-Repo Fixes Applied During Bootstrap
- Permanent fix: [software_development/src/org/adl/util/debug/ADLSimpleFormatter.java](../software_development/src/org/adl/util/debug/ADLSimpleFormatter.java)
- Replaced internal `sun.security.action.GetPropertyAction` usage with `System.getProperty("line.separator")`.

- Temporary workaround: [software_development/buildDebug.xml](../software_development/buildDebug.xml)
- Added compiler argument `--add-exports=java.base/sun.security.action=ALL-UNNAMED` for legacy compatibility during Phase 1 baseline work.

### Current Classification
- Build classification: Class B progressing toward readiness.
- Current gate: Signing credentials not configured in [software_development/build.properties](../software_development/build.properties).
- Runtime classification: Pending browser/applet flow validation.

### Next Actions
1. Decide signing strategy for Phase 1 baseline:
1. Configure real keystore values.
1. Or create an unsigned baseline lane if allowed by governance for non-release evidence.

1. Re-run `ant` after signing decision and capture outcome.
1. Proceed to runtime flow checks for LMS, SCO, Content Package, and Manifest groups.
