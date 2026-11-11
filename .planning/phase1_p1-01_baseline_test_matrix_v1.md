## Phase 1 P1-01 Baseline Test Matrix (v1)

Status: Proposed (ready for QA + SME + TL approval)
Version: 1.4
Last Updated: 2026-11-11
Backlog Item: P1-01
Source backlog: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)
Source roadmap: [plan_modernization_firstblush.md](plan_modernization_firstblush.md)

### Objective
Define a representative, repeatable baseline matrix across LMS, SCO, Content Package, and Manifest flows so Phase 1 runtime evidence can be captured consistently.

### Legacy Prerequisites Baseline
1. Build/runtime prerequisites are based on [README.md](../README.md):
1. Java 6 update 10 JDK was the original build target, but may not be obtainable from official channels.
1. Apache Ant 1.7.1 was the original build toolchain, but equivalent Ant versions may be used for baseline capture if behavior is documented.
1. Runtime browser must support the legacy Java applet/plugin path used by the test suite.
1. Internet Explorer 8 is treated as a historical target baseline, not a guaranteed downloadable prerequisite.
1. Launch entry point: [software_development/TestSuite/main.htm](../software_development/TestSuite/main.htm)

### Java Runtime Availability Constraint and Decision
1. Constraint: Java 6 era distributions may be unavailable or restricted; modern JDKs are easier to obtain.
1. Confirmed local host state (2026-10-08): OpenJDK 25 is installed.
1. Decision for Phase 1 baseline capture:
1. Use modern JDK (for example OpenJDK 25) for source/build reconnaissance and static analysis tasks.
1. Treat modern JDK execution results as non-equivalent for browser applet runtime behavior unless proven otherwise in a legacy-capable environment.
1. When Java 6-era runtime cannot be obtained, capture evidence under Baseline Class B or C with explicit variance notes.
1. Record Java vendor/version/build string in every evidence notes file.

### Legacy Browser Availability Constraint and Decision
1. Constraint: Internet Explorer 8 is no longer publicly distributed by Microsoft and should be assumed unavailable from official online channels.
1. Approved acquisition order for baseline reproducibility:
1. Existing licensed internal VM image/snapshot containing a known-good IE-era runtime.
1. Existing offline installation media already held by the organization with checksum and provenance notes.
1. If neither is available, use the closest runnable legacy browser/JRE environment that can execute applets, and classify resulting evidence as provisional baseline.
1. Mandatory evidence note for every baseline run:
1. OS version/build
1. Browser product/version
1. JRE/JDK product/version
1. Source/provenance of installer or VM image
1. Any deviations from historical IE8 behavior expectations

### Baseline Classification
1. Class A (Historical): Environment includes known-good IE-era runtime matching archival assumptions.
1. Class B (Equivalent): Environment differs from archival assumptions but successfully runs required flows with documented Java/browser variance.
1. Class C (Provisional): Partial execution only; gaps (for example applet/runtime incompatibility) prevent full baseline parity and must be called out as blockers.

### Execution Decision Update (2026-11-10)
1. A fast P1-04 sweep has been completed in the current host environment (Windows 11 + Microsoft Edge 157) and recorded as Class C blockers.
1. Decision: treat current Phase 1 runtime capture as provisional Class C baseline, pending legacy-capable reruns.
1. Conversion target for first rerun: BL-CP-01 evidence set (`P1-04_CP_BL-CP-01_20261009_ENERG`) to validate whether Class A/B execution is achievable.
1. If legacy-capable runtime is confirmed, rerun high-priority LMS/SCO/MAN cases to replace cross-referenced Class C entries with case-specific Class A/B evidence.

### Execution Decision Update (2026-11-11)
1. Legacy pilot provisioning attempt was investigated and blocked: no usable legacy IE + Java plugin runtime could be established on currently available setup path.
1. Decision: keep Phase 1 baseline status at provisional Class C using existing P1-04 evidence set.
1. Trigger to reopen legacy rerun track: availability of a sanctioned internal legacy image/runtime that can execute the applet-driven flows.

### Matrix Selection Rules
1. Include all four required flow groups: LMS, SCO, Content Package, Manifest.
1. Include at least one conformant-style and one error-handling/variance-style run per group.
1. Prefer in-repo artifacts (for example, local `imsmanifest.xml` files) over external inputs.
1. Record observed result exactly as produced by the legacy tool (pass/fail/warn) without reinterpretation.

### Evidence Naming Convention (for P1-04 and later)
- Run ID format: `P1-04_<GROUP>_<CASEID>_<YYYYMMDD>_<RUNNER>`
- Required artifacts per run:
- Screenshot of start state
- Screenshot of final result state
- Full log export or copied summary text
- Notes file with environment metadata and observed result

### Baseline Matrix
| Case ID | Group | Entry Point | Test Input Anchor | Procedure Summary | Expected Baseline Behavior | Evidence ID Prefix | Priority |
|---|---|---|---|---|---|---|---|
| BL-LMS-01 | LMS | [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](../software_development/TestSuite/LMSRTE/LMSRTEMain.htm) | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_API/imsmanifest.xml](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_API/imsmanifest.xml) | Launch LMS test, follow instruction steps, execute until completion for API-focused package. | Test progresses through instruction and log frames without browser hang; final conformance result is captured as-is. | P1-04_LMS_BL-LMS-01 | High |
| BL-LMS-02 | LMS | [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](../software_development/TestSuite/LMSRTE/LMSRTEMain.htm) | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CM-01/imsmanifest.xml](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CM-01/imsmanifest.xml) | Execute a core data model flow and capture complete log sequence. | Frames remain stable and log output is produced; observed pass/fail/warn is recorded as golden baseline. | P1-04_LMS_BL-LMS-02 | High |
| BL-LMS-03 | LMS | [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](../software_development/TestSuite/LMSRTE/LMSRTEMain.htm) | Invalid or missing package selection | Attempt to start run with invalid input path or canceled selection. | Tool reports validation/selection error path without crashing or deadlocking frames. | P1-04_LMS_BL-LMS-03 | Medium |
| BL-SCO-01 | SCO | [software_development/TestSuite/scoRTE/SCORTEMain.htm](../software_development/TestSuite/scoRTE/SCORTEMain.htm) | [software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTest.htm](../software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTest.htm) | Launch SCO utility, execute a single SCO path, and finish through normal flow controls. | SCO window opens and closes under test control; log frame records lifecycle events and completion result. | P1-04_SCO_BL-SCO-01 | High |
| BL-SCO-02 | SCO | [software_development/TestSuite/scoRTE/SCORTEMain.htm](../software_development/TestSuite/scoRTE/SCORTEMain.htm) | [software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTestFail.htm](../software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTestFail.htm) | Execute known failure-style SCO path to validate failure capture behavior. | Failure path is surfaced in logs and UI result area without orphaned windows or script termination. | P1-04_SCO_BL-SCO-02 | High |
| BL-CP-01 | Content Package | [software_development/TestSuite/contentpackage/ContentPackageMain.htm](../software_development/TestSuite/contentpackage/ContentPackageMain.htm) | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-01/imsmanifest.xml](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-01/imsmanifest.xml) | Run Content Package test in non-PIF mode using in-repo manifest input. | Step workflow advances to completion and outputs log/summary result deterministically for the selected input. | P1-04_CP_BL-CP-01 | High |
| BL-CP-02 | Content Package | [software_development/TestSuite/contentpackage/ContentPackageMain.htm](../software_development/TestSuite/contentpackage/ContentPackageMain.htm) | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-07/imsmanifest.xml](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-07/imsmanifest.xml) | Run second CP sample to capture category variance and message consistency. | Result is captured with full summary output; no uncontrolled script/applet errors during steps. | P1-04_CP_BL-CP-02 | Medium |
| BL-CP-03 | Content Package | [software_development/TestSuite/contentpackage/ContentPackageMain.htm](../software_development/TestSuite/contentpackage/ContentPackageMain.htm) | Missing or invalid manifest path | Attempt CP run with invalid path to capture validation behavior. | User-facing validation/error handling path is observable and loggable. | P1-04_CP_BL-CP-03 | Medium |
| BL-MAN-01 | Manifest | [software_development/TestSuite/contentpackage/ManifestUtilityMain.htm](../software_development/TestSuite/contentpackage/ManifestUtilityMain.htm) | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-01/imsmanifest.xml](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-01/imsmanifest.xml) | Run manifest-only utility against in-repo manifest. | Manifest utility completes with deterministic result output and no frame/applet deadlock. | P1-04_MAN_BL-MAN-01 | High |
| BL-MAN-02 | Manifest | [software_development/TestSuite/contentpackage/ManifestUtilityMain.htm](../software_development/TestSuite/contentpackage/ManifestUtilityMain.htm) | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-07/imsmanifest.xml](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_CT-07/imsmanifest.xml) | Run second manifest sample to capture output variance. | Result differences from BL-MAN-01 are recorded as baseline deltas, not interpreted defects yet. | P1-04_MAN_BL-MAN-02 | Medium |
| BL-MAN-03 | Manifest | [software_development/TestSuite/contentpackage/ManifestUtilityMain.htm](../software_development/TestSuite/contentpackage/ManifestUtilityMain.htm) | Missing or malformed input selection | Attempt run with invalid input to observe utility validation behavior. | Error/validation behavior is captured with screenshot and notes for baseline variance analysis. | P1-04_MAN_BL-MAN-03 | Medium |

### Optional Sentinel Utility Case (Not Required for P1-01 Completion)
| Case ID | Group | Entry Point | Test Input Anchor | Procedure Summary | Expected Baseline Behavior | Evidence ID Prefix | Priority |
|---|---|---|---|---|---|---|---|
| BL-CHK-01 | Checksum Utility | [software_development/TestSuite/checksum/ChecksumTest.htm](../software_development/TestSuite/checksum/ChecksumTest.htm) | CP package and known checksum/log from prior successful CP run | Run checksum validation in both checksum-value mode and log-file mode. | Utility reports success/failure deterministically and displays result message. | P1-04_CHK_BL-CHK-01 | Low |

### Exit Criteria for P1-01
1. Matrix includes representative coverage for LMS, SCO, Content Package, and Manifest groups.
1. Each case has an unambiguous input anchor and expected observable behavior.
1. Evidence naming convention is fixed and accepted for Phase 1 capture tasks.
1. Java availability decision (legacy Java unavailable scenario) is documented and accepted.
1. Legacy browser acquisition decision and baseline classification rules are documented and accepted.
1. QA, SME, and TL provide explicit approval or revision notes.

### Approval Record
- QA: Pending
- SME: Pending
- TL: Pending
- Approval Date: Pending
- Notes: Pending

### Version History
- v1.0 (2026-10-08): Initial baseline matrix for P1-01 with runnable flow anchors and evidence IDs.
- v1.1 (2026-10-08): Replaced hard IE8 prerequisite with legacy runtime acquisition order and baseline classification model.
- v1.2 (2026-10-08): Added Java availability constraint and OpenJDK 25 fallback decision guidance for baseline classification.
- v1.3 (2026-11-10): Added execution decision update after P1-04 Class C sweep and defined legacy pilot rerun target.
- v1.4 (2026-11-11): Recorded blocked legacy pilot provisioning outcome and confirmed continued provisional Class C decision.
