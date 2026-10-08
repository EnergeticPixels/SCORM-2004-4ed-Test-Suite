## Phase 1 P1-02 Legacy Environment Bootstrap Runbook (v1)

Status: Draft (ready for execution and evidence capture)
Version: 1.2
Last Updated: 2026-10-08
Backlog Item: P1-02
Source backlog: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)
Depends on: [phase1_p1-01_baseline_test_matrix_v1.md](phase1_p1-01_baseline_test_matrix_v1.md)

### Objective
Provide a repeatable bootstrap procedure for building and launching the legacy test suite environment, including fallback guidance when historical toolchain/browser components are unavailable.

### Current Host Snapshot (Observed)
1. `java --version` resolves to OpenJDK 25 LTS.
1. Apache Ant 1.10.18 is installed and available when `ANT_HOME` and PATH are set for the session.
1. `SCORM4ED_TS111_HOME` must point to the `software_development` folder for this repository when running Ant from that folder.
1. Previously observed modern-JDK compile blocker in [software_development/src/org/adl/util/debug/ADLSimpleFormatter.java](../software_development/src/org/adl/util/debug/ADLSimpleFormatter.java) has been resolved in-repo.
1. Current top-level `ant` execution now reaches jar signing and fails at `jarsigner` key-password prompt when signing inputs are not configured.

### Bootstrap Outcome Classes
1. Class A: historical-compatible runtime available (legacy applet-capable browser + legacy Java runtime).
1. Class B: build and partial runtime possible with modern Java/browser variance.
1. Class C: build or runtime blocked; blockers are captured with reproducible diagnostics.

### Required Inputs
1. Workspace root path for this repo.
1. Installed Java path to use for this run.
1. Apache Ant installation path (folder containing `bin/ant.bat`).
1. Keystore availability decision for signing steps in Ant build.

### Step 1: Open a Fresh Terminal
Use a new PowerShell window to avoid stale PATH or inherited environment issues.

### Step 2: Set Session Environment Variables
Run from [software_development](../software_development):

```powershell
$env:SCORM4ED_TS111_HOME = (Get-Location).Path
$env:JAVA_HOME = "C:\Program Files\Microsoft\jdk-25.0.0.36-hotspot"
$env:ANT_HOME = "<your-ant-install-folder>"
$env:Path = "$env:ANT_HOME\bin;$env:JAVA_HOME\bin;$env:Path"
```

Notes:
1. Replace `<your-ant-install-folder>` with your actual Ant install path.
1. Session-scoped variables are preferred for first validation so machine-wide settings are not changed unintentionally.

### Step 3: Verify Toolchain Visibility

```powershell
Write-Host "JAVA_HOME=$env:JAVA_HOME"
Write-Host "ANT_HOME=$env:ANT_HOME"
Write-Host "SCORM4ED_TS111_HOME=$env:SCORM4ED_TS111_HOME"
where.exe java
where.exe ant
java --version
ant -version
```

Expected:
1. `where.exe ant` returns a path ending in `ant.bat`.
1. `ant -version` reports Apache Ant 1.10.x.
1. `SCORM4ED_TS111_HOME` resolves to this repository's `software_development` path.

### Step 4: Confirm Build Configuration File Values
Inspect [software_development/build.properties](../software_development/build.properties):
1. Verify `ccHome=${env.SCORM4ED_TS111_HOME}/..` resolves correctly for your chosen execution location.
1. Verify keystore values are intentionally configured (or document that signing will fail until provided).

### Step 5: Dry-Run Build Diagnostics
From [software_development](../software_development):

```powershell
Set-Location software_development
ant -p
ant -diagnostics
```

Capture both outputs as bootstrap evidence.

### Step 6: Attempt Baseline Build
From [software_development](../software_development):

```powershell
ant
```

Record result class:
1. If build succeeds with expected artifacts, classify as at least Class B build-ready.
1. If build fails due signing keystore, classify as expected configuration blocker and log exact error.
1. If build fails due Java compatibility, classify as runtime/toolchain blocker and log exact task/stack trace.

### Step 7: Runtime Launch Check
From [software_development/TestSuite](../software_development/TestSuite):
1. Open `main.htm` in the target browser.
1. Attempt navigation to LMS, SCO, Content Package, and Manifest entry points.
1. Record which flows load, partially load, or fail (with screenshots and notes).

### Step 8: Record Bootstrap Evidence
Create a bootstrap evidence note containing:
1. Timestamp and operator.
1. Output of Step 3 commands.
1. Output of `ant -p` and `ant -diagnostics`.
1. Outcome of `ant` build.
1. Runtime load status by flow group.
1. Assigned class (A/B/C) with rationale.

### Common Failure Modes and Fixes
1. `ant` not recognized:
1. `ANT_HOME` not set in current session.
1. `ANT_HOME\bin` missing from PATH.
1. Terminal started before environment changes.

1. Wrong repository path used by Ant scripts:
1. `SCORM4ED_TS111_HOME` points to an old external folder.
1. Reset variable to this repository's `software_development` folder and retry.

1. Build fails in `buildDebug.xml` at compile stage with `sun.security.action` visibility error:
1. If encountered, confirm branch has the updated [software_development/src/org/adl/util/debug/ADLSimpleFormatter.java](../software_development/src/org/adl/util/debug/ADLSimpleFormatter.java) and rerun.

1. Build stops at `signjar` with `jarsigner: you must enter key password`:
1. Keystore fields in [software_development/build.properties](../software_development/build.properties) are unset or incomplete.
1. This is expected until signing credentials are configured.
1. For P1-02 evidence capture, record as configuration blocker rather than Java compatibility failure.

1. Build fails on signing tasks:
1. Keystore values in [software_development/build.properties](../software_development/build.properties) are placeholders.
1. Either provide valid signing values or document and skip signing-dependent outcomes for baseline capture.

1. Applet/runtime UI fails in modern browser:
1. Treat as expected legacy behavior gap.
1. Capture evidence and classify as Class B or Class C depending on impact.

### Exit Criteria for P1-02
1. Session bootstrap steps run end-to-end at least once.
1. Build diagnostics (`ant -p`, `ant -diagnostics`) captured.
1. At least one `ant` build attempt captured with full output.
1. Runtime launch status captured for all four flow groups.
1. Environment classified as Class A, B, or C with explicit rationale.

### Version History
- v1.0 (2026-10-08): Initial bootstrap runbook aligned to current Windows 11 + OpenJDK 25 host state.
- v1.1 (2026-10-08): Updated with validated Ant availability, corrected `SCORM4ED_TS111_HOME` usage, and confirmed JDK 21/25 compile blocker.
- v1.2 (2026-10-08): Updated after applying source fix; compile blocker cleared and signing configuration identified as current build gate.
